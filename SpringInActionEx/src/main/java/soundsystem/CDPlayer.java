package soundsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CDPlayer implements MediaPlayer{
	
	private CompactDisc cd;
	
	@Autowired	// SgtPeppers 빈이 주입된다.
	public CDPlayer(@Qualifier("blankDisc") CompactDisc cd){
		this.cd = cd;
	}

	@Override
	public void play() {
		cd.play();
	}
	
}
