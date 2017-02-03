package expert001_02;

public class Car {
	Tire tire;
	
	// 생성자에서 객체 주입
	public Car(Tire tire) {
		this.tire = tire;
	}
	
	public String getTireBrand(){
		return "장착된 타이어: " + tire.getBrand();
	}
}
