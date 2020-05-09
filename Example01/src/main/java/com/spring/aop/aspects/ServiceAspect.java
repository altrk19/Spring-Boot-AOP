package com.spring.aop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceAspect {

    //aspect specific method
    @Before("execution(* com.spring.aop.service.MessageService.printMessage(..))")
    public void before(JoinPoint joinPoint) {
        System.out.println("captured parameter before print message, param: " + joinPoint.getArgs()[0]);
        System.out.println(joinPoint.getSignature());
    }

    //aspect all methods in service package
    @After("execution(* com.spring.aop.service.*.*(..))")
    public void after(JoinPoint joinPoint) {
        System.out.println("captured parameter after print message, param: " + joinPoint.getArgs()[0]);
        System.out.println(joinPoint.getSignature());
    }
}