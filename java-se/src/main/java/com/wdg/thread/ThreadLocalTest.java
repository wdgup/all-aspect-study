package com.wdg.thread;

import com.alibaba.fastjson.JSONObject;

import java.util.LinkedList;
import java.util.concurrent.*;

/**
 * User: wangdaogang
 * Date: 2019/9/12
 * Description: No Description
 */
public class ThreadLocalTest {
    private static ThreadLocal<JSONObject> threadLocal = new ThreadLocal<>();

    private static LinkedList<ThreadLocal<JSONObject>> linkedList  = new LinkedList<>();
    private static ExecutorService executor = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(),Runtime.getRuntime().availableProcessors(),0L, TimeUnit.SECONDS,new ArrayBlockingQueue<>(1));

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        executor.submit(new A()).get();
        executor.submit(new B()).get();
        executor.submit(new C()).get();
        executor.submit(new D()).get();
        executor.shutdown();
        linkedList.stream().map(ThreadLocal::get).forEach(System.out::println);
    }
    static class A implements Callable<JSONObject>{

        @Override
        public JSONObject call() throws Exception {
            System.out.println("A........执行");
            JSONObject a = new JSONObject();
            a.put("name","A");
            threadLocal.set(a);
            linkedList.addLast(threadLocal);
            return a;
        }
    }
    static class B implements Callable<JSONObject>{

        @Override
        public JSONObject call() throws Exception {
            System.out.println("B........执行");
            JSONObject b = new JSONObject();
            b.put("name","B");
            threadLocal.set(b);
            linkedList.addLast(threadLocal);
            return b;
        }
    }
    static class C implements Callable<JSONObject>{

        @Override
        public JSONObject call() throws Exception {
            System.out.println("C........执行");
            JSONObject b = new JSONObject();
            b.put("name","C");
            threadLocal.set(b);
            linkedList.addLast(threadLocal);
            return b;
        }
    }
    static class D implements Callable<JSONObject>{

        @Override
        public JSONObject call() throws Exception {
            System.out.println("D........执行");
            JSONObject b = new JSONObject();
            b.put("name","D");
            threadLocal.set(b);
            linkedList.addLast(threadLocal);
            return b;
        }
    }
}
