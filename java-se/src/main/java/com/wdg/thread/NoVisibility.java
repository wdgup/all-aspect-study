package com.wdg.thread;

/**
 * User: wangdaogang
 * Date: 2019/9/12
 * Description: No Description
 */
public class NoVisibility {
    private static boolean ready;
    private static int number;
    private static class ReaderThread extends Thread{
        private String name;
        public ReaderThread(String name){
            super();
            this.name = name;
            super.setName(name);
        }
        @Override
        public void run() {
            while (!ready){
                Thread.yield();
                System.out.println(number);
            }
        }
    }

    public static void main(String[] args) {
        runThread();
        new ReaderThread("one").start();
        new ReaderThread("two").start();
    }

    static synchronized void runThread(){
        System.out.println(ready);
        new ReaderThread("synchronized").start();
        number = 42;
        ready = true;
    }
}
