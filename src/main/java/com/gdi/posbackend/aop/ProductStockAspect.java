package com.gdi.posbackend.aop;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author Feryadialoi
 * @date 8/3/2021 10:33 AM
 */
@Slf4j
@Aspect
@Component
@AllArgsConstructor
public class ProductStockAspect {

//    private final


    public Object checkProductStockReachMinimumStock(ProceedingJoinPoint joinPoint) throws Throwable {
        // check product stock has reach the minimum stock or not
        // if true, append message to tell the user about reaching of minimum stock


        return joinPoint.proceed();
    }
}
