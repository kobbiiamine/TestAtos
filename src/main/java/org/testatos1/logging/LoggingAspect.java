package org.testatos1.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* org.testatos1.controller.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("Entering: " + joinPoint.getSignature().toShortString());
    }

    @AfterReturning(pointcut = "execution(* org.testatos1.controller.*.*(..))", returning = "result")
    public void logAfter(JoinPoint joinPoint, Object result) {
        System.out.println("Exiting: " + joinPoint.getSignature().toShortString());
    }

    @AfterThrowing(pointcut = "execution(* org.testatos1.controller.*.*(..))", throwing = "exception")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable exception) {
        System.err.println("Exception in: " + joinPoint.getSignature().toShortString());
        System.err.println("Exception: " + exception.getMessage());
    }
}
