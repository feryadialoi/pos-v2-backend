package com.gdi.posbackend.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author Feryadialoi
 * @date 8/1/2021 10:51 AM
 */
@Slf4j
@Aspect
@Component
public class SeedAspect {

    @Pointcut("within(com.gdi.posbackend.db.seed.*)")
    public void seedPointcut() {
    }

    @Around("seedPointcut()")
    public Object measureMethodExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();

        Object proceed = joinPoint.proceed();

        long executionTime = System.currentTimeMillis() - start;

        log.info("{} executed in {} ms", joinPoint.getSignature(), executionTime);

        return proceed;
    }

}
