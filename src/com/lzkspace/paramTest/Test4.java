package com.lzkspace.paramTest;

/**
 * @author : liaozikai
 * file : Test4.java
 */
public class Test4 {
    /**
     * -Xss1m
     * -Xss5m
     * -Xss 设置栈的深度
     */
    // 栈调用深度
    private static int count;

    public static void recursion() {
        count++;
        recursion();
    }

    public static void main(String[] args) {
        try {
            recursion();
        } catch (Throwable t) {
            System.out.println("调用最大深入：" + count);
            t.printStackTrace();
        }
    }
}
