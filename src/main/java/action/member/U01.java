package action.member;

import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		Map<String,String> str = new HashMap<String,String>();
		List<String[]> array = new ArrayList<String[]>();
		str.put("email",request.getParameter("email"));
		str.put("frist_name",request.getParameter("frist_name"));
		str.put("last_name",request.getParameter("last_name"));
		str.put("frist_kana",request.getParameter("frist_kana"));
		str.put("last_kana",request.getParameter("last_kana"));
		str.put("gender",request.getParameter("gender"));
		str.put("address",request.getParameter("address"));
		str.put("insurance_mark",request.getParameter("insurance_mark"));

		array.add(request.getParameterValues("brith"));
		array.add(request.getParameterValues("tel"));
		array.add(request.getParameterValues("zip_code"));
		array.add(request.getParameterValues("insurance_num"));
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
		String patternEmail = "\\w+@\\w+\\.\\w+(\\.\\w+)?";
		String patternSpace = "\\s";
		String patternString = "^[A-Za-z0-9]{0,50}$";

		//email
		if (str.get("email").matches(patternEmail)) {
			System.out.println(str.get("email"));
			System.out.println("email error");
			isError = true;
			
			writer.println("<script type='text/javascript'>");
			writer.println("alert('正しいメールアドレスを入力してください。');");
			writer.println("history.back();");
			writer.println("</script>");
		}
		if(!pw[0].equals(pw[1])) {
			System.out.println("password error");
			isError = true;
			writer.println("<script type='text/javascript'>");
			writer.println("alert('確認パスワードと一致してください。');");
			writer.println("history.back();");
			writer.println("</script>");
		}

		//input text type
		for (String ary : str.keySet()) {
			if ("".equals(str.get(ary)) || str.get(ary) == null || str.get(ary).matches(patternSpace)) {
				System.out.println("text box error");
				isError = true;
				writer.println("<script type='text/javascript'>");
				writer.println("alert('入力欄には空白・スペース禁止です。');");
				writer.println("history.back();");
				writer.println("</script>");
			}
		}

		//数字のみ情報
		for (String[] i : array) {
			for (String j : i) {
				if ("".equals(j) || j == null || "".equals(j.replaceAll(" ", "")) || !j.matches(patternNum)) {
					System.out.println("number error");
					isError = true;
					writer.println("<script type='text/javascript'>");
					writer.println("alert('入力欄には空白・スペース禁止・数字のみです。');");
					writer.println("history.back();");
					writer.println("</script>");
				}
			}
		}
		if(isError) {
			System.out.println("isError is true");
			forward.setRedirect(true);
			forward.setPath("u01_01.jsp");
			return forward;
		}
		MemberBean member = new MemberBean();
		member.setM_email(str.get("email"));
		member.setM_name(str.get("frist_name") +" "+ str.get("last_name"));
		member.setM_kana(str.get("frist_kana") +" "+ str.get("last_kana"));
		member.setM_gender(str.get("gender"));
		member.setM_address(str.get("address"));
		member.setM_i_mark(str.get("insurance_mark"));
		member.setM_brith(array.get(0)[0]+"-"+array.get(0)[1]+"-"+array.get(0)[2]);
		member.setM_tel(array.get(1)[0]+"-"+array.get(1)[1]+"-"+array.get(1)[2]);
		member.setM_zipcode(array.get(2)[0]+"-"+array.get(2)[1]);
		member.setM_i_num(array.get(3)[0]+"-"+array.get(3)[1]);
		member.setM_i_expiry_date(array.get(4)[0]+"-"+array.get(4)[1]+"-"+array.get(4)[2]);
		
		
		forward.setRedirect(true);
		forward.setPath("u01_02.jsp");
		session.setAttribute("member", member);
		System.out.println(member.toString());
		return forward;

	}

}
