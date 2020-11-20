package com.example.mybestpractice.optimize.async;

import android.os.Process;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author :   yuxibing
 * @date :   2020/10/16
 * Describe :
 */
public class ThreadPoolUtil {
    public static ExecutorService getService() {
        return sService;
    }

    private int CPUCOUNT = Runtime.getRuntime().availableProcessors();

    private ThreadPoolExecutor cpuExecutor = new ThreadPoolExecutor(CPUCOUNT, CPUCOUNT,
            30, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>(), sThreadFactory);

    private ThreadPoolExecutor iOExecutor = new ThreadPoolExecutor(64, 64,
            30, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>(), sThreadFactory);

    private static final ThreadFactory sThreadFactory = new ThreadFactory() {
        private final AtomicInteger mCount = new AtomicInteger(1);

        @Override
        public Thread newThread(Runnable r) {
            Thread thread = new Thread(r, "ThreadPoolUtil #" + mCount.getAndIncrement());
            return thread;
        }
    };

    private static ExecutorService sService = (ThreadPoolExecutor) Executors.newFixedThreadPool(5, new ThreadFactory() {
        @Override
        public Thread newThread(Runnable r) {
            Thread thread = new Thread(r, "ThreadPoolUtil");
            //通过ThreadFactory，修改线程名字或者优先级
//            thread.setName("ThreadPoolUtil");
            Process.setThreadPriority(Process.THREAD_PRIORITY_BACKGROUND);
            return thread;
        }
    });
}
