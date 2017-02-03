package chap03.abstraction01;

public class Driver01 {
	public static void main(String[] args) {
		Animal animal = new Animal();
		Dog dog = new Dog();
		Bat bat = new Bat();
		
		animal.showMe();
		dog.showMe();
		bat.showMe();
	}
}
