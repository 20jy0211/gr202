package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.ActionForward;
import customer.action.CustomerJoinAction;
import customer.action.CustomerLoginAction;
import customer.action.CustomerLogoutAction;

@WebServlet("/CustomerController")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map<String, Action> contList = new HashMap<>();

	@Override
	public void init(ServletConfig config) throws ServletException {
		/*
			한 번 Servlet 객체가 생성되었기 때문에, Servlet 객체는 메모리에 저장되어 있습니다.
			그래서 이번에는 init() 메서드를 호출하지 않고, 곧바로 service() 메서드를 호출합니다.
		*/
		super.init(config);
		contList.put("CustomerJoin",  new CustomerJoinAction());
		contList.put("CustomerLogin",  new CustomerLoginAction());
		contList.put("CustomerLogout",  new CustomerLogoutAction());
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		RequestDispatcher dispatcher;
		String command = request.getParameter("action");
		String viewPage = request.getParameter("viewPage");
		// パスを決めるため forward
		ActionForward forward = new ActionForward();
		// ポリモーフィズムのため action
		Action action = null;
		String url = "/WEB-INF/views/customer/";
		try {
			if(viewPage == null && viewPage.equals("")) {
				forward = contList.get(command).execute(request, response);
				if (forward.isRedirect()) {
					dispatcher = request.getRequestDispatcher(forward.getPath());
					dispatcher.forward(request, response);
				}else {
					response.sendRedirect(forward.getPath());
				}
			}else {
				if(viewPage.equals("index")) {
					forward.setPath(viewPage+".jsp");
				}else {
					forward.setPath(url+viewPage+".jsp");
				}
				dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
