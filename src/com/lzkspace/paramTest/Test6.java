package com.lzkspace.paramTest;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : liaozikai
 * file : Test6.java
 */
public class Test6 {
    public static void main(String[] args) {

        /**
         * -Xms30M -Xmx30m -XX:+PrintGCDetails -XX:+UseSerialGC -XX:PretenureSizeThreshold=1000
         * 表示当对象大小大于1000B的时候，对象直接进入老年区
         * 从输出的日志可以看出，老年区使用的内存很少，也就是说对象创建的时候并没有直接进入老年区，原因是虚拟机对于体积不大的
         * 对象，会优先将数据分配到TLAB区域中，故而需设置TLAB的大小
         */
        /*Map<Integer,byte[]> map = new HashMap<Integer, byte[]>();
        for (int i = 0; i < 5; i++) {
            byte[] b = new byte[1024];
            map.put(i,b);
        }*/

        /**
          * -Xms30M -Xmx30m -XX:+PrintGCDetails -XX:+UseSerialGC -XX:PretenureSizeThreshold=1000
          * -XX:+UseTLAB -XX:TLABSize=102400 -XX:-ResizeTLAB 
         * 从日志可以看出，对象直接在被分配到老年代
         */
        Map<Integer,byte[]> map = new HashMap<Integer, byte[]>();
        for (int i = 0; i < 5; i++) {
            byte[] b = new byte[1024*1024];
            map.put(i,b);
        }
    }
}
