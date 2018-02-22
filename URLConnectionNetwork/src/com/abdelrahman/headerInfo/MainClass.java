package com.abdelrahman.headerInfo;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class MainClass {

	public static void main(String[] args) throws IOException {
        URL url = new URL("https://www.microsoft.com/ar-ly");
        URLConnection connection = url.openConnection();
        
        for(int index=0;;index++){
        	String headerString = connection.getHeaderField(index);
        	if(headerString == null){
        		break;
        	}
        	System.out.println(headerString);
        }
		 
	}

}
