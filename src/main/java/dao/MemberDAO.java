package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.MemberBean;
import util.Close;
import util.DBconnection;

public class MemberDAO {
	public boolean join(MemberBean member) throws SQLException {
		String SQL = "INSERT INTO member VALUES(null, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, 0, 0)";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = DBconnection.getConnection();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(SQL);

			pstmt.setString(1, member.getM_email());
			pstmt.setString(2, member.getM_pw());
			pstmt.setString(3, member.getM_name());
			pstmt.setString(4, member.getM_kana());
			pstmt.setString(5, member.getM_brith());
			pstmt.setString(6, member.getM_tel());
			pstmt.setString(7, member.getM_gender());
			pstmt.setString(8, member.getM_zipcode());
			pstmt.setString(9, member.getM_address());
			pstmt.setInt(10, member.getM_question_num());
			pstmt.setString(11, member.getM_i_num());
			pstmt.setString(12, member.getM_i_expiry_date());
			pstmt.setString(13, member.getM_i_mark());
			pstmt.setString(14, member.getM_qr_num());

			// クエリ実行
			pstmt.executeUpdate();
			// 完了しコミット
			con.commit();
			return true;
		} catch (SQLException sqle) {
			// エラー発生にはロールバック
			con.rollback();
			throw new RuntimeException(sqle.getMessage());
		} finally {
			// Connection, PreparedStatement를 닫는다.
			try {
				Close.close(con, pstmt, null);
			} catch (Exception e) {
				throw new RuntimeException(e.getMessage());
			}
		} // end try~catch
	} // end insertMember()
}
