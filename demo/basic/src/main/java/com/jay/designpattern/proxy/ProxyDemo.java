package com.jay.designpattern.proxy;

import sun.misc.ProxyGenerator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLOutput;

/**
 *  策略模式：过程不同 结果一样
 *  原型模式：过程相同 结果不一样；数据内容一样，但实例不同
 *  模板模式：执行流程一样，但中间有些步骤不同
 */
public class ProxyDemo {

    public static void main(String[] args) throws IOException {
//        Proxy proxy = new Proxy();
//        proxy.operation();


        /**
         *  原理
         *  1. 拿到被代理对象的引用，获取他的接口
         *  2. JDK代理重新生成一个类，并实现目标对象的接口
         *  3. 重新动态生成一个class字节码
         *  4. 编译
         */
        ProxyFactory proxyFactory = new ProxyFactory(new RealSubject(), new Advice());
        Subject proxy = (Subject) proxyFactory.getProxyInstance();
        proxy.operation();
        System.out.println(proxy.getClass());

        byte[] data = ProxyGenerator.generateProxyClass("$Proxy0", new Class[]{proxy.getClass()});
        FileOutputStream fos = new FileOutputStream("$Proxy0");
        fos.write(data);
        fos.close();
        //反编译即可查看文件内容
    }


}
