package com.lzk.gc;

/**
 * @author : 廖梓楷
 * file : ReferenceCountingGC.java
 * IDEA 的vm option中添加以下配置
 * -XX:+PrintGCDetails
 * 从输出的结果可以看出，PSYoungGen从6758K到632K，说明内存有回收，则jvm不是采用计数法来进行垃圾回收
 */
public class ReferenceCountingGC {
    public Object instance = null;
    private static final int _1MB = 1024 * 1024;
    
    // 通过定义对象来占用内存，从而观察对象是否被回收
    private byte[] bigSize = new byte[2 * _1MB];
    
    public static void testGC() {
        ReferenceCountingGC objA = new ReferenceCountingGC();
        ReferenceCountingGC objB = new ReferenceCountingGC();
        objA.instance = objB;
        objB.instance = objA;
        objA = null;
        objB = null;
        System.gc();
    }

    public static void main(String[] args) {
        testGC();
    }
}
