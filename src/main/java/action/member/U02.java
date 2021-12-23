package action.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.ActionForward;

public class U02 implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8"); 
		ActionForward forward = ActionForward.getInstance();
		PrintWriter writer = response.getWriter(); 
		
		
		
		if(member.getUserID().equals("") || member.getUserPassword().equals("") || member.getUserName().equals("") ||
				member.getUserEmail().equals("")) {
			writer.println("<script>alert('記入してない所があります。'); history.back()';</script>"); 
			writer.close();

			request.getSession().setAttribute("msg", "できませんでした。");
		}else {
			dao.join(member);
			forward.setRedirect(true);
	           forward.setPath("index.jsp");
			
			
		}
		
        return forward;
	}

}
