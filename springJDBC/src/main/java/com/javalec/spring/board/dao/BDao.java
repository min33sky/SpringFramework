package com.javalec.spring.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import com.javalec.spring.board.util.Constant;
import com.javalec.spring.board.vo.BVo;

@Repository
public class BDao {

	@Autowired
	JdbcTemplate template;

//	public BDao(){
//		template = Constant.template; 
//	}

	/*
	 * 목록 
	 */
	public ArrayList<BVo> list(){
		
		String query = "SELECT bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent FROM mvc_board ORDER BY bGroup DESC, bStep ASC";
		return (ArrayList<BVo>) template.query(query, new BeanPropertyRowMapper<BVo>(BVo.class)); // template.query(쿼리문, 커맨드객체)
	}


	/*
	 * 글 작성
	 * 내부 클래스에서 외부 클래스 변수를 사용할 때는 외부 클래스의 매개변수에 final을 선언해야한다.
	 */
	public void write(final String bName, final String bTitle, final String bContent) { 
		template.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				String query = "insert into mvc_board (bId, bName, bTitle, bContent, bHit, bGroup, bStep, bIndent) values (mvc_board_seq.nextval, ?, ?, ?, 0, mvc_board_seq.currval, 0, 0)";
				PreparedStatement pstmt = con.prepareStatement(query);
				pstmt.setString(1, bName);
				pstmt.setString(2, bTitle);
				pstmt.setString(3, bContent);
				return pstmt;
			}
		});
		
	}

	/*
	 * 게시물 보기
	 */
	public BVo contentView(String strID) {
		upHit(strID); // 조회수 올리기
		String query = "SELECT * FROM mvc_board WHERE bid = " + strID;
		return template.queryForObject(query, new BeanPropertyRowMapper<BVo>(BVo.class));
		
	}

	/*
	 * 조회수 올리기
	 */
	private void upHit(final String strID) {	// final 변수 선언
		String query = "UPDATE mvc_board SET bHit = bHit + 1 WHERE bId = ?";
		template.update(query, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, Integer.parseInt(strID));
			}
		});
	}

	/*
	 * 글 수정
	 */
	public void modify(final String bId, final String bName, final String bTitle, final String bContent) {
		String query = "UPDATE mvc_board SET bName = ?, bTitle = ?, bContent = ? WHERE bId = ?";
		template.update(query, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, bName);
				ps.setString(2, bTitle);
				ps.setString(3, bContent);
				ps.setInt(4, Integer.parseInt(bId));
			}
		});
	}

	/*
	 * 글 삭제
	 */
	public void delete(final String strId) {
		String query = "DELETE FROM mvc_board WHERE bID = ?";
		template.update(query, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, strId);
			}
		});
	}

	/*
	 * 답변 폼으로 이동
	 */
	public BVo replyView(String strId) {
		String query = "SELECT * FROM mvc_board WHERE bId = " + strId; 
		return template.queryForObject(query, new BeanPropertyRowMapper<BVo>(BVo.class));
		
	}

	/*
	 * 답글 입력
	 */
	public void reply(final String bId, final String bName, final String bTitle, final String bContent, 
											final String bGroup, final String bStep, final String bIndent) {
		
		replyShape(bGroup, bStep);
		String query = "insert into mvc_board (bId, bName, bTitle, bContent, bGroup, bStep, bIndent) values (mvc_board_seq.nextval, ?, ?, ?, ?, ?, ?)";
		template.update(query, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, bName);
				ps.setString(2, bTitle);
				ps.setString(3, bContent);
				ps.setInt(4, Integer.parseInt(bGroup));
				ps.setInt(5, Integer.parseInt(bStep) + 1);
				ps.setInt(6, Integer.parseInt(bIndent) + 1);
			}
		});
	}

	/*
	 * 답변 제목 들여쓰기
	 */
	private void replyShape(final String strGroup, final String strStep) {
		String query = "update mvc_board set bStep = bStep + 1 where bGroup = ? and bStep > ?";
		template.update(query, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, Integer.parseInt(strGroup));
				ps.setInt(2, Integer.parseInt(strStep));
			}
		});
		
	}
}
