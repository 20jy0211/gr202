package action.member;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import action.ActionForward;
import model.MemberBean;

public class U01 implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter writer = response.getWriter();
		HttpSession session = request.getSession();
		ActionForward forward = ActionForward.getInstance();

		boolean isError = false;
		List<String> str = new ArrayList<String>();
		List<String[]> array = new ArrayList<String[]>();
		str.add(request.getParameter("email"));
		str.add(request.getParameter("frist_name"));
		str.add(request.getParameter("last_name"));
		str.add(request.getParameter("frist_kana"));
		str.add(request.getParameter("last_kana"));
		str.add(request.getParameter("gender"));
		str.add(request.getParameter("address"));
		str.add(request.getParameter("insurance_mark"));
		str.add(request.getParameter("frist_name"));

		array.add(request.getParameterValues("brith"));
		array.add(request.getParameterValues("tel"));
		array.add(request.getParameterValues("zip_code"));
		String[] insurance_num = request.getParameterValues("insurance_num");
		array.add(request.getParameterValues("insurance_expiry_date"));
		String[] pw = request.getParameterValues("pw");

		String q_blood_type = request.getParameter("blood_type");
		String q_medical_history = request.getParameter("medical_history");
		String q_sick_diray = request.getParameter("sick_diray");
		String q_drink = request.getParameter("drink");
		String q_smoke = request.getParameter("smoke");
		String q_pregnacy = request.getParameter("pregnacy");
		String q_allergy = request.getParameter("allregy");

		//形に当てはまるとtrueを返却する exam) email = dddd@dddd.com => true testパッケージを参考。
		String patternNum = "^[0-9]*$";
		String patternEmail = "^[_a-z0-9-]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$";
		String patternSpace = "\\s";
		String patternString = "^[A-Za-z0-9]{0,50}$";

		//email
		if (str.get(0).matches(patternEmail))
			writer.println("<script>alert('正しいメールアドレスを入力してください。(50文字制限)');</script>");

		//input text type
		for (String ary : str) {
			if ("".equals(ary) || ary == null || "".equals(ary.replaceAll(" ", ""))) {
				writer.println("<script>alert('入力欄には空白・スペース禁止です。');</script>");
			}
		}

		//保険証情報
		for (String ary : insurance_num) {
			if ("".equals(ary) || ary == null || "".equals(ary.replaceAll(" ", ""))) {
				writer.println("<script>alert('保険証情報には空白・スペース禁止です。');</script>");
			}
		}

		//数字のみ情報
		for (String[] i : array) {
			for (String j : i) {
				if ("".equals(j) || j == null || "".equals(j.replaceAll(" ", ""))) {
					writer.println("<script>alert('入力欄には空白・スペース禁止・数字のみです。');</script>");
				}
			}
		}

		MemberBean member = new MemberBean();

		String m_name;
		String m_kana;
		if (member.getUserID().equals("") || member.getUserPassword().equals("") || member.getUserName().equals("")
				|| member.getUserEmail().equals("")) {
			writer.println("<script>alert('記入してない所があります。'); history.back()';</script>");
			writer.close();

			request.getSession().setAttribute("msg", "できませんでした。");
		} else {
			dao.join(member);
			forward.setRedirect(true);
			forward.setPath("index.jsp");
			// 가입성공
			// 가입성공 메시지를 세션에 담는다.
			request.getSession().setAttribute("msg", "会員登録完了、ログインをしてから利用してください。");

		}

		return forward;

	}

}
