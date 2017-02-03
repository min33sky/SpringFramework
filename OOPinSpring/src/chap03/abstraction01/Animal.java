package chap03.abstraction01;

public class Animal {
	String myClass;
	
	Animal(){
		myClass = "동물";
	}
	
	void showMe(){
		System.out.println(myClass);
	}
}
