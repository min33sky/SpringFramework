package com.javalec.com;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		
		String conf = "classpath:applicationCtx.xml";
		ApplicationContext ctx1 = new GenericXmlApplicationContext(conf);
		ApplicationContext ctx2 = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		
		Car car1 = ctx1.getBean("myCar1", Car.class);
		Car car2 = ctx2.getBean("myCar2", Car.class);
		car1.print();
		car2.print();
		System.out.println(car1.getBrand());
		System.out.println(car2.getBrand());
	}
}
