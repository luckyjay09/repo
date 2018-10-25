package com.jay.designpattern.proxy;

public class Advice {

    public void before() {
        System.out.println("Advice: 通知前");
    }

    public void after() {
        System.out.println("Advice: 通知后");
    }
}
