package action.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import action.ActionForward;
import dao.MemberDAO;
import model.MemberBean;

public class U02 implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8"); 
		ActionForward forward = new ActionForward();
		HttpSession session = request.getSession();
		PrintWriter writer = response.getWriter(); 
		String m_email = request.getParameter("email").replaceAll("\\s", "");
		String m_pw = request.getParameter("password").replaceAll("\\s", "");
		MemberDAO memberDAO = new MemberDAO();
		
		String patternPw = "^[A-Za-z0-9]{8,64}$";
		if(patternPw.matches(m_pw)) {
			forward.setError(true);
			writer.println("<script type='text/javascript'>");
			writer.println("alert('パスワードは英数字のみ8桁以上を入力してください。');");
			writer.println("</script>");
			writer.close();
			return forward;
		}
		if(memberDAO.login(m_email, m_pw)) {
			MemberBean member = memberDAO.getMemberBean(m_email);
			if(member != null) {
				session.setAttribute("member", member);
				forward.setPath("index");
				return forward;
			}else {
				forward.setError(true);
				writer.println("<script type='text/javascript'>");
				writer.println("alert('利用者を見つけませんでした。問い合わせしてください。');");
				writer.println("</script>");
				writer.close();
				return forward;
			}
		}
		forward.setError(true);
		writer.println("<script type='text/javascript'>");
		writer.println("alert('メールアドレス又はパスワードが間違いです。もう一度確認してください。');");
		writer.println("</script>");
		writer.close();
		return forward;
		
	}

}
