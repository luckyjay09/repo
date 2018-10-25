package com.jay.designpattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 *  生成代理对象的过程
 *  1. 生成源代码
 *  2. 将源代码输出到磁盘，保存为xx.java
 *  3. 编译源代码，生成.class
 *  4. 将.class文件中的内容加载到jvm
 *  5. 返回被代理的对象
 */
public class ProxyFactory {

    private Object target;
    private Advice advice;

    public ProxyFactory(Object target, Advice advice) {
        this.target = target;
        this.advice = advice;
    }

    public Object getProxyInstance() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        //1. 代理对象  2.目标类中的方法 3.方法中的参数
//                        System.out.println("目标类方法执行前");
                        advice.before();
                        Object invoke = method.invoke(target, args);
//                        System.out.println("目标类方法执行后");
                        advice.after();
                        return invoke;
                    }
                });
    }
}
