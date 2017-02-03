package generic;

public class GenericMain {
	public static void main(String[] args) {
		Box<String> box = new Box<String>();
		box.set("hello");
		String str = box.get();
		System.out.println(str);
		
		Box<Integer> box1 = new Box<Integer>();
		box1.set(6);
		int value = box1.get();
		System.out.println(value);
	}
}
