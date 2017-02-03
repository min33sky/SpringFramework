package expert001_02;

import static org.junit.Assert.*;

import org.junit.Test;

public class CarTest {
	@Test
	public void koreaTireTest(){
		Tire tire1 = new KoreaTire();
		Car car1 = new Car(tire1);
		
		assertEquals("장착된 타이어: 코리아 타이어", car1.getTireBrand());
	}
	
	@Test
	public void americaTireTest(){
		Tire tire2 = new AmericaTire();
		Car car2 = new Car(tire2);
		
		assertEquals("장착된 타이어: 미국 타이어", car2.getTireBrand());
	}
}
