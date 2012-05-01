package net.therap.aspect;

import net.therap.controller.LoginController;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by IntelliJ IDEA.
 * User: tahmid
 * Date: 5/1/12
 * Time: 2:19 PM
 * To change this template use File | Settings | File Templates.
 */
@Aspect

public class ExecutionTimeAspect {

    private static final Logger log = LoggerFactory.getLogger(ExecutionTimeAspect.class);

    @Around("execution (public * *.*(..))")
    public Object doNothing(ProceedingJoinPoint thisJoinPoint) throws Throwable{


        long start  = System.nanoTime();
        //log.info("Starting execution of " + thisJoinPoint.getSignature().getName() +" at " + start);

        try {
            return thisJoinPoint.proceed();
        } finally {
            long end = System.nanoTime();
            long duration = end - start;
            //log.info("Ending execution of " + thisJoinPoint.getSignature().getDeclaringTypeName() + "." + thisJoinPoint.getSignature().getName() +" at " + end);
            log.info(thisJoinPoint.getSignature().getDeclaringTypeName() + "." + thisJoinPoint.getSignature().getName() + " " + duration);
        }

     }


}
