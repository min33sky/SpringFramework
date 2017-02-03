package spittr.web;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

public class HomeControllerTest {

	@Test
	public void testHomePage() throws Exception{
		HomeController controller = new HomeController();
		MockMvc mockMvc =	// mockMvc 셋업
				standaloneSetup(controller).build();
		
		mockMvc.perform(get("/"))	// get 메서드와 path '/'
					.andExpect(view().name("home"));	// 뷰 이름 home
	}
}
