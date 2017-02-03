package expert001_01;

import static org.junit.Assert.*;

import org.junit.Test;

public class CarTest {
	@Test
	public void tireBrandTest(){
		Car car = new Car();
		
		assertEquals("장착된 타이어: 코리아 타이어", car.getTireBrand());
	}
}
