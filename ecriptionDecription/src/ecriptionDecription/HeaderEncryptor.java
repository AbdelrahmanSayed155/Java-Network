package ecriptionDecription;

import java.io.FileInputStream;
import java.io.InputStream;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.Security;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.ResourceBundle;

import javax.crypto.Cipher;

import org.apache.commons.codec.binary.Base64;

public class HeaderEncryptor {

	

//	private static final char[] HEX_CHARS = { '0', '1', '2', '3', '4', '5',
//			'6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
//	
	private static ResourceBundle rb;
	
	//private static final String DEFAULT_ENCODING = "UTF8";

	private static HeaderEncryptor headerEncryptor;

	//private static KeyPair keyPair;
	
	private static	 byte[] encKey =null;

	private HeaderEncryptor() {}

//	public static HeaderEncryptor getInstance() {
//
//		if (headerEncryptor == null) {
//			if (Security.getProvider("BC") == null) {
//				//Security.addProvider(new BouncyCastleProvider());
//			}
//			
//
//			if (encKey == null) {
//				rb = ResourceBundle.getBundle("enrichment-config");
//				// if the private key is not encrypted, pass can be anything.
//				//keyPair = readKeyPair(new File(rb.getString("enrichment.keyPath")), "pass");
//				encKey = 	getPVKey(rb.getString("enrichment.keyPath"));
//		
//	 
//			}
//			headerEncryptor = new HeaderEncryptor();
//		}
//		return headerEncryptor;
//	}

	private static byte[] getPVKey(String string) {
		byte[] encKey = null;
		try {

		 InputStream     inStream=new FileInputStream(string);
         encKey=new byte[inStream.available()];
         inStream.read(encKey);
         inStream.close();
     	encKey = new Base64().decode(encKey);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return encKey;
	}


	
	public String decrypt(String header) {
		//return decrypt(header, DEFAULT_ENCODING);
		  byte[]     textBytes=null;
		try {
			Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding","BC");   
            PKCS8EncodedKeySpec privKeySpec=new PKCS8EncodedKeySpec(encKey);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PrivateKey priv= (RSAPrivateKey) keyFactory.generatePrivate(privKeySpec);
             cipher.init(Cipher.DECRYPT_MODE, priv); 
             byte[]      encKey1 =	  new Base64().decode(header);
            textBytes = cipher.doFinal(encKey1);
            
		} catch (Exception e) {
		e.printStackTrace();
	}
		
		return new String(textBytes);
	}
	
	
	public String encrypt(String text) {
	try {
		
		ResourceBundle	rb = ResourceBundle.getBundle("enrichment-config");
		RSAPublicKey pubkey =getPublicKey(rb.getString("enrichment.certificate"));
		   Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding","BC");   
		  cipher.init(Cipher.ENCRYPT_MODE, pubkey); 
		return new String( new Base64().encode(cipher.doFinal(text.getBytes())));
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	return null;
}

	private RSAPublicKey getPublicKey(String certFile) {
		InputStream inStream=null;
		 CertificateFactory cf=null;
		 RSAPublicKey pubkey = null;
		try {
			inStream = new FileInputStream(certFile);
		
        cf = CertificateFactory.getInstance("X.509");
        X509Certificate cert =(X509Certificate)cf.generateCertificate(inStream);
        inStream.close();
        pubkey = (RSAPublicKey) cert.getPublicKey();
        
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return pubkey;
	}
	
	
}
