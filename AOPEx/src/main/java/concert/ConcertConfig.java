package concert;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration	// 스프링 설정파일
@ComponentScan	// 컴포넌트 검색
@EnableAspectJAutoProxy	// AspectJ 오토 프록싱 활성화
public class ConcertConfig {
	
	@Bean
	public Audience audience(){
		return new Audience();
	}
	
	@Bean
	public Performance performance(){
		return new Performance();
	}
}
