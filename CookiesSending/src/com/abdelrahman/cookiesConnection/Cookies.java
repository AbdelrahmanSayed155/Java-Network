package com.abdelrahman.cookiesConnection;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Cookies {

	public static void main(String[] args)  {
		
		try{
		URL url = new URL("https://www.opensuse.org");
		URLConnection connection = url.openConnection();
		connection.setRequestProperty("Cookie", "name=abdelrahman; password=123");
		connection.connect();
		}catch (MalformedURLException e) {
			// TODO: handle exception
		}catch (Exception e) {
			// TODO: handle exception
		}

	}

}
