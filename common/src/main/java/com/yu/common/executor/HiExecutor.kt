package com.yu.common.executor

import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.annotation.IntRange
import java.util.*
import java.util.concurrent.*
import java.util.concurrent.atomic.AtomicLong
import java.util.concurrent.locks.Condition
import java.util.concurrent.locks.ReentrantLock

/**
 * @author   :   yuxibing
 * @date   :   2021/7/8
 * Describe :
 */
object HiExecutor {

    private const val TAG: String = "HiExecutor"
    private val hiExecutor: ThreadPoolExecutor
    private var isPaused: Boolean = false
    private var lock: ReentrantLock = ReentrantLock()
    private var pauseCondition: Condition
    private val mainHandler = Handler(Looper.getMainLooper())


    init {
        pauseCondition = lock.newCondition()

        val cpuCount = Runtime.getRuntime().availableProcessors()
        val corePoolSize = cpuCount + 1
        val maxPoolSize = cpuCount * 2 + 1
        val keepAliveTime = 30L
        val unit = TimeUnit.SECONDS
        val blockingQueue: PriorityBlockingQueue<out Runnable> = PriorityBlockingQueue()

        val seq = AtomicLong()
        val threadFactory = ThreadFactory {
            val thread = Thread(it)
            // 线程名:hi-executor-0
            thread.name = "hi-executor-" + seq.getAndIncrement()
            return@ThreadFactory thread
        }

        hiExecutor = object : ThreadPoolExecutor(
            corePoolSize,
            maxPoolSize,
            keepAliveTime,
            unit,
            blockingQueue as BlockingQueue<Runnable>,
            threadFactory
        ) {
            override fun beforeExecute(t: Thread?, r: Runnable?) {
                // 如果暂停线程
                if (isPaused) {
                    lock.lock()
                    try {
                        pauseCondition.await()
                    } finally {
                        lock.unlock()
                    }

                }
            }

            override fun afterExecute(r: Runnable?, t: Throwable?) {
                //可监控线程池耗时任务,线程创建数量,正在运行的数量
                Log.e(TAG, "已执行完的任务的优先级是：" + (r as PriorityRunnable).priority)
            }
        }

    }

    @JvmOverloads
    fun execute(@IntRange(from = 0, to = 10) priority: Int = 0, runnable: Runnable) {
        hiExecutor.execute(PriorityRunnable(priority, runnable))
    }

    @JvmOverloads
    fun execute(@IntRange(from = 0, to = 10) priority: Int = 0, runnable: Callable<*>) {
        hiExecutor.execute(PriorityRunnable(priority, runnable))
    }


    /**
     * 不带返回值
     */
    class PriorityRunnable(val priority: Int, private val runnable: Runnable) : Runnable,
        Comparable<PriorityRunnable> {
        override fun run() {
            runnable.run()
        }

        override fun compareTo(other: PriorityRunnable): Int {
            return if (this.priority < other.priority) 1 else if (this.priority > other.priority) -1 else 0
        }

    }

    /**
     * 带返回值
     */
    abstract class Callable<T> : Runnable {
        override fun run() {
            mainHandler.post {
                onPrepare()
            }

            val t: T = onBackground()

            // 移除所有消息，防止需要执行onCompleted了，onPrepare还没被执行，那就不需要执行了
            mainHandler.removeCallbacksAndMessages(null)
            mainHandler.post { onCompleted(t) }
        }

        open fun onPrepare() {
            // 转菊花
        }

        abstract fun onBackground(): T
        abstract fun onCompleted(t: T)
    }

    fun pause() {
        lock.lock()
        try {
            if (isPaused) {
                return
            }
            isPaused = true
        } finally {
            lock.unlock()
        }
        Log.e(TAG, "hiExecutor is paused")
    }

    fun resume() {
        lock.lock()
        try {
            if (!isPaused) {
                return
            }
            isPaused = false
            pauseCondition.signalAll()
        } finally {
            lock.unlock()
        }
        Log.e(TAG, "hiExecutor is resumed")
    }
}