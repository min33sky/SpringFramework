package spms.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.springframework.context.support.ClassPathXmlApplicationContext;

//스프링 IoC 컨테이너 사용
@WebListener
public class ContextLoaderListener implements ServletContextListener {
  static ClassPathXmlApplicationContext applicationContext;
  
  public static ClassPathXmlApplicationContext getApplicationContext() {
    return applicationContext;
  }
   
  @Override
  public void contextInitialized(ServletContextEvent event) {
    try {
    	// 빈 설정파일 로딩
    	applicationContext = new ClassPathXmlApplicationContext("beans.xml");
      
    } catch(Throwable e) {
      e.printStackTrace();
    }
  }
  
  @Override
  public void contextDestroyed(ServletContextEvent event) {}
}
