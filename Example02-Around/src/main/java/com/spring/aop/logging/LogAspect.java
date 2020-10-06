package com.spring.aop.logging;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class LogAspect {
    private static final Logger log = LoggerFactory.getLogger(LogAspect.class);

    @Around("within(com.spring.aop.service..*)")
    public Object log(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object[] methodArgumants = proceedingJoinPoint.getArgs();
        StringBuffer buffer = new StringBuffer();
        if (methodArgumants != null) {
            for (Object arg : methodArgumants) {
                if (arg != null) {
                    buffer.append(arg.toString()).append(",");
                }
            }
        }
        log.debug((String.format("Method %s invoke with arguments %s", proceedingJoinPoint.getSignature().getName(),
                buffer.toString())));

        try {
            Object result = proceedingJoinPoint.proceed();
            log.debug("Method {} execution finished with result {}",  proceedingJoinPoint.getSignature().getName(),
                     result == null ? "" : result.toString());
            return result;
        } catch (Throwable throwable) {
            log.debug("Exception catched by logAspect. Reason : {} Trace: {}", throwable.getMessage(),
                     throwable.getStackTrace());
            throw throwable;
        }
    }
}
