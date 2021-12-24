package action.member;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import action.ActionForward;
import model.MemberBean;
import model.QuestionnaireBean;
import util.XssFilter;

public class U01_01 implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter writer = response.getWriter();
		HttpSession session = request.getSession();
		ActionForward forward = ActionForward.getInstance();

		/* 会員情報 */
		Map<String,String> map = new HashMap<String,String>();
		map.put("email",request.getParameter("email"));
		map.put("frist_name",request.getParameter("frist_name"));
		map.put("last_name",request.getParameter("last_name"));
		map.put("frist_kana",request.getParameter("frist_kana"));
		map.put("last_kana",request.getParameter("last_kana"));
		map.put("gender",request.getParameter("gender"));
		map.put("address",request.getParameter("address"));
		map.put("insurance_mark",request.getParameter("insurance_mark"));
		String[] brith = request.getParameterValues("brith");
		String[] tel = request.getParameterValues("tel");
		String[] zip_code = request.getParameterValues("zip_code");
		String[] insurance_num = request.getParameterValues("insurance_num");
		String[] insurance_expiry_date = request.getParameterValues("insurance_expiry_date");
		
		Map<String,String> mapNum = new HashMap<String,String>();
		mapNum.put("brith", brith[0]+"-"+brith[1]+"-"+brith[2]);
		mapNum.put("tel", tel[0]+"-"+tel[1]+"-"+tel[2]);
		mapNum.put("zip_code", zip_code[0]+"-"+zip_code[1]);
		mapNum.put("insurance_num", insurance_num[0]+"-"+insurance_num[1]);
		mapNum.put("insurance_expiry_date", insurance_expiry_date[0]+"-"+insurance_expiry_date[1]+"-"+insurance_expiry_date);
		String[] pw = XssFilter.stripTagAll(request.getParameterValues("pw"));
		
		map = XssFilter.stripTagAll(map);
		mapNum = XssFilter.stripTagAll(mapNum);
		
		/* 問診票 */
		Map<String,String> q_map = new HashMap<String,String>();
		QuestionnaireBean questionnaire = new QuestionnaireBean();
		q_map.put("blood_type", request.getParameter("blood_type"));
		q_map.put("medical_history", request.getParameter("medical_history"));
		q_map.put("sick_diray", request.getParameter("sick_diray"));
		q_map.put("drink", request.getParameter("drink"));
		q_map.put("smoke", request.getParameter("smoke"));
		q_map.put("pregnacy", request.getParameter("pregnacy"));
		q_map.put("allregy", request.getParameter("allregy"));
		q_map = XssFilter.stripTagAll(q_map);
		
		questionnaire.setQ_blood_type(q_map.get("blood_type"));
		questionnaire.setQ_medical_history(q_map.get("medical_history"));
		questionnaire.setQ_sick_diray(q_map.get("sick_diray"));
		questionnaire.setQ_drink("1".equals(q_map.get("drink")) ? true : false);
		questionnaire.setQ_smoke("1".equals(q_map.get("smoke")) ? true : false);
		questionnaire.setQ_pregnancy("1".equals(q_map.get("pregnacy")) ? true : false);
		questionnaire.setQ_allergy(q_map.get("allregy"));
		
		session.setAttribute("questionnaire", q_map);
		
		String patternNum = "^[0-9]*$";
		String patternEmail = "\\w+@\\w+\\.\\w+(\\.\\w+)?";
		String patternSpace = "\\s";
		String patternString = "^[A-Za-z0-9]{8,50}$";

		//email
		if("".equals(map.get("email")) && map.get("email") != null) {
			if (map.get("email").matches(patternEmail)) {
				forward.setError(true);
				forward.setErrorMsg("正しいメールアドレスを入力してください。\n");
			}
		}
		if(pw[0] != null && pw[0] != null && "".equals(pw[0]) && "".equals(pw[1])) {
			if(!pw[0].equals(pw[1]) || !pw[0].matches(patternString) || !pw[1].matches(patternString)) {
				forward.setError(true);
				forward.setErrorMsg("確認パスワードと一致してください。\n");
			}
		}

		//input text type
		for (String ary : map.keySet()) {
			if ("".equals(map.get(ary)) || map.get(ary) == null || map.get(ary).matches(patternSpace)) {
				forward.setError(true);
			}
		}
		if(forward.isError() && forward.getErrorMsg() != null && forward.getErrorMsg().indexOf("数字のみの入力欄には空白・スペース禁止です。") == -1) {
			forward.setErrorMsg("入力欄には空白・スペース禁止です。\n");
		}

		//数字のみ情報
		for (String value : mapNum.values()) {
			if(!"".equals(value) && value != null && !"".equals(value.replaceAll(" ", "")) && !value.matches(patternNum)) {
				value = value.replaceAll("-", "");
			}else {
				forward.setError(true);
			}
		}
		if(forward.isError() && forward.getErrorMsg() != null && forward.getErrorMsg().indexOf("数字のみの入力欄には空白・スペース禁止です。") == -1) {
			forward.setErrorMsg("数字のみの入力欄には空白・スペース禁止です。\n");
		}
		/* 問題がある場合、returnして処理を終わらせる。 */
		if(forward.isError()) {
			return forward;
		}
		MemberBean member = new MemberBean();
		member.setM_email(map.get("email"));
		member.setM_name(map.get("frist_name") +" "+ map.get("last_name"));
		member.setM_kana(map.get("frist_kana") +" "+ map.get("last_kana"));
		member.setM_gender(map.get("gender"));
		member.setM_address(map.get("address"));
		member.setM_i_mark(map.get("insurance_mark"));
		member.setM_brith(map.get("brith"));
		member.setM_tel(map.get("tel"));
		member.setM_zipcode(map.get("zipcode"));
		member.setM_i_num(map.get("insurance_num"));
		member.setM_i_expiry_date(map.get("insurance_expiry_date"));
		
		//問診票Beanを作り、値を入れてsessionに登録する。
		
		forward.setPath("u01_02.jsp");
		session.setAttribute("member", member);
//		System.out.println(member.toString());
//		System.out.println(questionnaire.toString());
		return forward;

	}

}
