package aop002;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class MyAspect {
	
	// 횡단 관심사 주입
	@Before("execution(* runSomething())")
	public void before(JoinPoint joinPoint){
		System.out.println("얼굴 인식 확인: 문을 개방하라");
	}
	
}
