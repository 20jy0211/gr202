package util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class SHA256 {
	public static void main(String[] args) {
		String email,password;
		email = "kshhoodas";
		password = "1041";
		System.out.println(getEncrypt(email, password));
		System.out.println("e0114d03fa16fe6e30cbe9a67de82ebfc903619ce59b90e4aab8e42fb174141f");
	}
	
	  public static String getSalt() {
		     Random random = new Random();     
		     byte[] salt = new byte[10];

		     random.nextBytes(salt);     

		     StringBuffer sb = new StringBuffer();

		     for(int i=0; i<salt.length; i++) {
		     	sb.append(String.format("%02x", salt[i]));
		     }     

		     return sb.toString();
		  }

		  public static String getEncrypt(String email, String salt) {
			
		      String result = "";
		      try {
		        MessageDigest md = MessageDigest.getInstance("SHA-256");
		        md.update(email.getBytes());
		        byte[] byteDate = md.digest();
		        StringBuffer sb = new StringBuffer();

		        for(int i=0; i<byteDate.length; i++) {
		        	sb.append(Integer.toString((byteDate[i] & 0xFF) + 256, 16).substring(1));
		        }
		        result = sb.toString();

		     } catch (NoSuchAlgorithmException e) {
		        e.printStackTrace();
		     }

		     return result;
		  }
		  
}
