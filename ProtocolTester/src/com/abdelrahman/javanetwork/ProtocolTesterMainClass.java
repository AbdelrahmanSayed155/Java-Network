package com.abdelrahman.javanetwork;

import java.net.MalformedURLException;
import java.net.URL;

public class ProtocolTesterMainClass {

	public static void main(String[] args)    {
		//// this site is https protocol 
		String host ="www.opensuse.org";
		String file="index.html";
		String [] regex= {"http","https","ftb","mailto","telnet","file","idap","jdbc","nfs"};
		for(int index=0;index<regex.length;index++){
			///URL(protocol, host, file) 
			try{
			URL url = new URL(regex[index], host, file) ;
			System.out.println("this Protocol {"+ regex[index]+"}"+" suported by site "+host);
			}catch (MalformedURLException e) {
			System.out.println("this Protocol {"+ regex[index]+"}"+" unsuported by site "+host);
			}
		}	
	}
}
