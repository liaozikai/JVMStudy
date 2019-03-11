package com.lzk.oom;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author : 廖梓楷
 * file : JavaMethodAreaOOM.java
 *  IDEA 的vm option中添加以下配置
 * -XX:PermSize=2M -XX:MaxPermSize=2M
 * 深入jvm这本书配置的是10M，报错时只是简单报错，故而我将永久代大小设置为2M，报的错
 * 与深入jvm一致。我猜想设置为10M时，可能是使用了堆外内存。这个验证等有思路有时间再思考
 */
public class JavaMethodAreaOOM {
    public static void main(final String[] args) {
        while(true) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(OOMObject.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                    return methodProxy.invokeSuper(o,args);
                }
            });
            try {
                enhancer.create();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    static class OOMObject {
        
    }
}
