package util;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class GenerateQRcode {
	private static GenerateQRcode generateQRcode = new GenerateQRcode();
	public GenerateQRcode() {}
	
	public static GenerateQRcode getInstatnce() {w
		return generateQRcode;
	}
	public String makeQRcode(String name) {
		
		return name;
	}
	
	public String readQRcode(String name) {
		return name;
	}
	public static void main(String[] args) {
		QRCodeWriter write = new QRCodeWriter();
		String path = "C:\\JSP\\QRcode";
		
		try {
			//파일 경로가 없으면 생성하기
			File file = new File(path); 
			if(!file.exists()) { 
		   	 	file.mkdirs(); 
			} 
			String text = "kkk@kkk.com";
			System.out.println(text);
			text = new String(text.getBytes("UTF-8"));
			System.out.println(text);
			//
			BitMatrix bitMatrix = write.encode(text, BarcodeFormat.QR_CODE, 400, 400);
			//qrcodeColor, backgroundColor
			MatrixToImageConfig config = new MatrixToImageConfig(0x00000000 , 0xFFFFFFFF);
			BufferedImage qrImage = MatrixToImageWriter.toBufferedImage(bitMatrix , config);
			
		    //파일 이름 , 파일 확장자에 맡는 파일 생성
			File temp =  new File(path, text+".png"); 
			// ImageIO를 사용하여 파일쓰기 temp 위치에 qr이 이미지 생성됨. 
			ImageIO.write(qrImage, "png",temp );
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
