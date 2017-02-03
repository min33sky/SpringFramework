package com.javalec.ex;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

public class AdminConnection implements EnvironmentAware, InitializingBean, DisposableBean {

	private Environment env;
	private String adminid;
	private String adminpw;

	public Environment getEnv() {
		return env;
	}

	public void setEnv(Environment env) {
		this.env = env;
	}


	public String getAdminid() {
		return adminid;
	}


	public void setAdminid(String adminid) {
		this.adminid = adminid;
	}


	public String getAdminpw() {
		return adminpw;
	}


	public void setAdminpw(String adminpw) {
		this.adminpw = adminpw;
	}


	@Override
	public void destroy() throws Exception {
		System.out.println("destroy()");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("afterPropertiesSet()");
	}

	@Override
	public void setEnvironment(Environment environment) {
		System.out.println("setEnviroment()");
		setAdminid(environment.getProperty("admin.id"));
		setAdminpw(environment.getProperty("admin.pw"));
	}
		
}
