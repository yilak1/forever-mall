package com.lym.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author lds
 */
@Aspect
public class ServiceLogAspect {

    private static final Logger logger = LoggerFactory.getLogger(ServiceLogAspect.class);

    /**
     *  用于记录方法执行时间
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    @Around("execution(* com.lym.service.impl..*.*(..))")
    public Object recordTimeLog(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info("====== 开始执行 {}.{} ======",
                joinPoint.getTarget().getClass(), joinPoint.getSignature().getName());
        //记录开始时间
        long begin = System.currentTimeMillis();

        Object result = joinPoint.proceed();
        long end = System.currentTimeMillis();
        long takeTime = end - begin;
        if (takeTime > 3000){
            logger.error("========== 执行结束，耗时：{}毫秒", takeTime);
        }else if (takeTime > 2000) {
            logger.warn("========== 执行结束，耗时：{}毫秒", takeTime);

        }else {
            logger.info("========== 执行结束，耗时：{}毫秒", takeTime);

        }

        return result;
    }

}
