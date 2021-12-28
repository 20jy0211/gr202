package action.member;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
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
		ActionForward forward = new ActionForward();

		String brith = request.getParameterValues("brith")[0] + "-" + request.getParameterValues("brith")[1] + "-"
				+ request.getParameterValues("brith")[2];
		String tel = request.getParameterValues("tel")[0] + "-" + request.getParameterValues("tel")[1] + "-"
				+ request.getParameterValues("tel")[2];
		String zip_code = request.getParameterValues("zip_code")[0] + "-" + request.getParameterValues("zip_code")[1];
		String insurance_num = request.getParameterValues("insurance_num")[0] + "-"
				+ request.getParameterValues("insurance_num")[1];
		String insurance_expiry_date = request.getParameterValues("insurance_expiry_date")[0] + "-"
				+ request.getParameterValues("insurance_expiry_date")[1] + "-"
				+ request.getParameterValues("insurance_expiry_date")[2];

		/* 会員情報 */
		Map<String, String> map = new HashMap<String, String>();
		map.put("email", request.getParameter("email"));
		map.put("frist_name", request.getParameter("frist_name").replaceAll("\\t", ""));
		map.put("last_name", request.getParameter("last_name").replaceAll("\\t", ""));
		map.put("frist_kana", request.getParameter("frist_kana").replaceAll("\\t", ""));
		map.put("last_kana", request.getParameter("last_kana").replaceAll("\\t", ""));
		map.put("brith", brith);
		map.put("tel", tel);
		map.put("gender", request.getParameter("gender"));
		map.put("zip_code", zip_code);
		map.put("address", request.getParameter("address"));
		map.put("insurance_num", insurance_num);
		map.put("insurance_expiry_date", insurance_expiry_date);
		map.put("insurance_mark", request.getParameter("insurance_mark"));

		/* 問診票 */
		Map<String, String> q_map = new HashMap<String, String>();
		q_map.put("blood_type", request.getParameter("blood_type"));
		q_map.put("medical_history", request.getParameter("medical_history").replaceAll("\r\n", "</br>"));
		q_map.put("medication", request.getParameter("medication").replaceAll("\r\n", "</br>"));
		q_map.put("drink", request.getParameter("drink"));
		q_map.put("smoke", request.getParameter("smoke"));
		q_map.put("pregnancy", request.getParameter("pregnancy"));
		q_map.put("allergy", request.getParameter("allergy").replaceAll("\r\n", "</br>"));

		String patternNum = "^[0-9]*$";
		String patternEmail = "\\w+@\\w+\\.\\w+(\\.\\w+)?";
		String patternPw = "^[A-Za-z0-9]{8,64}$";

		String[] pw = XssFilter.stripTagAll(request.getParameterValues("pw"));
		map = XssFilter.stripTagAll(map);
		q_map = XssFilter.stripTagAll(q_map);

		// email
		if (!map.get("email").matches(patternEmail)) {
			forward.setError(true);
			writer.println("<script type='text/javascript'>");
			writer.println("alert('正しいメールアドレスを入力してください。');");
			writer.println("</script>");
			writer.close();
			return forward;
		}

		// input text type
		for (String ary : map.keySet()) {
			if ("".equals(map.get(ary)) || map.get(ary) == null || "".equals(map.get(ary).replaceAll("\\t", ""))) {
				forward.setError(true);
				writer.println("<script type='text/javascript'>");
				writer.println("alert('入力欄には空白・スペース禁止です。');");
				writer.println("</script>");
				writer.close();
				return forward;
			}
		}

		// 数字のみ情報
		for (String value : map.values()) {
			if (!"".equals(value) && value != null) {
				if (value.indexOf("-") != -1) {
					value = value.replaceAll("-", "");
					if (!value.matches(patternNum) && "".equals(value.replaceAll("\\t", ""))) {
						forward.setError(true);
						writer.println("<script type='text/javascript'>");
						writer.println("alert('数字のみの入力欄には数字だけ入力してください。');");
						writer.println("</script>");
						writer.close();
						return forward;
					}
				}
			}
		}
		if (map.get("brith").length() != 10) {
			forward.setError(true);
			writer.println("<script type='text/javascript'>");
			writer.println("alert('正しい生年月日を入力してください。\n 例)1998年01月05日');");
			writer.println("</script>");
			writer.close();
			return forward;
		}
		if (map.get("insurance_expiry_date").length() != 10) {
			forward.setError(true);
			writer.println("<script type='text/javascript'>");
			writer.println("alert('正しい生年月日を入力してください。\n 例)1998年01月05日');");
			writer.println("</script>");
			writer.close();
			return forward;
		}

		// password
		if (pw[0] == null || pw[1] == null || "".equals(pw[0]) || "".equals(pw[1])) {
			forward.setError(true);
			writer.println("<script type='text/javascript'>");
			writer.println("alert('パスワードは8文字以上を入力してください。');");
			writer.println("</script>");
			writer.close();
			return forward;
		} else {
			if (!pw[0].equals(pw[1])) {
				forward.setError(true);
				writer.println("<script type='text/javascript'>");
				writer.println("alert('確認パスワードと一致してください。');");
				writer.println("</script>");
				writer.close();
				return forward;
			} else if (!pw[0].matches(patternPw) || !pw[1].matches(patternPw) || pw[0].length() < 8
					|| pw[1].length() < 8) {
				forward.setError(true);
				writer.println("<script type='text/javascript'>");
				writer.println("alert('パスワードは英数字のみ入力してください。');");
				writer.println("</script>");
				writer.close();
				return forward;
			} else if (pw[0].indexOf(" ") != -1 || pw[1].indexOf(" ") != -1) {
				forward.setError(true);
				writer.println("<script type='text/javascript'>");
				writer.println("alert('パスワードにはスペース禁止です。');");
				writer.println("</script>");
				writer.close();
				return forward;
			}
		}

		/* 問題がある場合、returnして処理を終わらせる。 */
		if (forward.isError()) {
			writer.println("<script type='text/javascript'>");
			writer.println("alert('asd');");
			writer.println("</script>");
			writer.close();
			return forward;
		}

		/* 会員情報 */
		MemberBean member = new MemberBean();
		member.setM_email(map.get("email"));
		member.setM_pw(pw[0]);
		member.setM_name(map.get("frist_name") + " " + map.get("last_name"));
		member.setM_kana(map.get("frist_kana") + " " + map.get("last_kana"));
		member.setM_gender(map.get("gender"));
		member.setM_address(map.get("address"));
		member.setM_i_mark(map.get("insurance_mark"));
		member.setM_brith(map.get("brith"));
		member.setM_tel(map.get("tel"));
		member.setM_zip_code(map.get("zip_code"));
		member.setM_i_num(map.get("insurance_num"));
		member.setM_i_expiry_date(map.get("insurance_expiry_date"));

		/* 問診票情報 */
		QuestionnaireBean questionnaire = new QuestionnaireBean();
		questionnaire.setQ_blood_type(q_map.get("blood_type"));
		questionnaire.setQ_medical_history(q_map.get("medical_history"));
		questionnaire.setQ_medication(q_map.get("medication"));
		questionnaire.setQ_drink("1".equals(q_map.get("drink")) ? true : false);
		questionnaire.setQ_smoke("1".equals(q_map.get("smoke")) ? true : false);
		questionnaire.setQ_pregnancy("1".equals(q_map.get("pregnancy")) ? true : false);
		questionnaire.setQ_allergy(q_map.get("allergy"));

		session.setAttribute("questionnaire", questionnaire);

		forward.setPath("u01_02");
		session.setAttribute("member", member);
		return forward;

	}

}
