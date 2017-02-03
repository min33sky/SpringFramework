package soundsystem;


import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import soundsystem.config.CDPlayerConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=CDPlayerConfig.class)	// 스프링 설정 파일 위치
public class CDPlayerTest {
	
	@Rule
	public final SystemOutRule log = new SystemOutRule().enableLog();
	
	@Autowired	// component를 검색해서 생성된 CompactDisc빈을 엮어준다.
	@Qualifier("sgtPeppers")
	private CompactDisc cd;
	
	@Autowired
	private MediaPlayer player;
	
	@Autowired
	private NewDisc newCd;
	
	
	
	@Test
	public void cdShouldNotBeNull1(){
		assertNotNull(cd);	// 해당 프로퍼티가 Null이 아닌지 Test
	}
	
	
	@Test
	public void cdShouldNotBeNull2(){
		assertNotNull(newCd);	// 해당 프로퍼티가 Null이 아닌지 Test
	}
	
	@Test
	public void play(){
		player.play();
		assertEquals("Playing 너였다면 by 정승환", log.getLog());
	}
}
