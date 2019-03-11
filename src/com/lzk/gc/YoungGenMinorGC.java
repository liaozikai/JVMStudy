package com.lzk.gc;

/**
 * @author : 廖梓楷
 * file : YoungGenMinorGC.java
 * 通过分配内存查看新生代内存回收情况。此次实现与jvm结果不同，注意
 * 使用的是client模式和serial/serial old收集器的内存分配和回收策略。
 * IDEA 的vm option中添加以下配置
 * -verbose:gc -Xms20M -Xmx20m -Xmn10m -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:+UseSerialGC
 * 此处没有设置client模式，server模式与client在性能和指令编译解释有所区别，但总体结果与jvm一书结果相差不大
 */
public class YoungGenMinorGC {
    private  static  final int _1MB = 1024 * 1024;
    public static void testAllocation() {
        byte[] allocation1,allocation2,allocation3,allocation4;
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        allocation4 = new byte[4 * _1MB]; // 出现一次GC
    }

    public static void main(String[] args) {
        testAllocation();
    }
}
