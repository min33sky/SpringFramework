package com.javalec.com;

import org.springframework.beans.factory.annotation.Autowired;

public class HankookTire implements Tire{

	@Autowired
	public void showTire() {
		System.out.println("한국 타이어");
	}

}
