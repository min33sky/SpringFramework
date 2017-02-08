package com.djs.board.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;

import com.djs.board.vo.Member;

@Repository
public class MemberDao {

	@Autowired
	SqlSession session;

	// 출력
	public List<Member> selectList(String orderCond) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("orderCond", orderCond);
		List<Member> list = session.selectList("com.djs.board.dao.MemberDao.selectList", map);
		return list;
	}

	/*
	 * 추가
	 */
	public void add(Member member) throws DataIntegrityViolationException {
			session.insert("com.djs.board.dao.MemberDao.insert", member);
	}
	
	/*
	 * 삭제
	 */
	public void delete(int no){
		session.delete("com.djs.board.dao.MemberDao.delete", no);
	}

	
	/*
	 * 로그인 확인
	 */
	public Member exist(Member loginInfo) {
		
		Member member = session.selectOne("com.djs.board.dao.MemberDao.exist", loginInfo);
		return member;
	}

	/*
	 * 수정할 회원 정보 가져오기
	 */
	public Member selectOne(int no) {
		
		Member member = session.selectOne("com.djs.board.dao.MemberDao.selectOne", no);
		return member;
	}

	/*
	 * 회원 수정
	 */
	public void update(Member member) {
		session.update("com.djs.board.dao.MemberDao.update", member);
	}

}
