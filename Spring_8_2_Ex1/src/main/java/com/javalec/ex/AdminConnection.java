package com.javalec.ex;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class AdminConnection implements InitializingBean, DisposableBean {
	private String adminid;
	private String adminpw;
	private String sub_adminid;
	private String sub_adminpw;
	
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
	public String getSub_adminid() {
		return sub_adminid;
	}
	public void setSub_adminid(String sub_adminid) {
		this.sub_adminid = sub_adminid;
	}
	public String getSub_adminpw() {
		return sub_adminpw;
	}
	public void setSub_adminpw(String sub_adminpw) {
		this.sub_adminpw = sub_adminpw;
	}


	@Override
	public void destroy() throws Exception {
		System.out.println("destroy()");
	}
	@Override
	public void afterPropertiesSet() throws Exception {
		
	}
}
