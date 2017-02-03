package chap06.singletonPattern;

public class Singleton {
	static Singleton singletonObject; // static reference variable
	
	private Singleton(){}	// private 생성자
	
	// 객체 반환 static method
	public static Singleton getInstance(){
		if(singletonObject == null){
			singletonObject = new Singleton();
		}
		return singletonObject;
	}
}
