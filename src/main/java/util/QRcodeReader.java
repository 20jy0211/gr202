package util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

public class QRcodeReader {

	public static void main(String[] args) {
		String searchKeyword = "むらさきいろ";
		try {
            //File file = new File("MyQRCode.png");
            File file = new File("C:\\JSP\\QRcode",searchKeyword+".png");
            BufferedImage bufferedImage = ImageIO.read(file);
            LuminanceSource source = new BufferedImageLuminanceSource(bufferedImage);
            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
            try {
            	Result result = new MultiFormatReader().decode(bitmap);
            	System.out.println("Decoded text = " + result.getText());
            } catch (NotFoundException e) {
                System.out.println("There is no QR code in the image");
            }
        } catch (IOException e) {
            System.out.println("Could not decode QR Code, IOException :: " + e.getMessage());
        }

	}

}
