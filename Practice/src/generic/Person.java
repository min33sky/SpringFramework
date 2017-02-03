package generic;

public class Person {
	String type;
	
	public Person(String type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return type;
	}
}
