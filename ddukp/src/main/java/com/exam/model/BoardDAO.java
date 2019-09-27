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

public class BoardDAO {
	private DataSource dataSource = null;

	public BoardDAO() {
		// TODO Auto-generated constructor stub
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");
			this.dataSource = (DataSource) envCtx.lookup("jdbc/mariadb");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			System.out.println("[에러] : " + e.getMessage());
		}
	}

	public ArrayList<String> movieList() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		ArrayList<String> movieList = new ArrayList<String>();
		try {
			conn = dataSource.getConnection();

			String sql = "select msubject from movie";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				movieList.add(rs.getString("msubject"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
				}
			if (conn != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
				}
		}

		return movieList;
	}

	public int latterWrite(latterBoardTO lTO) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		int flag = 1;
		int rnum=0;

		try {
			conn = dataSource.getConnection();
			String sql = "select mnum from movie where msubject=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, lTO.getMsubject());

			rs1 = pstmt.executeQuery();

			sql = "select unum from member where uid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, lTO.getUid());
			rs2 = pstmt.executeQuery();

			if (rs1.next() && rs2.next()) {
				sql = "insert into review_board values(0,?,?,0,now(),?,?,?,?)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, lTO.getRsubject());
				pstmt.setString(2, lTO.getRcontent());
				pstmt.setString(3, lTO.getRip());
				pstmt.setString(4, rs2.getString("unum"));
				pstmt.setString(5, rs1.getString("mnum"));
				pstmt.setString(6, lTO.getCtgname());
				System.out.println("dao:"+ lTO.getCtgname());
			}

			int result = pstmt.executeUpdate();
			if (result == 1) {
				sql="select rnum from review_board order by rnum desc limit 1";
				pstmt = conn.prepareStatement(sql);
				rs1 = pstmt.executeQuery();
				if(rs1.next()) rnum=rs1.getInt("rnum");
				
				
				//flag = 0;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
				}
			if (rs1 != null)
				try {
					rs1.close();
				} catch (SQLException e) {
				}
			if (rs2 != null)
				try {
					rs2.close();
				} catch (SQLException e) {
				}
		}

		return rnum;
	}

	public latterBoardListTO latterList(latterBoardListTO lLTO) {
		Connection conn = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		ResultSet rs3 = null;

		
		ArrayList<latterBoardTO> latterList=new ArrayList<latterBoardTO>();
		
		try {
			conn = dataSource.getConnection();
			String sql = "select rnum, mnum,rsubject,unum,date_format(rdate, '%Y.%m.%d') rdate,rhit,datediff(now(), rdate) rgap,ctgname from review_board";
			pstmt1 = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs1 = pstmt1.executeQuery();

			rs1.last();
			lLTO.setTotalRecord(rs1.getRow());
			rs1.beforeFirst();
			
			lLTO.setTotalPage((lLTO.getTotalRecord() - 1) / lLTO.getRecordPerPage() + 1);
			
			int skip = (lLTO.getCpage() - 1) * lLTO.getRecordPerPage();
			if (skip != 0)
				rs1.absolute(skip);
			
			for (int i=0; i<lLTO.getRecordPerPage() && rs1.next();i++) {
				latterBoardTO lTO=new latterBoardTO();
				sql="select msubject from movie where mnum=?";
				pstmt2=conn.prepareStatement(sql);
				pstmt2.setString(1, rs1.getString("mnum"));
				rs2=pstmt2.executeQuery();
				
				sql="select uid from member where unum=?";
				pstmt3=conn.prepareStatement(sql);
				pstmt3.setString(1, rs1.getString("unum"));
				rs3=pstmt3.executeQuery();
				
				if(rs2.next() && rs3.next()) {
					lTO.setRnum(rs1.getInt("rnum"));
					lTO.setMsubject(rs2.getString("msubject"));
					lTO.setRsubject(rs1.getString("rsubject"));
					lTO.setUid(rs3.getString("uid"));
					lTO.setRdate(rs1.getString("rdate"));
					lTO.setRhit(rs1.getInt("rhit"));
					lTO.setRgap(rs1.getInt("rgap"));
					lTO.setCtgname(rs1.getString("ctgname"));
					
				}
				latterList.add(lTO);

			}
			
			lLTO.setLatterList(latterList);
		lLTO.setStartBlock(((lLTO.getCpage() - 1) / lLTO.getBlockPerPage()) * lLTO.getBlockPerPage() + 1);
			lLTO.setEndBlock(((lLTO.getCpage() - 1) / lLTO.getBlockPerPage()) * lLTO.getBlockPerPage() + lLTO.getBlockPerPage());
			System.out.println("start : "+lLTO.getStartBlock());
			if (lLTO.getEndBlock() >= lLTO.getTotalPage()) {
				lLTO.setEndBlock(lLTO.getTotalPage());
			}
			System.out.println("end: "+lLTO.getEndBlock());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (rs1 != null)
				try {
					rs1.close();
				} catch (SQLException e) {
				}
			if (rs2 != null)
				try {
					rs2.close();
				} catch (SQLException e) {
				}
			if (rs3 != null)
				try {
					rs3.close();
				} catch (SQLException e) {
				}
			if (pstmt1 != null)
				try {
					pstmt1.close();
				} catch (SQLException e) {
				}
			if (pstmt2 != null)
				try {
					pstmt1.close();
				} catch (SQLException e) {
				}
			if (pstmt3 != null)
				try {
					pstmt1.close();
				} catch (SQLException e) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
				}

			
		}
		return lLTO;
	}
	
	public latterBoardTO latterView(latterBoardTO lTO) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		ResultSet rs3 = null;
		try {
			conn = dataSource.getConnection();
			
			String sql = "update review_board set rhit=rhit+1 where rnum=?";
			pstmt = conn.prepareStatement( sql );
			pstmt.setInt( 1, lTO.getRnum() );
			pstmt.executeUpdate();
			
			sql="select mnum,rsubject,unum,date_format(rdate, '%Y.%m.%d') rdate, rhit,rcontent from review_board where rnum=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, lTO.getRnum());
			rs1=pstmt.executeQuery();
			
			if(rs1.next()) {
				sql="select msubject from movie where mnum=?";
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, rs1.getString("mnum"));
				rs2=pstmt.executeQuery();
				
				sql="select uid from member where unum=?";
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, rs1.getString("unum"));
				rs3=pstmt.executeQuery();
				
				if(rs2.next() && rs3.next()) {
					lTO.setMsubject(rs2.getString("msubject"));
					lTO.setRsubject(rs1.getString("rsubject"));
					lTO.setUid(rs3.getString("uid"));
					lTO.setRdate(rs1.getString("rdate"));
					lTO.setRhit(rs1.getInt("rhit"));
					lTO.setRcontent(rs1.getString("rcontent"));
					
				}
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if (rs1 != null)
				try {
					rs1.close();
				} catch (SQLException e) {
				}
			if (rs2 != null)
				try {
					rs2.close();
				} catch (SQLException e) {
				}
			if (rs3 != null)
				try {
					rs3.close();
				} catch (SQLException e) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
				}

			
		}
		return lTO;
	}
	
	public latterBoardTO latterModify(latterBoardTO lTO) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		try {
			conn = dataSource.getConnection();
			String sql="select rsubject,mnum,rcontent,ctgname from review_board where rnum=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, lTO.getRnum());
			rs1=pstmt.executeQuery();
			
			if(rs1.next()) {
				sql="select msubject from movie where mnum=?";
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, rs1.getString("mnum"));
				rs2=pstmt.executeQuery();
				
				if(rs2.next()) {
					lTO.setMsubject(rs2.getString("msubject"));
					lTO.setRsubject(rs1.getString("rsubject"));
					lTO.setRcontent(rs1.getString("rcontent"));
					lTO.setCtgname(rs1.getString("ctgname"));
					
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if (rs1 != null)
				try {
					rs1.close();
				} catch (SQLException e) {
				}
			if (rs2 != null)
				try {
					rs2.close();
				} catch (SQLException e) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
				}

			
		}
		
		return lTO;
	}
	public int latterModifyOk(latterBoardTO lTO) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int flag = 2;
		
		try {
			conn = dataSource.getConnection();

			String sql="select mnum from movie where msubject=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, lTO.getMsubject());
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				sql = "update review_board set ctgname=?, mnum=?,rsubject=?,rcontent=?, rip=? where rnum=?";
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, lTO.getCtgname());
				pstmt.setString(2, rs.getString("mnum"));
				pstmt.setString(3, lTO.getRsubject());
				pstmt.setString(4, lTO.getRcontent());
				pstmt.setString(5, lTO.getRip());
				pstmt.setInt(6, lTO.getRnum());
			}
			
			int result=pstmt.executeUpdate();
			
			if(result==0) {
				flag=1;
			}
			else if(result==1) {
				flag=0;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
				}
		}
		
		return flag;
	}
	
	public int latterDelete(latterBoardTO lTO) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int flag=2;
		
		try {
			conn = dataSource.getConnection();

			String sql="delete from review_board where rnum=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, lTO.getRnum());
			
			int result=pstmt.executeUpdate();
			
			if(result==0) flag=1;
			else if(result==1) flag=0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
				}
		
		}
		
		return flag;
	}
	
}
