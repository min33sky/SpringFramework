package com.javalec.ex;

import java.util.Scanner;

import org.springframework.context.support.GenericXmlApplicationContext;
/*
 * profile로 설정 관리하기
 * XML 이용
 */
public class MainClass {
	public static void main(String[] args) {
		String config = null;
		Scanner scanner = new Scanner(System.in);
		String str = scanner.next();
		if(str.equals("dev")){
			config = "dev";
		}else if(str.equals("run")){					
			config = "run";
		}
		
		scanner.close();
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		// xml에 profile속성을 config와 비교해서 설정파일을 가져온다.
		ctx.getEnvironment().setActiveProfiles(config);
		// 설정파일들을 모두 로드한다.
		ctx.load("applicationCTX_dev.xml", "applicationCTX_run.xml");
		ServerInfo info = ctx.getBean("serverInfo", ServerInfo.class);
		System.out.println(info.getIpNum());
		System.out.println(info.getPortNum());
		ctx.close();
		
	}
}
