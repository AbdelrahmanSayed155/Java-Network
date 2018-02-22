package com.abdelrahman.URLConnection;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

public class Connecting {
	
	public static void connect(URL url) throws IOException{
		
		java.net.URLConnection connection  = url.openConnection();
		connection.connect();
		System.out.println("ContentType :"+connection.getContentType());
		System.out.println("Encoding :"+connection.getContentEncoding());
		System.out.println("Date :"+new Date(connection.getDate()));
		System.out.println("ConnectTimeout :"+connection.getConnectTimeout());
		
		if(connection instanceof HttpURLConnection){
			HttpURLConnection connection2 = (HttpURLConnection) connection;
			System.out.println("Connection is http connection");
			System.out.println("ResponseCode:"+connection2.getResponseCode());
			System.out.println("ResponseMessage:"+connection2.getResponseMessage());
			System.out.println("ContentLength:"+connection2.getContentLength());
			System.out.println("Date:"+ new Date(connection2.getDate()));
			System.out.println("RequestMethod:"+ connection2.getRequestMethod());
		}

		
	}

}
