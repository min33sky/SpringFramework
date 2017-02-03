package concert;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/*
 * 공연에서 관객은 중요하지만 핵심 기능이 아니므로 
 * Aspect로 정의한다.
 */

@Aspect
public class Audience {
	
	@Pointcut("execution(** concert.Performance.perform(..))")	// 재사용 가능한 포인트컷 정의
	public void performance(){
		
	}
	
	/*
	@Before("performance()")	// 공연 이전
	public void silenceCellPhone(){
		System.out.println("핸드폰을 끄세요.");
	}
	
	@Before("performance()")	// 공연 이전
	public void takeSeats(){
		System.out.println("좌석에 앉으세요.");
	}
	
	@AfterReturning("performance()")	// 공연 후
	public void applause(){
		System.out.println("박수쳐 !!!");
	}
	
	@AfterThrowing("performance()")	// 공연 실패후
	public void demandRefund(){
		System.out.println("환불해 주세요!!!");
	}
	*/
	
	/*
	 * ProceedingJoinPoint는 어드바이스 대상 메소드를 호출할 수 있는 방법을 제공하는 객체
	 */
	@Around("performance()")
	public void watchPerformance(ProceedingJoinPoint jointPoint){
		
		try {
			System.out.println("Silencing cell phones");
			System.out.println("Taking seats");
			jointPoint.proceed();	// 어드바이스 대상 메소드 실행
			System.out.println("Clap! Clap! Clap!!!");
		} catch (Throwable e) {
			System.out.println("Demanding a refund");
		}
	}
	
}
