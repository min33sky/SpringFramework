package concert;

public class Performance {
	
	public void perform() throws Exception{
		System.out.println("*** 공연 ***");
		throw new Exception("예외를 내보자");
	}
}
