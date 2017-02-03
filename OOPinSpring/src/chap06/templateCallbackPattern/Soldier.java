package chap06.templateCallbackPattern;

public class Soldier{
	public void runContext(String weaponSound) {
		System.out.println("전투 시작");
		executeWeapon(weaponSound).runStrategy();
		System.out.println("전투 종료");
	}
	
	// 전략 생성
	private Strategy executeWeapon(final String weaponSound) {
		return new Strategy(){
			@Override
			public void runStrategy() {
				System.out.println(weaponSound);
			}
		};
	}
}
