package com.lzkspace.paramTest;

/**
 * @author : liaozikai
 * file : Test1.java
 * 通过观看网络教学视频后，对jvm有更深入的理解，故而再次编写一些例子巩固
 * 
 */
public class Test1 {

    public static void main(String[] args) {
        
        // -Xms5M -Xmx20m -XX:+PrintGCDetails -XX:+UseSerialGC -XX:+PrintCommandLineFlags
        /**
         * [GC (Allocation Failure) [DefNew: 1664K->191K(1856K), 0.0016649 secs] 1664K->602K(5952K), 0.0025013 secs] 
         * [Times: user=0.00 sys=0.00, real=0.00 secs] 
         * 日志解析：
         * Allocation Failure – 触发 GC 的原因。本次GC事件, 是由于年轻代中没有空间来存放新的数据结构引起的
         * DefNew – 垃圾收集器的名称。这个神秘的名字表示的是在年轻代中使用的: 单线程, 标记-复制(mark-copy), 全线暂停(STW) 垃圾收集器。
         * 1664K->191K – 在垃圾收集之前和之后年轻代的使用量。
         * 1856K – 年轻代总的空间大小。
         * 1664K->602K – 在垃圾收集之前和之后整个堆内存的使用情况。
         * 5952K - 可用堆的总空间大小
         */
        // 查看GC信息
        System.out.println("max memory: " + Runtime.getRuntime().maxMemory());
        System.out.println("free memory: " + Runtime.getRuntime().freeMemory());
        System.out.println("total memory: " + Runtime.getRuntime().totalMemory());
        
        byte[] b1 = new byte[1*1024*1024];
        System.out.println("分配了1M");
        System.out.println("max memory: " + Runtime.getRuntime().maxMemory());
        System.out.println("free memory: " + Runtime.getRuntime().freeMemory());
        System.out.println("total memory: " + Runtime.getRuntime().totalMemory());

        byte[] b2 = new byte[4*1024*1024];
        System.out.println("分配了4M");
        System.out.println("max memory: " + Runtime.getRuntime().maxMemory());
        System.out.println("free memory: " + Runtime.getRuntime().freeMemory());
        System.out.println("total memory: " + Runtime.getRuntime().totalMemory());
        
    }
}
