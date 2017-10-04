package com.cts.aspects;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerformanceAspect {
	
	Logger logger = Logger.getLogger(getClass());
	@Around("execution(* com.cts.service.EmployeeService.applyIncrement(..))")
	public void measurePerformance(ProceedingJoinPoint jp){
//		logger.error("Before: Message performance here");
		long startTime = System.nanoTime();
			try {
				// Call the target
				jp.proceed();
			} catch (Throwable e) {
				e.printStackTrace();
			}
		long endTime = System.nanoTime();
		logger.error("Calling" + jp.getSignature() + ", takes around " + (endTime-startTime));
	}

}
