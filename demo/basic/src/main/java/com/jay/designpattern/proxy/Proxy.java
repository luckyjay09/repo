package com.jay.designpattern.proxy;

public class Proxy implements Subject {

    private RealSubject realSubject;

    public Proxy() {
        realSubject = new RealSubject();
    }

    @Override
    public void operation() {
        realSubject.operation();
    }
}
