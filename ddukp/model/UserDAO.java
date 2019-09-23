package com.exam.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class UserDAO {
	private DataSource dataSource;
	
	public UserDAO() {
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");
			this.dataSource = (DataSource) envCtx.lookup("jdbc/mariadb");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int LoginOk(UserTO to) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int flag = 1;
		
		try {
			conn = dataSource.getConnection();
			
			String sql = "select upwd from member where uid = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, to.getUid());
			
			rs = pstmt.executeQuery();
			
			System.out.println("Dao아이디 : "+to.getUid());
			
			if(rs.next()) {
				if(rs.getString("upwd").equals(to.getUpwd())) {
					System.out.println("Dao비번 : " + to.getUpwd());
					// 회원
					flag = 0;
				}else {
					flag = 2;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(rs!=null)try {rs.close();}catch(SQLException e) {}
			if(pstmt!=null)try {pstmt.close();}catch(SQLException e) {}
			if(conn!=null)try {conn.close();}catch(SQLException e) {}
		}
		return flag;
	}
}