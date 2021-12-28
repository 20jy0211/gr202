package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.MemberBean;
import util.Close;
import util.DBconnection;
import util.GenerateQRcode;
import util.SHA256;

public class MemberDAO {
	
	public boolean generateQRcode(int m_num,String m_brith) throws SQLException{
		String SQL = "UPDATE member SET m_qr_num = ? WHERE m_num = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		String qr_name = GenerateQRcode.generateQRcode(m_num, m_brith);
		if(qr_name == null) {
			return false;
		}
		try {
			
			conn = DBconnection.getConnection();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, qr_name);
			pstmt.setInt(2, m_num);
			pstmt.executeUpdate();
			conn.commit();
			
			return true;
		}catch (SQLException sqle) {
			conn.rollback();
			throw new RuntimeException(sqle.getMessage());
		} catch (Exception e) {
			conn.rollback();
			throw new RuntimeException(e.getMessage());
		}finally {
			try {
				Close.close(conn, pstmt, null);
			} catch (Exception e) {
				throw new RuntimeException(e.getMessage());
			}
		}
	}
	
	public boolean singUp(MemberBean member) throws SQLException {
		String SQL = "INSERT INTO member VALUES(null,?,?,?,?,?,?,?,?,?,null,?,?,?,null,false,false)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			Date brith = Date.valueOf(member.getM_brith());
			conn = DBconnection.getConnection();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1,SHA256.getEncrypt(member.getM_email()));
			pstmt.setString(2, SHA256.getEncrypt(member.getM_pw()));
			pstmt.setString(3, member.getM_name());
			pstmt.setString(4, member.getM_kana());
			pstmt.setDate(5, brith);
			pstmt.setString(6, member.getM_tel());
			pstmt.setString(7, member.getM_gender());
			pstmt.setString(8, member.getM_zip_code());
			pstmt.setString(9, member.getM_address());
			pstmt.setString(10, member.getM_i_num());
			pstmt.setString(11, member.getM_i_expiry_date());
			pstmt.setString(12, member.getM_i_mark());

			pstmt.executeUpdate();
			conn.commit();
			return true;
		} catch (SQLException sqle) {
			conn.rollback();
			throw new RuntimeException(sqle.getMessage());
		} catch (NullPointerException nule) {
			conn.rollback();
			throw new RuntimeException(nule.getMessage());
		}finally {
			try {
				Close.close(conn, pstmt, null);
			} catch (Exception e) {
				throw new RuntimeException(e.getMessage());
			}
		}
	}
	public int getM_num(String m_email) {
		String SQL = "SELECT m_num FROM member WHERE m_email = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBconnection.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, SHA256.getEncrypt(m_email));
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			}
		}catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}finally {
			try {
				Close.close(conn, pstmt, rs);
			} catch (Exception e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		return -1;
	}
	
	public boolean login(String m_email, String m_pw) {
		String SQL = "SELECT * FROM member WHERE m_email = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBconnection.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, SHA256.getEncrypt(m_email));
			rs = pstmt.executeQuery();
			if(rs.next()) {
				//ユーザが書いたpwとDBのpwと同じだったらログイン成功
				if(rs.getString("m_pw").equals(SHA256.getEncrypt(m_pw))) {
					return true;
				}
			}
		}catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}finally {
			try {
				Close.close(conn, pstmt, rs);
			} catch (Exception e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		return false;
	}
	public boolean isAuth(String m_email) {
		String SQL = "SELECT m_auth FROM member WHERE m_email = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBconnection.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, m_email);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return rs.getBoolean("m_auth");
			}
		}catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}finally {
			try {
				Close.close(conn, pstmt, rs);
			} catch (Exception e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		return false;
	}
	public boolean updateAuth(String m_email) throws SQLException{
		String SQL = "UPDATE member SET m_auth = true WHERE m_email = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBconnection.getConnection();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, m_email);
			int result = pstmt.executeUpdate();
			conn.commit();
			if(result != 1) {
				return false;
			}
			return true;
		}catch (SQLException sqle) {
			conn.rollback();
			throw new RuntimeException(sqle.getMessage());
		} catch (Exception e) {
			conn.rollback();
			throw new RuntimeException(e.getMessage());
		}finally {
			try {
				Close.close(conn, pstmt, null);
			} catch (Exception e) {
				throw new RuntimeException(e.getMessage());
			}
		}
	}
	
	public boolean updateM_q_Num(int m_num,int m_q_num) throws SQLException{
		String SQL = "UPDATE member SET m_q_num = ? WHERE m_num = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBconnection.getConnection();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, m_q_num);
			pstmt.setInt(2, m_num);
			pstmt.executeUpdate();
			conn.commit();
			return true;
		}catch (SQLException sqle) {
			conn.rollback();
			throw new RuntimeException(sqle.getMessage());
		} catch (Exception e) {
			conn.rollback();
			throw new RuntimeException(e.getMessage());
		}finally {
			try {
				Close.close(conn, pstmt, null);
			} catch (Exception e) {
				throw new RuntimeException(e.getMessage());
			}
		}
	}
	public String[] findbyEmailToM_numAndBrith(String m_email) {
		String SQL = "SELECT m_num,m_brith FROM member WHERE m_email = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBconnection.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, m_email);
			rs = pstmt.executeQuery();
			String[] result = new String[2];
			if(rs.next()) {
				result[0] = String.valueOf(rs.getInt("m_num"));
				result[1] = rs.getString("m_brith");
				return result;
			}
			return null;
		}catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}finally {
			try {
				Close.close(conn, pstmt, rs);
			} catch (Exception e) {
				throw new RuntimeException(e.getMessage());
			}
		}
	}
	public MemberBean getMemberBean(String m_email) {
		String SQL = "SELECT * FROM member WHERE m_email = ? AND m_leave = false";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBconnection.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, SHA256.getEncrypt(m_email));
			rs = pstmt.executeQuery();
			if(rs.next()) {
				MemberBean member = new MemberBean(
						rs.getInt("m_num"),
						rs.getString("m_email"),
						rs.getString("m_pw"),
						rs.getString("m_name"),
						rs.getString("m_kana"),
						rs.getString("m_brith").toString(),
						rs.getString("m_tel"),
						rs.getString("m_gender"),
						rs.getString("m_zipcode"),
						rs.getString("m_address"),
						rs.getInt("m_q_num"),
						rs.getString("m_i_num"),
						rs.getString("m_i_expiry_date"),
						rs.getString("m_i_mark"),
						rs.getString("m_qr_num"),
						rs.getBoolean("m_auth"),
						rs.getBoolean("m_leave")
						);
				return member;
			}
			return null;
		}catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}finally {
			try {
				Close.close(conn, pstmt, rs);
			} catch (Exception e) {
				throw new RuntimeException(e.getMessage());
			}
		}
	}
	
	
}
