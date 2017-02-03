package com.javalec.ex;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		AdminConnection ac = ctx.getBean("adminConfig", AdminConnection.class);
		
		System.out.println(ac.getAdmindid());
		System.out.println(ac.getAdminpw());
		System.out.println(ac.getSub_admindid());
		System.out.println(ac.getSub_admindpw());
		
	}
}
