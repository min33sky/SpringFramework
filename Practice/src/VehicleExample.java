import java.util.Calendar;

public class VehicleExample {
	public static void main(String[] args) {
		 Vehicle vehicle = new Bus();
		 
		 vehicle.run();
		 
		 // 강제 타입 변환
		 Bus bus = (Bus) vehicle;
		 
		 bus.run();
		 bus.checkFare();
		 
		 Calendar cal = Calendar.getInstance();
		 cal.get(Calendar.DAY_OF_MONTH);
	}
}
