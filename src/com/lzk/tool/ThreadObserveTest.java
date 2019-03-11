package com.lzk.tool;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author : 廖梓楷
 * file : ThreadObserveTest.java
 * 该项目执行结果与jvm项目执行结果一致，就是两个线程，
 * 一个处于运行状态，一个处于阻塞状态
 */
public class ThreadObserveTest {
    public static void createBusyThread() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true);
            }
        },"testBusyThread");
        thread.start();
    }
    
    public static void createLockThread(final Object lock) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    try{
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        },"testLockThread");
        thread.start();
    }

    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
        createBusyThread();
        bufferedReader.readLine();
        Object object = new Object();
        createLockThread(object);
    }
}
