package com.jay.designpattern.proxy;

public class RealSubject implements Subject {

    @Override
    public void operation() {
        System.out.println("目标类");
    }

}
