package com.json.ex;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Base64.Encoder;
import java.util.List;
import java.util.Locale;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	SqlSessionTemplate sqlSession;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "member";
	}
	
	 //삭제
    @RequestMapping(value="/remove", method=RequestMethod.GET)
    public @ResponseBody String remove(@RequestParam(value="id") String id) {
        logger.info("remove");
        logger.info(id);
        sqlSession.delete("com.json.ex.remove",id);
        return id;
    }
    //추가
    @RequestMapping(value="/add", method=RequestMethod.POST)
    public @ResponseBody String add(Member member) {
        logger.info("add");
        String password = member.getPw();
        // 암호 암호화
        password = encryptPassword(password);
        member.setPw(password);
        sqlSession.insert("com.json.ex.add",member);
        return member.getId();
    }
    
    // 암호화
    private String encryptPassword(String password) {
    	System.out.println("원본 암호 : " + password);
    	MessageDigest md = null;
    	String encPw = null;
    	
    	try {
			md = MessageDigest.getInstance("SHA-256");
			byte[] mdResult = md.digest(password.getBytes());
			Encoder ec = Base64.getEncoder();
			encPw = ec.encodeToString(mdResult);
			System.out.println("암호화 : " + encPw);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
    	
    	return encPw;
	}

	//수정
    @RequestMapping(value="/modifyById", method=RequestMethod.POST)
    public @ResponseBody String modifyById(Member member) {
        logger.info("modifyById");
        sqlSession.update("com.json.ex.modifyById",member);
        return member.getId();
    }
    
    
    //리스트
    @RequestMapping(value="/list", method=RequestMethod.GET)
    public @ResponseBody List<Member> list() {
        logger.info("list");
        return sqlSession.selectList("com.json.ex.list");
    }
	
}
