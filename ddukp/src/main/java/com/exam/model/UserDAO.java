package com.exam.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.commons.lang3.RandomStringUtils;

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
	public int memberDeleteOk(UserTO to) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int flag = 2;
		
		try {
			conn = dataSource.getConnection();
			
			String sql = "delete from member where uid = ? and upwd = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, to.getUid());
			pstmt.setString(2, to.getUpwd());


			int result = pstmt.executeUpdate();			
			if(result == 0) {
				flag = 1;

			} else if(result == 1) {
				flag = 0;

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
		
	public UserTO userView(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		UserTO to = new UserTO();
		
		try {
			conn = dataSource.getConnection();
			
			String sql = "select uid, uname, upwd, uemail, date_format(ubirth, '%Y-%m-%d') ubirth, uphone from member where uid = ?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				to.setUid(rs.getString("uid"));
				to.setUname(rs.getString("uname"));
				to.setUbirth(rs.getString("ubirth"));
				to.setUemail(rs.getString("uemail"));
				to.setUphone(rs.getString("uphone"));
				to.setUpwd(rs.getString("upwd"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(rs!=null)try {rs.close();}catch(SQLException e) {}
			if(pstmt!=null)try {pstmt.close();}catch(SQLException e) {}
			if(conn!=null)try {conn.close();}catch(SQLException e) {}
		}
		
		return to;
	}
	
	public UserTO userDelete(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		UserTO to = new UserTO();
		
		try {
			conn = dataSource.getConnection();
			
			String sql = "select uid, ubirth, upwd, uphone, uemail from member where uid = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				to.setUbirth(rs.getString("ubirth"));
				to.setUemail(rs.getString("uemail"));
				to.setUid(rs.getString("uid"));
				to.setUphone(rs.getString("upwd"));
				to.setUphone(rs.getString("uphone"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(rs!=null)try {rs.close();}catch(SQLException e) {}
			if(pstmt!=null)try {pstmt.close();}catch(SQLException e) {}
			if(conn!=null)try {conn.close();}catch(SQLException e) {}
		}
		return to;
		
		
	}
	
	public int userDeleteOk(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int flag = 2;

		try {
			conn = dataSource.getConnection();
			
			String sql = "delete from member where uid = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			int result = pstmt.executeUpdate();
			if(result == 0) {
				flag = 1;
				
			}else if(result == 1) {
				flag = 0;
			}
			System.out.println(flag);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(pstmt!=null)try {pstmt.close();}catch(SQLException e) {}
			if(conn!=null)try {conn.close();}catch(SQLException e) {}
		}
		return flag;
	}
	
	public int userCount() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int userCountAll = 0;

		
		try {
			conn = dataSource.getConnection();
			String sql = "select count(*) from member";
			pstmt=conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				userCountAll = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(rs!=null)try {rs.close();}catch(SQLException e) {}
			if(pstmt!=null)try {pstmt.close();}catch(SQLException e) {}
			if(conn!=null)try {conn.close();}catch(SQLException e) {}
		}
		return userCountAll;
	}
	
	public UserDeleteListTO userDeleteList(UserDeleteListTO udListTO) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<UserTO> uList = new ArrayList<UserTO>();
		
		int cpage = udListTO.getCpage();
		int recordPerPage = udListTO.getRecordPerPage();
		int blockPerPage = udListTO.getBlockPerPage();
		
		try {
			conn = dataSource.getConnection();
			
			String sql = "select uid, udate, ubirth, uphone, uemail from member";
			pstmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = pstmt.executeQuery();
			
			rs.last();
			udListTO.setTotalRecord(rs.getRow());
			rs.beforeFirst();
			
			udListTO.setTotalPage(((udListTO.getTotalRecord() - 1) / recordPerPage) + 1);
			int skip = (cpage - 1) * recordPerPage;
			if(skip != 0)
				rs.absolute(skip);
			
			for(int i = 0; i < recordPerPage && rs.next(); i++) {
				UserTO uTO = new UserTO();
				uTO.setUid(rs.getString("uid"));
				uTO.setUbirth(rs.getString("ubirth"));
				uTO.setUemail(rs.getString("uemail"));
				uTO.setUphone(rs.getString("uphone"));
				uTO.setUdate(rs.getString("udate"));
				
				uList.add(uTO);
				
			}
			
			udListTO.setUserLists(uList);
			
			udListTO.setStartBlock(((cpage - 1) / blockPerPage) * blockPerPage + 1);
			udListTO.setEndBlock(((cpage - 1) / blockPerPage) * blockPerPage + blockPerPage);
			if (udListTO.getEndBlock() >= udListTO.getTotalPage()) {
				udListTO.setEndBlock(udListTO.getTotalPage());
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(rs!=null)try {rs.close();}catch(SQLException e) {}
			if(pstmt!=null)try {pstmt.close();}catch(SQLException e) {}
			if(conn!=null)try {conn.close();}catch(SQLException e) {}
		}
		return udListTO;
	}
	
	public int userRegister(UserTO to) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		int flag = 1;
		
		try {
			conn = dataSource.getConnection();
			
			String sql = "";
			if(to.getUbirth() == "") {
				sql = "insert into member (uid, uname, upwd, uemail, ubirth, uphone, udate) values (?, ?, ?, ?, ?, ?, now());";
			} else {
				sql = "insert into member (uid, uname, upwd, uemail, ubirth, uphone, udate) values (?, ?, ?, ?, date_format(?, '%Y%m%d'), ?, now());";
			}
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, to.getUid());
			pstmt.setString(2, to.getUname());
			pstmt.setString(3, to.getUpwd());
			pstmt.setString(4, to.getUemail());
			pstmt.setString(5, to.getUbirth());
			pstmt.setString(6, to.getUphone());
			
			int result = pstmt.executeUpdate();
			if(result == 0) {
				flag = 1;
				
			}else if(result == 1) {
				flag = 0;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(pstmt!=null)try {pstmt.close();}catch(SQLException e) {}
			if(conn!=null)try {conn.close();}catch(SQLException e) {}
		}
		
		return flag;
	}
	

	public UserTO findId(String email) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		UserTO to = new UserTO();
		
		try {
			conn = dataSource.getConnection();
			
			String sql = "select uid from member where uemail = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				to.setUid(rs.getString("uid"));
			}
			
			System.out.println("email : " + email + ", id : " + to.getUid());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(rs!=null)try {rs.close();}catch(SQLException e) {}
			if(pstmt!=null)try {pstmt.close();}catch(SQLException e) {}
			if(conn!=null)try {conn.close();}catch(SQLException e) {}
		}
		return to;
	}
	
	public UserTO findPwd(String id, String email) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		UserTO to = new UserTO();
		
		try {
			conn = dataSource.getConnection();
			
			String tempPwd = RandomStringUtils.randomAlphabetic(10);

			String sql = "update member set upwd = ? where uid = ? and uemail = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, tempPwd);
			pstmt.setString(2, id);
			pstmt.setString(3, email);
			
			int result = pstmt.executeUpdate();
			if(result > 0) {
				to.setUpwd(tempPwd);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(rs!=null)try {rs.close();}catch(SQLException e) {}
			if(pstmt!=null)try {pstmt.close();}catch(SQLException e) {}
			if(conn!=null)try {conn.close();}catch(SQLException e) {}
		}
		return to;
	}

	public int userEdit(UserTO to) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int flag = 1;
		try {
			conn = dataSource.getConnection();
			
			String sql;
			if(to.getUbirth() == "") {
				sql = "update member set uname = ?, ubirth = ?, uphone = ? where uid = ? and upwd = ?";
			} else {
				sql = "update member set uname = ?, ubirth = date_format(?, '%Y%m%d'), uphone = ? where uid = ? and upwd = ?";
			}
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, to.getUname());
			pstmt.setString(2, to.getUbirth());
			pstmt.setString(3, to.getUphone());
			pstmt.setString(4, to.getUid());
			pstmt.setString(5, to.getUpwd());
			
			int result = pstmt.executeUpdate();
			if(result > 0) {
				flag = 0;
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

	public int userChangePwd(UserTO to) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int flag = 1;
		
		try {
			conn = dataSource.getConnection();

			String sql = "update member set upwd = ? where uid = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, to.getUpwd());
			pstmt.setString(2, to.getUid());
			
			int result = pstmt.executeUpdate();
			if(result > 0) {
				flag = 0;
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