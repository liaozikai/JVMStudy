package com.lzk.oom;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author : 廖梓楷
 * file : DirectMemoryOOM.java
 *  IDEA 的vm option中添加以下配置
 * -Xmx20m -XX:MaxDirectMemorySize=10M
 * 由于调用下面的方法使用的是堆外内存，故而导致溢出
 */
public class DirectMemoryOOM {
    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) throws Exception{
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);
        while (true) {
            unsafe.allocateMemory(_1MB);
        }
    }
}
