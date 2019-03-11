package com.lzk.oom;

/**
 * @author : 廖梓楷
 * file : RuntimeConstantPoolOOM.java
 */
public class RuntimeConstantPoolOOM2 {
    
    // 结果是
    //1: true jdk1.7跟1.6不一样，intern方法不会复制内容到常量池，而是复制引用，故而第一次为true
    //2: false 因为jvm会自动调用System类中的初始化方法，java会被存放在常量池中，故而第二次被使用，返回false
    //3: true 解释同1相同，返回true
    //4: false 由于3已经创建了nihao，并且intern方法指向了3的存放位置。而4的intern跟3的intern指向相同，但是str4
    // 在堆中生成的nihao与3在堆中生成的nihao内存位置不同，故指向不同
    public static void internTest() {
        String str1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1.intern()==str1);
        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern()==str2);
        String str3 = new StringBuilder("ni").append("hao").toString();
        System.out.println(str3.intern()==str3);
        String str4 = new StringBuilder("nihao").toString();
        System.out.println(str4.intern()==str4);
    }
    public static void main(String[] args) {
        internTest();
    }
}
