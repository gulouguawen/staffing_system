package com.iflytek.web.service;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class LoggerAspect {
    @Pointcut("execution(* main.web..*Service.add*(..))")
    public void add() {
    }

    @Pointcut("execution(* main.web..*Service.del*(..))")
    public void del() {
    }

    @Pointcut("execution(* main.web..*Service.update*(..))")
    public void update() {
    }

    @Before(value = "add()")
    public void beforeLogger(JoinPoint jp) {
        System.out.println("beforeLogger：" + Arrays.toString(jp.getArgs()));
    }

    @AfterReturning(pointcut = "add()", returning = "ret")
    public void afterReturn(JoinPoint jp, Object ret) {
        System.out.println("afterReturn result:" + ret);
    }

    @AfterThrowing(value = "add()", throwing = "e")
    public void afterThrowing(JoinPoint jp, Exception e) {
        System.out.println("afterThrowing:" + e.getMessage());
    }

}
