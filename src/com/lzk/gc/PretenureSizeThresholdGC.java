package com.lzk.gc;

/**
 * @author : 廖梓楷
 * file : PretenureSizeThresholdGC.java
 * IDEA 的vm option中添加以下配置
 * -verbose:gc -Xms20M -Xmx20m -Xmn10m -XX:+PrintGCDetails -XX:SurvivorRatio=8 
 * -XX:+UseSerialGC -XX:PretenureSizeThreshold=3145728
 * 其中PretenureSizeThreshold=3145728即为 3 * 1024*1024 用于设置大对象生成时分配内存空间的位置，
 * 即当对象大于 3MB时，则直接将其分配到老年代，避免了在Eden区和两个Survivior区发生大量的内存复制（新生代一般采用复制算法）
 */
public class PretenureSizeThresholdGC {
    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {
        byte[] allocation;
        allocation = new byte[4 * _1MB];
    }
}
