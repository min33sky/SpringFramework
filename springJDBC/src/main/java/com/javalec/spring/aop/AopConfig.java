package com.javalec.spring.aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan
@EnableAspectJAutoProxy
public class AopConfig {
	
	@Bean
	public Aop aop(){
		System.out.println("aop빈 생성");
		return new Aop();
	}
}
