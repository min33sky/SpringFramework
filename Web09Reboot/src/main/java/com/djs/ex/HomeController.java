package com.djs.ex;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.djs.ex.vo.Member;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	public DataSource dataSource;
	
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Member> members = new ArrayList<Member>();
		
		try {
			connection = dataSource.getConnection();
			ps = connection.prepareStatement("SELECT * FROM members");
			rs = ps.executeQuery();
			while(rs.next()){
				int mno = rs.getInt(1);
				String email = rs.getString(2);
				String pwd = rs.getString(3);
				String name = rs.getString(4);
				Date cd = rs.getDate(5);
				Date md = rs.getTimestamp(6);
				System.out.println(mno+", "+email+", "+pwd+", "+name+", "+cd+", "+md);
				members.add(new Member(mno, email, pwd, name, cd, md));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			if(rs != null){
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(ps != null){
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(connection != null){
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		model.addAttribute("list", members);
		
		return "home";
	}


	
}
