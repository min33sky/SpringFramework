package chap06.decoratorPattern;

public class ClientWithDecorator {
	public static void main(String[] args) {
		IService decoreator = new Decoreator();
		System.out.println(decoreator.runSomething());
	}
}
