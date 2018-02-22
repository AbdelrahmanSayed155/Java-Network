package com.abdelrahman.headerInfo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class ReadingContentOFPAge {
	
	public static void main(String []args) throws Exception{
		
		URL  url = new URL("https://www.microsoft.com/ar-eg");
		URLConnection urlConnection = url.openConnection();
		BufferedReader bufferedReader = new  BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
		String readline= bufferedReader.readLine();
		while(readline!=null){
			System.out.println(readline);
		  readline= bufferedReader.readLine();
		}
		
	}

}
