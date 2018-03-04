
package com.abdelrahman.capcha;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

/**
 * @author Abdelrahman Sayed
 *
 * Mar 1, 2018
 */
public class capchaClient {

	public static String validateCaptcha(String token) {
		 String output =null;
       try {
           
       	 String sectretPassword = "6LcaGSsUAAAAAMidi1Ud4V4w8t-7i1BBN_dQ8aBZ";
           Client client = Client.create();
           System.out.println("creating client succefully ");
           WebResource webResource = client.resource("https://www.google.com/recaptcha/api/siteverify");
           String input = "secret="+ sectretPassword+"&response="+token;
           System.out.println(" befor access google  ");
           ClientResponse response = webResource.type("application/x-www-form-urlencoded").post(ClientResponse.class, input);
           System.out.println(" after access google  ");
           System.out.println("Output from Server .... \n");
            output = response.getEntity(String.class);
            System.out.println("response:" + output);
       } catch (Exception e) {
          // logger.error("Exception in validateCaptcha :");
           e.printStackTrace();
          // capcheDTO=null;
       }
   return output;
   }

	public static void main(String[] args) {
		String token = "03ANcjospMRJn8YwZEO0ZOGWKplsjwvwL5KIemxpTPNIk62e7wedjwa4-aDE_WJX0trCsOz_kSC0ATfLLR0ON0U2zXSf6ImY-Or5VgkfVZOee4WhseInIuSunByZfEWVDxEozA0WqWe7qPISiyukQxadVjXLuyrNs3B8UgR_EgMMonl_CkRaFeJVbQ4l4CAASBBvyb34pzeVayotg-ujq7SHMAqYzr3S08J5hlVZ3thTQl7z9V0aGP4cEbZf71GLEJTtXpmyh670V2geLA3J76q-1qr7YrKoU28efAY0wivn12sJlvxebTAXiUqIgvsZVujyk5zeJhl0XB12X-PjsDOXf_R01IsJ82zOCoGK0QFYwWF5leoT0R1TnLAvbrppazKMZhMuPn-cqX4gBZpqjJ_-WBk772h4D9GsG7bmQUje_4aJ6dXH3puDv6sK4GWCcv_qyKat34o-6yrVhPe8TTVyirsqyGeE6APg";
		 System.out.println(validateCaptcha(token));

	}

}
