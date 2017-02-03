package expert001_03;

public class Car {
	Tire tire;
	
	public Tire getTire(){
		return tire;
	}
	
	// setter 메서드를 이용해 객체 주입
	public void setTire(Tire tire){
		this.tire = tire;
	}
	
	public String getTireBrand(){
		return "장착된 타이어: " + tire.getBrand();
	}
}
