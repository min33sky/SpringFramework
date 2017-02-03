package springbook.user.domain;

public enum Level {
	GOLD(3, null), SILVER(2, GOLD), BASIC(1, SILVER);	// Enum Object
	
	private final int value;
	private final Level next;	// 다음 단계의 레벨 정보를 스스로 갖고 있도록 Level 타입의 next 변수 추가
	
	Level(int value, Level next){	// DB에 저장할 값을 넣어줄 생성자
		this.value = value;
		this.next = next;
	}
	
	public int intValue(){	 // 값을 가져오는 메소드
		return value;
	}

	public Level nextLevel(){
		return this.next;
	}
	
	public static Level valueOf(int value){ // 값으로부터 Level 타입 오브젝트를 가져오도록 만든 메소드
		switch(value){
			case 1: return BASIC;
			case 2: return SILVER;
			case 3: return GOLD;
			default: throw new AssertionError("Unknown value: " + value);
		}
	}
}
