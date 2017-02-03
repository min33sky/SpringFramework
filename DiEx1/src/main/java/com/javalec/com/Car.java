package com.javalec.com;

public class Car {
	String brand;
	Tire tire;

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}


	public Tire getTire() {
		return tire;
	}

	public void setTire(Tire tire) {
		this.tire = tire;
	}
	
	public void print() {
		tire.showTire();
	}
	
}
