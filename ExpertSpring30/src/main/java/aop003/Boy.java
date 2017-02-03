package aop003;

public class Boy implements Person{
	
	// 핵심 관심사
	@Override
	public void runSomething() {
		System.out.println("컴퓨터로 게임을 한다.");
	}
	
}
