package com.abdelrahman.innetAddress;

import java.net.InetAddress;

public class nnetAddressUsing {

	public static void main(String[] args) throws Exception {
		InetAddress address = InetAddress.getByName("31.13.64.1");
		System.out.println("host Name :"+address.getHostName());
		System.out.println("host Address :"+address.getHostAddress());
		
		InetAddress address2 = InetAddress.getByName("www.yahoo.com");
		System.out.println("host Name :"+address2.getHostName());
		System.out.println("host Address :"+address2.getHostAddress());
		//System.out.println("is Reashable :"+address2.isReachable(1000));
		InetAddress localaddress =  InetAddress.getLocalHost();
		//// if it  can't show ip mean that ther is fire wall
		System.out.println(localaddress.getLocalHost());
		
		/// get ips from google 
		String googlrHost ="www.google.com";
		InetAddress [] googleIPS = InetAddress.getAllByName(googlrHost);
		for(int i=0;i<googleIPS.length;i++){
			System.out.println(googleIPS[i]);
		}
		
		/// compare between to address
		
		InetAddress googleIraq = InetAddress.getByName("www.google.iq") ;
		InetAddress googleus = InetAddress.getByName("www.google.us") ;
		InetAddress googleca = InetAddress.getByName("www.google.ca") ;
		System.out.println(" googleIraq ip "+googleIraq);
		System.out.println("googleus ip"+googleus);
		System.out.println("googleca ip"+googleca);
		

	}

}
