package com.lzk.oom;

/**
 * @author : 廖梓楷
 * file : JavaVMStackOOM.java
 * 该方法看懂就行，不要运行，系统会卡顿
 * IDEA 的vm option中添加以下配置
 * -Xss2M
 */
public class JavaVMStackOOM {
    private void dontStop() {
        while(true) {
            
        }
    }
    
    private void stackLeakByThread() {
        while(true) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    dontStop();
                }
            });
            thread.start();
        }
    }
    public static void main(String args[]) {
        JavaVMStackOOM oom = new JavaVMStackOOM();
        oom.stackLeakByThread();
    }
    
}
