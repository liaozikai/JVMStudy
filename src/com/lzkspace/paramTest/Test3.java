package com.lzkspace.paramTest;

import java.util.Vector;

/**
 * @author : liaozikai
 * file : Test3.java
 */
public class Test3 {
    public static void main(String[] args) {
        // -Xms1m -Xmx1m -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=F:/JVMStudy/Test3.dump
        // 堆内存溢出
        Vector v = new Vector();
        for (int i = 0; i < 5; i++) {
            v.add(new Byte[1 * 1024 * 1024]);
        }
    }
}
