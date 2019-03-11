package com.lzk.tool;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author : 廖梓楷
 * file : BTraceTest.java
 * 通过BTrace插件来监控跟踪日志，可查看到数据
 * 注意：在visualVM的插件中下载BTrace，可能会出现下载BTrace1.6不匹配jdk1.8的情况，
 * 即自动下载的BTrace版本太旧。这时可点击visualVM故障排除指南，进入官网，进入插件中心，
 * 选择手动下载插件，并且api，api for visual及Workbench都要下载，之后导入时要一起导入。
 * 启动后，在console回车即可观察到数据变化
 * 调试文件放在file里面
 */
public class BTraceTest {
    public int add(int a,int b) {
        return a+b;
    }

    public static void main(String[] args) throws Exception{
        BTraceTest test = new BTraceTest();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0 ; i < 10; i++) {
            reader.readLine();
            int a = (int) Math.round(Math.random() * 1000);
            int b = (int) Math.round(Math.random() * 1000);
            System.out.println(test.add(a,b));
        }
    }
}

