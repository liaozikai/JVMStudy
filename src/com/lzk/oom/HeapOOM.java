package com.lzk.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : 廖梓楷
 * file : HeapOOM.java
 * OOM溢出测试，即内存堆溢出
 * IDEA 的vm option中添加以下配置
 * -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 */
public class HeapOOM {
    static class OOMObject {
        
    }
    
    // 若是没有手动设置堆大小，可以通过鲁大师看到内存占用在不断提升,最后抛出异常
    public static void main(String args[]) {
        List<OOMObject> oomObjectList = new ArrayList<OOMObject>();
        while(true) {
            oomObjectList.add(new OOMObject());
        }
    }
}
