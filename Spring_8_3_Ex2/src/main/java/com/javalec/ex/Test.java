package com.javalec.ex;

import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
	public static void main(String[] args) {
		String config = null;
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		if(str.equals("dev")){
			config = "dev";
		}else if(str.equals("run")){
			config = "run";
		}
		
		sc.close();
		
		// 스프링 컨테이너 생성
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		// 설정파일 이름 입력
		ctx.getEnvironment().setActiveProfiles(config);
		// 설정파일들 등록
		ctx.register(ApplicationConfigDev.class, ApplicationConfigRun.class);
		ctx.refresh();
		
		// 컨테이너로부터 빈 가져오기
		ServerInfo info = ctx.getBean("serverInfo", ServerInfo.class);
		System.out.println(info.getIpNum());
		System.out.println(info.getPortNum());
		ctx.close();
		
	}
}
