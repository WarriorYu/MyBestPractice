package com.example.mybestpractice.mooctixi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import com.example.mybestpractice.R
import com.example.mybestpractice.databinding.ActivityExecutorBinding
import com.yu.common.executor.HiExecutor

class ExecutorActivity : AppCompatActivity() {
    private var paused = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_executor)
        val bind = ActivityExecutorBinding.inflate(LayoutInflater.from(this))
        setContentView(bind.root)

        // 按优先级去执行任务
        bind.btn1.setOnClickListener {
            for (priority in 0..9) {
                HiExecutor.execute(priority, object : Runnable {
                    override fun run() {
                        Thread.sleep(1000 - priority * 100L)
                    }
                })
            }
        }

        // 暂停/恢复线程池
        bind.btn2.setOnClickListener {
            if (paused) {
                HiExecutor.resume()
            } else {
                HiExecutor.pause()
            }
            paused = !paused
        }

        bind.btn3.setOnClickListener {
            HiExecutor.execute(runnable = object : HiExecutor.Callable<String>() {
                override fun onBackground(): String {
                    Log.e("ExecutorActivity", "onBackground-当前线程是：${Thread.currentThread().name}")
                    return "我是异步任务的结果"
                }

                override fun onCompleted(result: String) {
                    Log.e("ExecutorActivity", "onCompleted-当前线程是：${Thread.currentThread().name}")
                    Log.e("ExecutorActivity", "onCompleted-任务结果是result:${result}")
                }

            })
        }
    }
}