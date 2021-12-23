package action;

public class MailExample {
	UserDAO userDAO = new UserDAO();
	String userID = null;
	if(session.getAttribute("userID") != null){
		userID = (String) session.getAttribute("userID");
	}
	if(userID == null){
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('ログインをしてください。')");
		script.println("location.href = 'userLogin.jsp");
		script.println("</script>");
		script.close();
		return;
	}
	boolean emailChecked = userDAO.getUserEmailChecked(userID);
	if(emailChecked == true){
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('既にメールの確認が出来ています。')");
		script.println("location.href = 'index.jsp");
		script.println("</script>");
		script.close();
		return; //오류 발생시 JSP페이지 작동 종료
	}
	//사용자에게 보낼 메세지를 기입합니다
	String host = "http://localhost:8080/Lecture_Evaluation/";
	String from = "seongheon1041@gmail.com";
	String to = userDAO.getUserEmail(userID);
	String subject = "キムのメールの確認です。";
	String content = "次のリンクをクリックしてメールの認証を行ってください。" +
			"<a href='" + host + "emailCheckAction.jsp?code=" + new SHA256().getSHA256(to) + "'>メールの確認</a>";
	//SMTP에 접속하기 위해 사용
	Properties p = new Properties();
	p.put("mail.smtp.user", from);
	p.put("mail.smtp.host", "smtp.googlemail.com");
	p.put("mail.smtp.port", "465");
	p.put("mail.smtp.starttls.enable", "true");
	p.put("mail.smtp.auth", "true");
	p.put("mail.smtp.debug", "true");
	p.put("mail.smtp.socketFactory.port", "465");
	p.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	p.put("mail.smtp.socketFactory.fallback", "false");
	
	//사용자에게 관리자 메일 주소로 인증메일을 보내는 구역
	try{
		Authenticator auth = new Gmail(); 
		Session ses = Session.getInstance(p, auth); 
		ses.setDebug(true);
		MimeMessage msg = new MimeMessage(ses); //마임메세지 객체를 이용해서 메일을 보낼수있도록 함
		msg.setSubject(subject); //메일의 제목
		Address fromAddr = new InternetAddress(from);
		msg.setFrom(fromAddr); //보내는 사람의 정보
		Address toAddr = new InternetAddress(to); 
		msg.addRecipient(Message.RecipientType.TO, toAddr); //(리시피언트 타입)받는사람의 정보
		msg.setContent(content, "text/html;charset=UTF8"); //메일에 담길 내용
		Transport.send(msg); //메세지 전송
	}catch(Exception e){
		e.printStackTrace();
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('エラーが発生しました。。')");
		script.println("history.back()");
		script.println("</script>");
		script.close();
		return;
	}
}
