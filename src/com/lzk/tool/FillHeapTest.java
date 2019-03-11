package com.lzk.tool;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : 廖梓楷
 * file : FillHeapTest.java
 * 由于本案例采用1.8jdk，故与深入jvm上的结果不同，
 * 从内存显示图下角的GC时间，都可以看出其不同，一个是MarkSweepCompact，标志清除压缩算法
 * 而jdk1.8是并行标志算法，但从jdk1.8中可看出，系统运行过程eden区自动减少，则survivor会自动增加，
 * 这是由于随着时间运行，eden区对象往survivor区转移，等到一定时间对象不会被回收，则又转移到老年区。
 */
public class FillHeapTest {
    static class OOMObject{
        public byte[] placeholder = new byte[64 * 1024];
    }
    
    public static void fillHeap(int num) throws  InterruptedException {
        List<OOMObject> list = new ArrayList<OOMObject>();
        for(int i =0;i < num; i++) {
            Thread.sleep(50);
            list.add(new OOMObject());
        }
        System.gc();
    }

    public static void main(String[] args) throws Exception{
        System.out.println("执行开始");
        fillHeap(100);
        System.out.println("执行结束");
        System.out.println("休眠10s，等线程全部跑完");
        Thread.sleep(10000);
        System.out.println("垃圾回收");
        System.gc();
    }
}
