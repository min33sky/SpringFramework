package generic;

public class Student extends Person {
	public Student(String type) {
		super(type);
	}
	
	@Override
	public String toString() {
		return super.type;
	}
}
