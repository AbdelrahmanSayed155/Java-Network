package com.abdelrahman.javanetwork;

import java.net.URL;

public class TestingProtocol {

	public static void testprotocle(String urlString){
		URL url = null;
		try{
		 url = new URL(urlString);
		 System.out.println("Supported Protocl:"+url.getProtocol());
		}catch (Exception e) {
			System.out.println("this protocl in String unsupported " + urlString);
		}
	}
	public static void main(String[] args) {
		testprotocle("https://www.googleadservices.com/pagead/aclk?sa=L&ai=DChcSEwiesJPfmLnZAhVFOBsKHVuFAO4YABAAGgJ3bA&ohost=www.google.com&cid=CAESEeD2DbQ4B1oJE1avHD1WH9Ew&sig=AOD64_2-S7Yu4v3g5GjcV395zC4E28P73Q&q=&ved=0ahUKEwjJl47fmLnZAhUKuBQKHfy7Bk4Q0QwIJA&adurl=");
		testprotocle("file://www.googleadservices.com/pagead/aclk?sa=L&ai=DChcSEwiesJPfmLnZAhVFOBsKHVuFAO4YABAAGgJ3bA&ohost=www.google.com&cid=CAESEeD2DbQ4B1oJE1avHD1WH9Ew&sig=AOD64_2-S7Yu4v3g5GjcV395zC4E28P73Q&q=&ved=0ahUKEwjJl47fmLnZAhUKuBQKHfy7Bk4Q0QwIJA&adurl=");
		testprotocle("mailto://www.googleadservices.com/pagead/aclk?sa=L&ai=DChcSEwiesJPfmLnZAhVFOBsKHVuFAO4YABAAGgJ3bA&ohost=www.google.com&cid=CAESEeD2DbQ4B1oJE1avHD1WH9Ew&sig=AOD64_2-S7Yu4v3g5GjcV395zC4E28P73Q&q=&ved=0ahUKEwjJl47fmLnZAhUKuBQKHfy7Bk4Q0QwIJA&adurl=");
		testprotocle("http://www.googleadservices.com/pagead/aclk?sa=L&ai=DChcSEwiesJPfmLnZAhVFOBsKHVuFAO4YABAAGgJ3bA&ohost=www.google.com&cid=CAESEeD2DbQ4B1oJE1avHD1WH9Ew&sig=AOD64_2-S7Yu4v3g5GjcV395zC4E28P73Q&q=&ved=0ahUKEwjJl47fmLnZAhUKuBQKHfy7Bk4Q0QwIJA&adurl=");

	}

}
