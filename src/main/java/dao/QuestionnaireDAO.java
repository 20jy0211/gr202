package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.QuestionnaireBean;
import util.Close;
import util.DBconnection;

public class QuestionnaireDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public QuestionnaireBean getQuestionnaire(int m_q_num) throws SQLException{
		String SQL = "SELECT * FROM questionnaire WHERE q_num = ?";
		try {

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				Close.close(conn, pstmt, null);
			} catch (Exception e) {
				throw new RuntimeException(e.getMessage());
			}
		}

		QuestionnaireBean questionnaire = new QuestionnaireBean();

		return questionnaire;

	}

	public boolean createQuestionnaire(QuestionnaireBean questionnaire) throws SQLException {
		String SQL = "INSERT INTO questionnaire VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			conn = DBconnection.getConnection();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, questionnaire.getQ_num());
			pstmt.setString(2, questionnaire.getQ_blood_type());
			pstmt.setString(3, questionnaire.getQ_medical_history());
			pstmt.setString(4, questionnaire.getQ_medication());
			pstmt.setBoolean(5, questionnaire.isQ_drink());
			pstmt.setBoolean(6, questionnaire.isQ_smoke());
			pstmt.setBoolean(7, questionnaire.isQ_pregnancy());
			pstmt.setString(8, questionnaire.getQ_allergy());
			pstmt.executeUpdate();
			conn.commit();
			return true;
		} catch (SQLException sqle) {
			conn.rollback();
			throw new RuntimeException(sqle.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				Close.close(conn, pstmt, null);
			} catch (Exception e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		return false;
	}

}
