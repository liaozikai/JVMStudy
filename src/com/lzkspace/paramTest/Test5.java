package com.lzkspace.paramTest;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : liaozikai
 * file : Test5.java
 */
public class Test5 {
    public static void main(String[] args) {
        // 初始的对象在eden区
        // 参数：-Xmx64M -Xms64M -XX:+PrintGCDetails
        for (int i = 0; i < 5; i++) {
            byte[] b = new byte[1024 * 1024];
        }


        /**
         * -Xms1024M -Xmx1024m -XX:+PrintGCDetails -XX:+UseSerialGC -XX:MaxTenuringThreshold=15 -XX:+PrintHeapAtGC
         * 从输出日志可以看出，由于map对象一致引用这5MB的堆内存，而后面的循环由于不断新增对象消耗内存而不断导致垃圾回收，当15次之后，
         * 可看到map引动的对象内容进入了老年代。可通过修改-XX:MaxTenuringThreshold=15来设置进入老年代经过了垃圾回收次数
         */
        Map<Integer,byte[]> map = new HashMap<Integer, byte[]>();
        for (int i = 0; i < 5; i++) {
            byte[] b = new byte[1024 * 1024];
            map.put(i,b);
        }

        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 300; j++) {
                byte[] b = new byte[1024 * 1024];
            }
        }

    }
}
