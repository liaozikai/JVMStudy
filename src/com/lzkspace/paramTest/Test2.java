package com.lzkspace.paramTest;

/**
 * @author : liaozikai
 * file : Test2.java
 */
public class Test2 {
    public static void main(String[] args) {

        /**
         * 第一次配置(eden 2 = from 1 + to 1)
         * 特殊说明：from和to的空间大小一般是一样的，并且设置from和to的原因是由于新生代可能采用 复制 算法来进行垃圾回收，
         * 故而需要保留一个空闲空间作为有效对象复制后进行存放
         * 从日志可看出，space存放的内容大小比值中，eden:from为2：1
         */
        // -Xms20m -Xmx20m -Xmn1m -XX:SurvivorRatio=2 -XX:+PrintGCDetails -XX:+UseSerialGC

        // 第二次配置
        // -Xms20m -Xmx20m -Xmn7m -XX:SurvivorRatio=2 -XX:+PrintGCDetails -XX:+UseSerialGC

        /**
         * 第三次配置
         * -XX:NewRatio=老年代/新生代
         * -Xms20m -Xmx20m -XX:NewRatio=2 -XX:+PrintGCDetails -XX:+UseSerialGC
         * 从日志可以看出，total中老年代/新生代为 2：1
         */
         

        byte[] b = null;
        // 连续向系统申请10MB空间
        for (int i = 0; i < 10; i++) {
            b = new byte[1 * 1024 * 1024];
        }
    }
}
