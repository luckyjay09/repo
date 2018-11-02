package com.jay.ssm.spring;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

//@Aspect //表示这是一个通知类
public class MyAdvice {

//    @Pointcut("execution(* com.jay.ssm.service..*ServiceImpl.*(..))");
    //指定定切点
    public void pc() {

    }

//    @Before("MyAdvice.pc()")
    //应用切点 跟下面的方法同效果
    public void before() {
        System.out.println("前置通知");
    }

//    @Around("execution(* com.jay.ssm.service..*ServiceImpl.*(..))")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        System.out.println("环绕通知 前部分");
        Object proceed = point.proceed();
        System.out.println("环绕通知 后部分");
        return proceed;
    }

//    @After("execution(* com.jay.ssm.service..*ServiceImpl.*(..))")
    public void after() {
        System.out.println("后置通知 异常也调用");
    }

//    @AfterReturning("execution(* com.jay.ssm.service..*ServiceImpl.*(..))")
    public void afterReturning() {
        System.out.println("后置通知 出现异常不会调用");
    }

//    @AfterThrowing("execution(* com.jay.ssm.service..*ServiceImpl.*(..))")
    public void afterException() {
        System.out.println("后置通知 出现异常才调用");
    }

}
