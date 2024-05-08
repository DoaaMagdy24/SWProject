package com.example.demo.ASOP;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
@Order(1)
public class LoggingAspect {

    private static final Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    @Before("execution(* com.example.demo.Controllers..*(..))")
    public void logRequest(JoinPoint joinPoint) {
        logger.info("Request received: " + joinPoint.getSignature().getName());
    }

    @AfterReturning(pointcut = "execution(* com.example.demo.Controllers..*(..))", returning = "result")
    public void logResponse(JoinPoint joinPoint, Object result) {
        logger.info("Response sent: " + joinPoint.getSignature().getName() + " -> " + result);
    }
}