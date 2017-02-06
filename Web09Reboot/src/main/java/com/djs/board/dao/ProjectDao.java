package com.djs.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.djs.board.vo.Project;

@Service
public class ProjectDao {

	@Autowired
	DataSource dataSource;

	/*
	 * 출력
	 */
	public List<Project> list() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Project> list = new ArrayList<Project>();

		try {
			String query = "SELECT * FROM projects";
			conn = dataSource.getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				int no = rs.getInt(1);
				String name = rs.getString(2);
				String content = rs.getString(3);
				Date sDate = rs.getDate(4);
				Date eDate = rs.getDate(5);
				int state = rs.getInt(6);
				Date cDate = rs.getDate(7);
				String tags = rs.getString(8);
				System.out.println(no + "," + name + "," + content + "," + sDate + "," + eDate + "," + state + ","
						+ cDate + "," + tags);
				list.add(new Project(no, name, content, sDate, eDate, state, cDate, tags));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return list;
	}
}
