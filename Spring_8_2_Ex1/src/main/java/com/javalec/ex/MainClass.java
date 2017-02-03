package com.javalec.ex;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		
		AdminConnection ac = ctx.getBean("adminConnection", AdminConnection.class);
		System.out.println(ac.getAdminid());
		System.out.println(ac.getAdminpw());
		System.out.println(ac.getSub_adminid());
		System.out.println(ac.getSub_adminpw());
		
		
	}
}
