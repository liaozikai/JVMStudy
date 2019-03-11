package com.lzk.tool;

/**
 * @author : 廖梓楷
 * file : DeadLockTset.java
 * 该项目执行结果与深入jvm执行结果一致。其原因写的也较清楚，因为
 * Integer.valueOf(int)中，参数为-128到127,是直接返回Integer对象的。
 * 这样，在两个线程的循环过程中，可能存在线程1持有对象值为1的锁，线程2持有对象值为2的锁，
 * 则在run方法中，加锁的操作则会卡住，故而形成死锁
 */
public class DeadLockTest {
    static class SynAddRunable implements Runnable {
        int a,b;
        public SynAddRunable(int a,int b) {
            this.a = a;
            this.b = b;
        }
        
        @Override
        public void run() {
            synchronized (Integer.valueOf(a)) {
                synchronized (Integer.valueOf(b)) {
                    System.out.println(a + b);
                }
            }
        }
    }

    public static void main(String[] args) {
        for(int i = 0; i < 100; i++) {
            new Thread(new SynAddRunable(1,2)).start();
            new Thread(new SynAddRunable(2,1)).start();
        }
    }
}
