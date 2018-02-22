import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

public class EncDec {
	
	
	
	public static String encrypt(String key, String value) {
        try {
            IvParameterSpec iv = new IvParameterSpec("RandomInitVector".getBytes("UTF-8"));
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);

            byte[] encrypted = cipher.doFinal(value.getBytes());
//            System.out.println("encrypted string: "
//                    + encrypted);

            return  Base64.encodeBase64String(encrypted);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public static String decrypt(String key, String encrypted) {
        try {
            IvParameterSpec iv = new IvParameterSpec("RandomInitVector".getBytes("UTF-8"));
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);

            byte[] l = encrypted.getBytes();
            byte[] original = cipher.doFinal(Base64.decodeBase64(encrypted));

            return new String(original);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public static void main(String[] args) {
    	
    	
    	
        String key = "Bar12345Bar12345"; // 128 bit key
       // String initVector = "RandomInitVector"; // 16 bytes IV

        System.out.println("-----------------1-----------------");
        String word1 =  "INTERNET";
        String encword1 = "n4jwrIBMpkhaWjYNAmYk7g==";//encrypt(key, initVector, word1);
        System.out.println("word 1 encryption {"+encword1+"}");
        System.out.println("word 1 dencryption {"+decrypt(key,encword1)+"}");
        System.out.println("----------------1------------------");
        System.out.println("\n");
        
        System.out.println("----------------2------------------");
        String word2 =  "internet1";
        String encword2 = "CDJMvitiHOPd84S9LGHt7A==";//encrypt(key, initVector, word2);
        System.out.println("word 2 encryption {"+encword2+"}");
        System.out.println("word 2 dencryption {"+decrypt(key,encword2)+"}");
        System.out.println("----------------2------------------");
        System.out.println("\n");
        
        System.out.println("----------------3------------------");
        String word3 =  "my010";
        String encword3 = /*"CDJMvitiHOPd84S9LGHt7A==";*/encrypt(key, word3);
        System.out.println("word 2 encryption {"+encword3+"}");
        System.out.println("word 2 dencryption {"+decrypt(key,encword3)+"}");
        System.out.println("----------------3------------------");
        System.out.println("\n");

        System.out.println("----------------4------------------");
        String word4 =  "micro1";
        String encword4 = /*"CDJMvitiHOPd84S9LGHt7A==";*/encrypt(key, word4);
        System.out.println("word 2 encryption {"+encword4+"}");
        System.out.println("word 2 dencryption {"+decrypt(key,encword4)+"}");
        System.out.println("----------------4------------------");
        System.out.println("\n");
        
        
        
        System.out.println("\n");
 
        
        System.out.println("----------------5------------------");
        String word5 =  "welcome1";
        String encword5 = /*"CDJMvitiHOPd84S9LGHt7A==";*/encrypt(key, word5);
        System.out.println("word 2 encryption {"+encword5+"}");
        System.out.println("word 2 dencryption {"+decrypt(key,encword5)+"}");
        System.out.println("----------------5------------------");
        System.out.println("\n");
        
        
        
        System.out.println("----------------6------------------");
        String word6 =  "oauth2";
        String encword6 = /*"CDJMvitiHOPd84S9LGHt7A==";*/encrypt(key, word6);
        System.out.println("word 2 encryption {"+encword6+"}");
        System.out.println("word 2 dencryption {"+decrypt(key,encword6)+"}");
        System.out.println("----------------6------------------");
        System.out.println("\n");
        
        
        System.out.println("----------------7------------------");
        String word7 =  "oauth2_123";
        String encword7 = /*"CDJMvitiHOPd84S9LGHt7A==";*/encrypt(key, word7);
        System.out.println("word 2 encryption {"+encword7+"}");
        System.out.println("word 2 dencryption {"+decrypt(key,encword7)+"}");
        System.out.println("----------------7------------------");
        System.out.println("\n");
        
        
        System.out.println("----------------8------------------");
        String word8 =  "SYSADM";
        String encword8 = /*"CDJMvitiHOPd84S9LGHt7A==";*/encrypt(key, word8);
        System.out.println("word 2 encryption {"+encword8+"}");
        System.out.println("word 2 dencryption {"+decrypt(key,encword8)+"}");
        System.out.println("----------------8------------------");
        
        System.out.println("----------------9------------------");
        String word9 =  "sysadm";
        String encword9 = /*"CDJMvitiHOPd84S9LGHt7A==";*/encrypt(key, word9);
        System.out.println("word 2 encryption {"+encword9+"}");
        System.out.println("word 2 dencryption {"+decrypt(key,encword9)+"}");
        System.out.println("----------------9------------------");
        
//        
//        System.out.println(decrypt(key, initVector,
//                encrypt(key, initVector, "Hello World")));
//        
        
        
        
        
    }

}
