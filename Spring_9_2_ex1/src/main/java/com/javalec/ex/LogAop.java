package com.javalec.ex;

import org.aspectj.lang.ProceedingJoinPoint;
/*
 * 공통 기능을 할 클래스
 */
public class LogAop {
	
	/*
	 * Proxy : 대행자
	 * JoinPoint : advice가 적용되는 곳
	 */
	public Object loggerAop(ProceedingJoinPoint joinPoint) throws Throwable{
		String signatureStr = joinPoint.getSignature().toShortString();
		System.out.println(signatureStr + " is start.");
		long st = System.currentTimeMillis();
		
		try {
			Object obj = joinPoint.proceed();
			return obj;
		} finally {
			long et = System.currentTimeMillis();
			System.out.println(signatureStr + " is finished.");
			System.out.println(signatureStr + " 경과시간 : " + (et - st));
		}
	}
}
