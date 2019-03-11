package com.lzk.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : 廖梓楷
 * file : RuntimeConstantPoolOOM.java
 * IDEA 的vm option中添加以下配置
 * -XX:PermSize=2M -XX:MaxPermSize=2M
 * 由返回结果可知字符串常量池存放在永久代中
 */
public class RuntimeConstantPoolOOM1 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        int i = 0;
        // 字符串存放在常量池中，如果不断定义字符串，可能会导致回收
        // 故而用list的方式来对字符串内容进行引用，形成强引用，不会导致Full GC
        while(true) { // 通过不断往常量池增加内容导致内存溢出
            list.add(String.valueOf(i++).intern());
        }
    }
}
