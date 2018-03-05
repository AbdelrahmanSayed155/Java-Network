/**
 * 
 */
package com.abdelrahman.Post;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/**
 * @author Abdelrahman Sayed
 *
 * Mar 4, 2018
 */
public class MainClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

 try{
		String token = "03ANcjospMRJn8YwZEO0ZOGWKplsjwvwL5KIemxpTPNIk62e7wedjwa4-aDE_WJX0trCsOz_kSC0ATfLLR0ON0U2zXSf6ImY-Or5VgkfVZOee4WhseInIuSunByZfEWVDxEozA0WqWe7qPISiyukQxadVjXLuyrNs3B8UgR_EgMMonl_CkRaFeJVbQ4l4CAASBBvyb34pzeVayotg-ujq7SHMAqYzr3S08J5hlVZ3thTQl7z9V0aGP4cEbZf71GLEJTtXpmyh670V2geLA3J76q-1qr7YrKoU28efAY0wivn12sJlvxebTAXiUqIgvsZVujyk5zeJhl0XB12X-PjsDOXf_R01IsJ82zOCoGK0QFYwWF5leoT0R1TnLAvbrppazKMZhMuPn-cqX4gBZpqjJ_-WBk772h4D9GsG7bmQUje_4aJ6dXH3puDv6sK4GWCcv_qyKat34o-6yrVhPe8TTVyirsqyGeE6APg";		String sectretPassword = "6LcaGSsUAAAAAMidi1Ud4V4w8t-7i1BBN_dQ8aBZ";
		String urlParameters  = "secret="+ sectretPassword+"&response="+token;
		byte[] postData       = urlParameters.getBytes( StandardCharsets.UTF_8 );
		String request        = "https://www.google.com/recaptcha/api/siteverify";
		URL    url            = new URL( request );
		HttpURLConnection conn= (HttpURLConnection) url.openConnection();           
		conn.setDoOutput( true );
		
		conn.setRequestMethod( "POST" );
		conn.setRequestProperty( "Content-Type", "application/x-www-form-urlencoded"); 
		try( DataOutputStream wr = new DataOutputStream( conn.getOutputStream())) {
			   wr.write( postData );
			}
		
		
		BufferedReader br = null;
		StringBuilder  sb= null;
        if ((conn.getResponseCode()+"").startsWith("2")){
         br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
          sb = new StringBuilder();
        String output;
        while ((output = br.readLine()) != null) {
        sb.append(output);
        }
        System.out.println(" success Respose " + sb.toString());
        }else{
        	  br = new BufferedReader(new InputStreamReader((conn.getErrorStream())));
	              sb = new StringBuilder();
	            String output;
	            while ((output = br.readLine()) != null) {
	            sb.append(output);
	            }
	           System.out.println("error Respose " + sb.toString());
        }
        
 }catch (Exception e) {
	e.printStackTrace();
}
		
	}

}





//System.out.println("Starting url connection");
//
//  URL url = new URL("https://www.google.com/recaptcha/api/siteverify");//new URL("https://www.opensuse.org");\
//  HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection(proxy);
//  httpsURLConnection.setConnectTimeout(5000);
//  System.out.println("using Proxy is:" +httpsURLConnection.usingProxy());
//  System.out.println("response Code is" +httpsURLConnection.getResponseCode());
//  System.out.println("response message is" +httpsURLConnection.getResponseMessage());
//  System.out.println("Content message is" +httpsURLConnection.getContent());
//
//  if ((httpsURLConnection.getResponseCode()+"").startsWith("2")){
//      BufferedReader br = new BufferedReader(new InputStreamReader((httpsURLConnection.getInputStream())));
//      StringBuilder  sb = new StringBuilder();
//      String output;
//      while ((output = br.readLine()) != null) {
//          sb.append(output);
//      }
//      System.out.println(" success Respose " + sb.toString());
//  }else{
//      BufferedReader br = new BufferedReader(new InputStreamReader((httpsURLConnection.getErrorStream())));
//      StringBuilder  sb = new StringBuilder();
//      String output;
//      while ((output = br.readLine()) != null) {
//          sb.append(output);
//      }
//      System.out.println("error Respose " + sb.toString());
//  }
//
//
//}catch (Exception exc){
//  System.out.println("cant connect exp is" +exc.getMessage());
//  exc.printStackTrace();
//}
//System.out.println("Ending url connection");
//


//System.out.println(" new Start ping -----");
//String ip = "https://www.google.com/recaptcha/api/siteverify";
//runSystemCommand("curl -v  " + ip);
//System.out.println("End ping -----");


//    try {