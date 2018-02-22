package com.abdelrahman.headerInfo;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.net.URLConnection;

public class UsingIOPackage {

	public static void main(String[] args) throws Exception {
	
		URL url = new URL("https://www.microsoft.com/ar-eg");
		URLConnection connection =  url.openConnection();
		InputStream inputStream = connection.getInputStream();
		InputStream inputStream2 = new  BufferedInputStream(inputStream);
		Reader reader =  new InputStreamReader(inputStream2);
		
		int i;
		while((i = reader.read())!=-1){
			System.out.print((char)i);
		}

	}

}
