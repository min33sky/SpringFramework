package chap03.abstraction01;

public class Driver02 {
	public static void main(String[] args) {
		Animal animal = new Animal();
		Animal dog = new Dog();
		Animal bat = new Bat();
		
		animal.showMe();
		dog.showMe();
		bat.showMe();
	}
}
