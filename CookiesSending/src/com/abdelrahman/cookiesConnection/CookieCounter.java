package com.abdelrahman.cookiesConnection;

import java.net.URL;
import java.net.URLConnection;

public class CookieCounter {

	public static void main(String[] args) throws Exception {
		URL  url = new URL("http://www.googlr.com");
		URLConnection connection = url.openConnection();
		for(int y=0;;y++){
			String headerFieldKey = connection.getHeaderFieldKey(y);
			String headerField =  connection.getHeaderField(y);
			if(headerField==null&&headerFieldKey==null){
				break;
			}
			if(headerFieldKey.equalsIgnoreCase("Set-Cookie")){
				String []feilds = headerField.split(";\\s");
				////////// and it can carry sub element so spli again 
			}
		}
		

	}

}
