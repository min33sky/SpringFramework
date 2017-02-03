package com.javalec.spring.aop;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
public class Aop {

	@Pointcut("execution(** com.javalec.spring.board.controller.BController.*(..))")	// 재사용 가능한 포인트컷 정의
	public void performance(){
		
	}
	
	@Around("performance()")
	public void watchPerformance(ProceedingJoinPoint joinPoint){
		
		// 애플리케이션에서 Request 객체를 읽어옴
        HttpServletRequest req = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		System.out.println("컨텍스트 패스 : " + req.getContextPath());
		System.out.println("패스 인포 : " + req.getPathInfo());
		System.out.println("요청 URI : " + req.getRequestURI());
        

		
		try {
//			System.out.println("메소드 이름 : " + request.getMethod());
			System.out.println("aop 시작");
			joinPoint.proceed();	// 어드바이스 대상 메소드 실행
			System.out.println("aop 종료");
		} catch (Throwable e) {
			System.out.println("예외 발생");
		}
	}
}
