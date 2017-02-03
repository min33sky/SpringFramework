package soundsystem.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import soundsystem.NewDisc;

@Configuration	// 스프링 설정파일
@ComponentScan(basePackages="soundsystem")	// 컴포넌트 스캔 후 컴포넌트를 빈으로 생성
@ImportResource("classpath:applicationCTX.xml")	// 스프링 xml 설정파일 읽어오기
@PropertySource("classpath:app.properties")
public class CDPlayerConfig {
	
	@Autowired
	Environment env;
	
	@Bean
	public NewDisc disc(){
		return new NewDisc(
				env.getProperty("disc.title"),
				env.getProperty("disc.artist"));
	}
}
