package com.abdelrahman.cookiesConnection;

import java.io.BufferedInputStream;
import java.net.URL;
import java.net.URLConnection;

public class redingDataOFSite {

	public static void main(String[] args) throws Exception {
		URL url = new URL("http://www.google.com");
		URLConnection connection =  url.openConnection();
		BufferedInputStream bufferedInputStream = new BufferedInputStream(connection.getInputStream());
		int b;
		while((b=bufferedInputStream.read())!=-1){
			System.out.print((char) b);
		}

	}

}
