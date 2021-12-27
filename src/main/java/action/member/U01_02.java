package action.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import action.ActionForward;
import dao.MemberDAO;
import dao.QuestionnaireDAO;
import model.MemberBean;
import model.QuestionnaireBean;
import util.Gmail;

public class U01_02 implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter writer = response.getWriter();
		ActionForward forward = new ActionForward();
		HttpSession session = request.getSession();
		
		MemberBean member = (MemberBean) session.getAttribute("member");
		System.out.println(member.toString());
		QuestionnaireBean questionnaire = (QuestionnaireBean) session.getAttribute("questionnaire");
		
		
		MemberDAO memberDAO = new MemberDAO();
		if(!memberDAO.join(member)) {
			forward.setError(true);
			writer.println("<script type='text/javascript'>");
			writer.println("alert('会員登録のエラーが発生しました。');");
			writer.println("</script>");
			writer.close();
			return forward;
		}
		int m_num = memberDAO.getM_num(member.getM_email());
		/* questionnaire */
		questionnaire.setQ_num(memberDAO.getM_num(member.getM_email()));
		if(!new QuestionnaireDAO().createQuestionnaire(questionnaire)) {
			forward.setError(true);
			writer.println("<script type='text/javascript'>");
			writer.println("alert('問診票登録のエラーが発生しました。');");
			writer.println("</script>");
			writer.close();
			return forward;
		}
		if(!memberDAO.updateM_questionnaire_Num(m_num,questionnaire.getQ_num())) {
			forward.setError(true);
			writer.println("<script type='text/javascript'>");
			writer.println("alert('会員の問診票番号登録のエラーが発生しました。');");
			writer.println("</script>");
			writer.close();
			return forward;
		}
		if(!Gmail.sendAuthMain(member.getM_email())) {
			forward.setError(true);
			writer.println("<script type='text/javascript'>");
			writer.println("alert('認証メール送信のエラーが発生しました。');");
			writer.println("</script>");
			writer.close();
			return forward;
		}
		session.invalidate();
		
		forward.setPath("u01_03.jsp");
		return forward;
	}

}
