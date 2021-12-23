package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import action.ActionForward;
import action.common.U04;
import action.member.U01;
import action.member.U02;

@WebServlet("/MemberController")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// ポリモーフィズムのため action
	private Map<String, Action> contList = new HashMap<>();
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		/*
		 	一回 Servletインスタンスが生産されたら Servletインスタンスはメモリに保存されている。
		 	それで、初めて実行する時だけ init()メソッドを呼び出すことで、処理速度が早くなる。
		*/
		super.init(config);
		contList.put("u01",  new U01());
		contList.put("u02",  new U02());
		contList.put("u04",  new U04());
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
		String action = request.getParameter("action");
		String view = request.getParameter("view");
		// パスを決めるため forward
		ActionForward forward = ActionForward.getInstance();
		
		String path = "/WEB-INF/view/member/";
		try {
			if(view == null || "".equals(view)) {
				forward = contList.get(action).execute(request, response);
				dispatcher = request.getRequestDispatcher(path+forward.getPath());
				dispatcher.forward(request, response);
			}else {
				if("index".equals(view)) {
					forward.setPath(view+".jsp"); // webapp/index
				}else {
					forward.setPath(path+view+".jsp"); // webapp/web-inf/view/member/
				}
				dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
