package util;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Gmail {

	public static boolean sendAuthMain(String m_email) {
		//사용자에게 보낼 메세지를 기입합니다
		String dbName = "gr202";
		String host = "http://localhost:14276/"+dbName+"/";
		String from = "cocojycompany@gmail.com";
		String to = m_email;
		String subject = "COCO薬局ユーザー認証メール";
		
		String content = "この度は、COCO薬局にお申し込み頂きまして誠にありがとうございます。\n"
				+ "ご本人様確認のため、下記URLへアクセスしアカウントの本登録を完了させて下さい。\n"
				+ "\n"
				+ "\n"
				+ "URL： "+host +"MemberController?action=u01_04&email="+SHA256.getEncrypt(to)
				+ "\n"
				+ "\n"
				+ "※当メールに心当たりの無い場合は、誠に恐れ入りますが破棄して頂けますよう、よろしくお願い致　します。\n"
				+ "＊このメールは自動送信しておりますので、お問い合わせはホームページよりお願いいたします。\n"
				+ "\n"
				+ "\n"
				+ "ーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーー\n"
				+ "\n"
				+ "株式会社COCO薬局\n"
				+ "\n"
				+ "URL：http://localhost:14276/"+ dbName +"/index.jsp"
				+ "住所：〒160-0023　東京都新宿区西新宿5-6-7\n"
				+ "TEL ：02-1234-5678";
		
		
//				"<a href='" + host + "MemberController?view=?code=" + to + "'>メールの確認</a>";
		//SMTP에 접속하기 위해 사용
		Properties p = new Properties();
		p.put("mail.smtp.ssl.enable", "true");
		p.put("mail.smtp.user", from);
		p.put("mail.smtp.host", "smtp.gmail.com");
		p.put("mail.smtp.port", "465");
		p.put("mail.smtp.starttls.enable", "true");
		p.put("mail.smtp.auth", "true");
		p.put("mail.smtp.connectiontimeout", "1000");
		p.put("mail.smtp.socketFactory.port", "465");
		p.put("mail.smtp.timeout", "1000"); 
		p.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		p.put("mail.smtp.socketFactory.fallback", "false");
		
		//사용자에게 관리자 메일 주소로 인증메일을 보내는 구역
		try{
			Authenticator auth = new CompanyGmail(); 
			Session ses = Session.getInstance(p, auth); 
			ses.setDebug(true);
			MimeMessage msg = new MimeMessage(ses); //마임메세지 객체를 이용해서 메일을 보낼수있도록 함
			Address fromAddr = new InternetAddress(from);
			Address toAddr = new InternetAddress(to); 
			msg.setSubject(subject); //메일의 제목
			msg.setFrom(fromAddr); //보내는 사람의 정보
			msg.addRecipient(Message.RecipientType.TO, toAddr); //(리시피언트 타입)받는사람의 정보
			msg.setContent(content, "text/html;charset=UTF8"); //메일에 담길 내용
			Transport t = ses.getTransport("smtp");
			try {
				t.connect();
				t.sendMessage(msg, msg.getAllRecipients());

			}catch(Exception e) {
				e.printStackTrace();
			}finally {
			  t.close();
			}

			return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	

}
