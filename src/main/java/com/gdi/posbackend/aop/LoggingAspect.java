package com.gdi.posbackend.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author Feryadialoi
 * @date 8/1/2021 3:01 AM
 */
@Slf4j
@Aspect
@Component
public class LoggingAspect {


    @Around("@annotation(LogExecutionTime)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();

        Object proceed = joinPoint.proceed();

        long executionTime = System.currentTimeMillis() - start;

        log.info("{} executed in {} ms", joinPoint.getSignature(), executionTime);

        return proceed;
    }

}
