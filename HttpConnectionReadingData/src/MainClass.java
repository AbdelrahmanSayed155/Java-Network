import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

/**
 * 
 */

/**
 * @author Abdelrahman Sayed
 *
 * Mar 4, 2018
 */
public class MainClass {
	
	
	public static void main( String [] args){
		
		  System.out.println("Starting url connection");
	        try {
	            URL url = new URL("https://www.google.com/recaptcha/api/siteverify");//new URL("https://www.opensuse.org");
	            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
	            System.out.println("response Code is" +httpsURLConnection.getResponseCode());
	            System.out.println("response message is" +httpsURLConnection.getResponseMessage());
	            System.out.println("Content message is" +httpsURLConnection.getContent());
	            
	            if ((httpsURLConnection.getResponseCode()+"").startsWith("2")){
	            BufferedReader br = new BufferedReader(new InputStreamReader((httpsURLConnection.getInputStream())));
	            StringBuilder  sb = new StringBuilder();
	            String output;
	            while ((output = br.readLine()) != null) {
	            sb.append(output);
	            }
	            System.out.println(" success Respose " + sb.toString());
	            }else{
	            	 BufferedReader br = new BufferedReader(new InputStreamReader((httpsURLConnection.getErrorStream())));
	 	            StringBuilder  sb = new StringBuilder();
	 	            String output;
	 	            while ((output = br.readLine()) != null) {
	 	            sb.append(output);
	 	            }
	 	           System.out.println("error Respose " + sb.toString());
	            }
	            
	            
	        }catch (Exception exc){
	            System.out.println("cant connect exp is" +exc.getMessage());
	            exc.printStackTrace();
	        }
	        System.out.println("Ending url connection");
	       
	        
	}

}
