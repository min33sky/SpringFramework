package system;

public class ClassExample {
	public static void main(String[] args) {
		// Class 클래스 : 인터페이스, 클래스의 메타 데이터를 다룬다 
		// getClass : 객체 생성 후 forName() : 객체 생성 전
		Car car = new Car();
		Class clazz1 = car.getClass();
		System.out.println(clazz1.getName());
		System.out.println(clazz1.getSimpleName());
		System.out.println(clazz1.getPackage().getName());
		System.out.println();
		
		try {
			Class clazz2 = Class.forName("system.Bus");
			System.out.println(clazz2.getName());
			System.out.println(clazz2.getSimpleName());
			System.out.println(clazz2.getPackage().getName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
