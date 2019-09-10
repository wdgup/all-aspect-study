package com.wdg.concurrent;


import java.util.concurrent.*;

/**
 * User: wangdaogang
 * Date: 2019/9/10
 * Description: No Description
 */
public class ThreadPool {

    public static final ExecutorService executorService = new ThreadPoolExecutor(
            Runtime.getRuntime().availableProcessors(),
            Runtime.getRuntime().availableProcessors(),
            0,
            TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(2)
            );

}