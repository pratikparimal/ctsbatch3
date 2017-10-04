package com.cts.aspects;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
	
	Logger logger = Logger.getLogger(getClass());

	@Before("execution(* com.cts.service.*.*(..))")
	public void logInputParameters(JoinPoint jp){
//		jp.getTarget()
//		logger.error(jp.getTarget());
		logger.error(jp.getSignature());
		for(Object obj: jp.getArgs()){
			logger.error("Parameter: " + obj);
		}
		
		logger.error("---------------------");
		logger.error("Something before... the target methods");
		logger.error("---------------------");
	}
}
