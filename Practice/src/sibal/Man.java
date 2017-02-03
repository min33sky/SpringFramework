package sibal;

public class Man implements BoyFriend, Son{

	@Override
	public void hyodo() {
		System.out.println("효도");
	}

	@Override
	public void anma() {
		System.out.println("안마");
	}

	@Override
	public void givePresent() {
		System.out.println("선물주기");
	}
	
}
