package com.djs.board.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.djs.board.vo.Member;

@Repository
public class MemberDao {

	@Autowired
	SqlSession session;
	
//	@Autowired
//	DataSource dataSource;

	// 출력
	public List<Member> selectList(String orderCond) {

		System.out.println(orderCond);
		Map<String, String> map = new HashMap<String, String>();
		map.put("orderCond", orderCond);
		List<Member> list = session.selectList("com.djs.board.dao.MemberDao.selectList", map);
		return list;
//		Connection conn = null;
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//		List<Member> list = new ArrayList<Member>();
//
//		try {
//			String query = "SELECT * FROM members";
//			conn = dataSource.getConnection();
//			ps = conn.prepareStatement(query);
//			rs = ps.executeQuery();
//			while (rs.next()) {
//				int no = rs.getInt(1);
//				String email = rs.getString(2);
//				String pwd = rs.getString(3);
//				String name = rs.getString(4);
//				Date cDate = rs.getDate(5);
//				Date mDate = rs.getDate(6);
//				System.out.println(no + "," + email + "," + pwd + "," + name + "," + cDate + "," + mDate);
//				list.add(new Member(no, name, email, pwd, cDate, mDate));
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			if (rs != null) {
//				try {
//					rs.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//			if (ps != null) {
//				try {
//					ps.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//			if (conn != null) {
//				try {
//					conn.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//
//		return list;
	}
//
//	public void add(Member member) {
//		Connection conn = null;
//		PreparedStatement ps = null;
//
//		try {
//			String query = 
//					"INSERT INTO members(email, pwd, mname, cre_date, mod_date) "
//					+ "VALUES (?,?,?,now(),now())";
//			conn = dataSource.getConnection();
//			ps = conn.prepareStatement(query);
//			ps.setString(1, member.getEmail());
//			ps.setString(2, member.getPassword());
//			ps.setString(3, member.getName());
//			ps.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			if (ps != null) {
//				try {
//					ps.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//			if (conn != null) {
//				try {
//					conn.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//
//	}

}
