package com.lzk.gc;

/**
 * @author : 廖梓楷
 * file : FinalizeEscapeGC.java
 * 该类执行过程中，由于SAVE_HOOK = null并执行gc操作，本来该对象应该被回收，由于继承了Object对象的finalize方法，
 * 则gc执行之前会执行finalize方法，故而重新对SAVE_HOOK重新激活，导致对象由不可达变为可达，故而对象不被回收。
 * 又由于finalize只执行一遍，从而第二次gc会将对象回收而不执行finalize。
 */
public class FinalizeEscapeGC {
    public static FinalizeEscapeGC SAVE_HOOK = null;
    public void isAlive() {
        System.out.println("yes,i am still live :");
    }
    
    protected void finalize() throws Throwable {
        super.finalize(); // Object自带该方法
        System.out.println("finalize method executed!");
        FinalizeEscapeGC.SAVE_HOOK = this;
    }

    public static void main(String[] args) throws  Throwable{
        SAVE_HOOK = new FinalizeEscapeGC();
        
        SAVE_HOOK = null;
        System.gc();
        
        Thread.sleep(500);
        if(SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("no,i am dead:(");
        }

        SAVE_HOOK = null;
        System.gc();

        Thread.sleep(500);
        if(SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("no,i am dead:(");
        }
    }
    
}
