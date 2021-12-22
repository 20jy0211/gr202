package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.Close;
import util.DBconnection;
import util.SHA256;

public class MemberDAOExample {
	public int getNextNum() {
		String SQL = "SELECT customerNum FROM member ORDER BY customerNum DESC";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBconnection.getConnection();
			pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getInt(1) + 1;
			} else {
				return 1;
			}
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			try {
				Close.close(conn, pstmt, rs);
			} catch (Exception e) {
				throw new RuntimeException(e.getMessage());
			}
		} // end try~catch
	}

	public String getDate() {
		String SQL = "SELECT NOW()";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DBconnection.getConnection();
			pstmt = con.prepareStatement(SQL);
			rs = pstmt.executeQuery(); // SQLを実行し結果を持つ
			if (rs.next()) {// 結果がある場合
				return rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Close.close(con, pstmt, rs);
		}
		return ""; // DB ERROR
	}

	public void join(CustomerBean customer) throws SQLException {
		String SQL = "INSERT INTO Customer VALUES(?, ?, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBconnection.getConnection();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(SQL);

			pstmt.setInt(1, getNextNum());
			pstmt.setString(2, customer.getCustomerEmail());
			pstmt.setString(3, customer.getCustomerPw());
			pstmt.setBoolean(4, customer.isAvailableEmail());
			pstmt.setString(5, getDate());

			// クエリ実行
			pstmt.executeUpdate();
			// 完了しコミット
			conn.commit();
		} catch (SQLException sqle) {
			// エラー発生にはロールバック
			conn.rollback();
			throw new RuntimeException(sqle.getMessage());
		} finally {
			// Connection, PreparedStatement를 닫는다.
			try {
				Close.close(conn, pstmt, null);
			} catch (Exception e) {
				throw new RuntimeException(e.getMessage());
			}
		} // end try~catch
	} // end insertMember()

	public boolean login(String customerEmail, String customerPw) {
		String SQL = "SELECT customerPw FROM customer WHERE customerEmail = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBconnection.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, customerEmail);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				// ユーザが書いたpwとDBのpwと同じだったらログイン成功
				if (rs.getString(1).equals(customerPw)) {
					return true;
				}
			}
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			try {
				Close.close(conn, pstmt, rs);
			} catch (Exception e) {
				throw new RuntimeException(e.getMessage());
			}
		} // end try~catch
		return false;
	}

	public CustomerBean getCustomer(String customerEmail) {
		String SQL = "SELECT customerEmail,customerPw FROM customer WHERE customerEmail = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBconnection.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, customerEmail);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				CustomerBean customer = new CustomerBean();
				customer.setCustomerEmail(rs.getNString(1));
				customer.setCustomerPw(rs.getNString(2));
				return customer;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Connection, PreparedStatement를 닫는다.
			try {
				Close.close(conn, pstmt, rs);
			} catch (Exception e) {
				throw new RuntimeException(e.getMessage());
			}
		} // end try~catch
		return null;
	} // end insertMember()

	public boolean checkCustomerEmail(String customerEmail) {
		String SQL = "SELECT customerEmail FROM customer WHERE customerEmail = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBconnection.getConnection();
			pstmt = conn.prepareStatement(SQL);
			customerEmail = SHA256.getEncrypt(customerEmail);
			pstmt.setString(1, customerEmail);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return false;
			} else {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Connection, PreparedStatement를 닫는다.
			try {
				Close.close(conn, pstmt, rs);
			} catch (Exception e) {
				throw new RuntimeException(e.getMessage());
			}
		} // end try~catch
		return true;
	} // end insertMember()

}
