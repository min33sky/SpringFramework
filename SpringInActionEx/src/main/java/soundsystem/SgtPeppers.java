package soundsystem;

import org.springframework.stereotype.Component;

@Component	// 스프링이 빈으로 생성한다.
public class SgtPeppers implements CompactDisc {

	private String title = "너였다면";
	private String artist = "정승환";
	
	@Override
	public void play() {
		System.out.println("Playing " + title + " by " + artist);
	}

}
