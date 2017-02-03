package concert;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
	public static void main(String[] args) {
//		 JavaConfig
		ApplicationContext ctx = new AnnotationConfigApplicationContext(ConcertConfig.class);
		Performance perform = ctx.getBean(Performance.class);
//		XML
//		ApplicationContext ctx = new GenericXmlApplicationContext("applicationCTX.xml");
//		Performance perform = ctx.getBean("performance", Performance.class);
		try {
			perform.perform();
		} catch (Exception e) {
			
		}
	}
}
