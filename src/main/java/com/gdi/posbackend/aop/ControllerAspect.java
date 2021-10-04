package com.gdi.posbackend.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Component;

/**
 * @author Feryadialoi
 * @date 8/1/2021 10:51 AM
 */
@Slf4j
@Aspect
@Component
public class ControllerAspect {

    @Pointcut("within(com.gdi.posbackend.controller.v1.*)")
    public void controllerPointcut() {
    }

    @Around("controllerPointcut()")
    public Object measureMethodExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();

        Object proceed = joinPoint.proceed();

        long executionTime = System.currentTimeMillis() - start;

        log.info("{} executed in {} ms", joinPoint.getSignature(), executionTime);
        log.info("args {}", joinPoint.getArgs());
        log.info("proceed {}", proceed);

        return proceed;
    }

    @Pointcut("within(com.gdi.posbackend.controller.v1.*)")
    public void controllerUserDetails() {
    }

    @Around("controllerUserDetails()")
    public Object logUserDetails(ProceedingJoinPoint joinPoint) throws Throwable {
        Object proceed = joinPoint.proceed();

        Signature signature = joinPoint.getSignature();
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        log.info("{} by user {}", signature, principal);
        return proceed;
    }

}
