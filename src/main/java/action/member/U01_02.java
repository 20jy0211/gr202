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
//		member.setM_qr_num(memberDAO.generateQRcode(member.getM_num(), member.getM_brith()));
//		if(member.getM_qr_num() == null) {
//			forward.setError(true);
//			writer.println("<script type='text/javascript'>");
//			writer.println("alert('QRコード登録のエラーが発生しました。');");
//			writer.println("</script>");
//			writer.close();
//			return forward;
//		}
		forward.setPath("u01_03.jsp");
		return forward;
	}

}
