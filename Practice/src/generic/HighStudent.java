package generic;

public class HighStudent extends Student{
	public HighStudent(String type) {
		super(type);
	}
	
	@Override
	public String toString() {
		return super.type;
	}
}
