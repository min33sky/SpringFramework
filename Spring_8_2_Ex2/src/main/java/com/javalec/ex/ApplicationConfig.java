package com.javalec.ex;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

@Configuration	// 스프링 설정파일
public class ApplicationConfig {
	
	// Properties로부터 값을 입력받는다.
	@Value("${adminid}")
	private String admindid;
	@Value("${adminpw}")
	private String admindpw;
	@Value("${sub_adminid}")
	private String sub_admindid;
	@Value("${sub_adminpw}")
	private String sub_admindpw;
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer properties(){
		PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
		
		// properties 위치를 지정한다.
		Resource[] locations = new Resource[2];
		locations[0] = new ClassPathResource("admin.properties");
		locations[1] = new ClassPathResource("sub_admin.properties");
		configurer.setLocations(locations);
		
		return configurer;
	}
	
	@Bean
	public AdminConnection adminConfig(){
		AdminConnection adminConnection = new AdminConnection();
		adminConnection.setAdmindid(admindid);
		adminConnection.setAdminpw(admindpw);
		adminConnection.setSub_admindid(sub_admindid);
		adminConnection.setSub_admindpw(sub_admindpw);
		return adminConnection;
	}
}
