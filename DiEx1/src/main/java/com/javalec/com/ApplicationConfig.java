package com.javalec.com;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration	// 스프링 설정 파일
public class ApplicationConfig {
	

	/*
	 * @Bean : bean 생성
	 * method name : bean id
	 */
	
	@Bean
	public Tire myTire(){	
		Tire tire = new HankookTire();
		return tire;
	}
	
	@Bean
	public Car myCar2(){
		Car car = new Car();
		car.setBrand("Benz");
		car.setTire(myTire());
		
		return car;
	}
}
