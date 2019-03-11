package com.lzk.gc;

/**
 * @author : 廖梓楷
 * file : TenuringThresholdGC.java
 * IDEA 的vm option中添加以下配置
 * -verbose:gc -Xms20M -Xmx20m -Xmn10m -XX:+PrintGCDetails -XX:SurvivorRatio=8 
 * -XX:+UseSerialGC -XX:MaxTenuringThreshold=15 -XX:+PrintTenuringDistribution
 * 从日志可以看出，minor GC的频率是很高的，第一次surivivor的空间变小是由于allocation1和allocation2
 * 进入了老年代。而从最终结果可以看出allocation1和allocation2在老年代，而allocation3在eden区。
 * idea设置MaxTenuringThreshold分别为1或者15，但日志显示都是将allocation1分配到老年区，但其并未说明
 * 如何控制MinorGC的频率。
 */
public class TenuringThresholdGC {
    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {
        testTenuringThreshold();
    }
    
    public static void testTenuringThreshold() {
        byte[] allocation1,allocation2,allocation3,allocation4;
        allocation1 = new byte[_1MB / 4];
        // 什么时候进入老年代取决于XX：MaxTenuringThreshold设置
//        allocation2 = new byte[4 * _1MB];
        
        
        allocation2 = new byte[_1MB/4];
        allocation3 = new byte[4 * _1MB];
        allocation4 = new byte[4 * _1MB];
        allocation4 = null;
        allocation4 = new byte[4 * _1MB];
    }
}
