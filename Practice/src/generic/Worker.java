package generic;

public class Worker extends Person{

	public Worker(String type) {
		super(type);
	}
	
	@Override
	public String toString() {
		return super.type;
	}
}
