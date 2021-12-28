package action.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import action.ActionForward;
import dao.MemberDAO;
import model.MemberBean;

public class U01_04 implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter writer = response.getWriter();
		ActionForward forward = new ActionForward();
		HttpSession session = request.getSession();
		String m_email = request.getParameter("email");
		System.out.println(m_email);
		MemberDAO memberDAO = new MemberDAO();
		if(memberDAO.isAuth(m_email)) {
			forward.setPath("u02");
			writer.println("<script type='text/javascript'>");
			writer.println("alert('既にメールアドレスの認証がされています。');");
			writer.println("</script>");
			writer.close();
			return forward;
		}
		if(!memberDAO.updateAuth(m_email)) {
			forward.setError(true);
			writer.println("<script type='text/javascript'>");
			writer.println("alert('メール認証のエラーが発生しました。\nもう一度、認証URLにアクセスしてください。');");
			writer.println("</script>");
			writer.close();
			return forward;
		}
		String[] m_numANDm_brith = memberDAO.findbyEmailToM_numAndBrith(m_email);
		if(!memberDAO.generateQRcode(Integer.parseInt(m_numANDm_brith[0]), m_numANDm_brith[1])) {
			forward.setError(true);
			writer.println("<script type='text/javascript'>");
			writer.println("alert('QRコード登録のエラーが発生しました。\n管理者に問い合わせしてください。');");
			writer.println("</script>");
			writer.close();
			return forward;
		}
		
		
		forward.setPath("u01_04");
		return forward;
	}

}
