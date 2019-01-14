package com.example.demo6.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author
 * @date
 */
@Aspect
@Component
public class AopTest {
    /**
     * 切点
     */
    @Pointcut("execution(public * com.example.demo6.controller.*.*(..))")
    public void funcationAspect(){}

    /**
     * 前置通知
     * @param joinPoint
     */
    @Before("funcationAspect()")
    public void beforeCut(JoinPoint joinPoint){
        System.out.println("before");
        System.out.println(joinPoint.getTarget()+","+joinPoint.getClass()+","+joinPoint.getKind());
    }

    /**
     * 环绕通知
     * @param proceedingJoinPoint
     * @return
     * @throws Throwable
     */
    @Around("funcationAspect()")
    public Object aroundCut(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("Around");
        System.out.println(proceedingJoinPoint.getClass());
        return proceedingJoinPoint.proceed();
    }

    /**
     * 后置通知
     * @param joinPoint
     */
    @After("funcationAspect()")
    public void afterCut(JoinPoint joinPoint){
        System.out.println("after");
        System.out.println(joinPoint.getTarget()+","+joinPoint.getClass()+","+joinPoint.getKind());
    }
}
