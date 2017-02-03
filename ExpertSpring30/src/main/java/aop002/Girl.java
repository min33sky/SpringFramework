package aop002;

public class Girl implements Person{
	
	// 핵심 관심사
	@Override
	public void runSomething() {
		System.out.println("부엌에서 요리를 한다.");
	}
	
}
