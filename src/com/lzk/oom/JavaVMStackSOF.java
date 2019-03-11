package com.lzk.oom;

/**
 * @author : 廖梓楷
 * file : JavaVMStackSOF.java
 *  SOF溢出测试，即栈溢出
 * IDEA 的vm option中添加以下配置
 * -Xss128k
 * 
 */
public class JavaVMStackSOF {
    private int stackLength = 1;
    
    public void stackLeak() {
        stackLength++;
        stackLeak();
    }
    // 输出987 说明调用了987次方法后，虚拟机栈满并溢出
    public static void main(String args[]) throws Throwable{
        JavaVMStackSOF oom = new JavaVMStackSOF();
        try {
            oom.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack Length: " + oom.stackLength);
            throw e;
        }
    }
}
