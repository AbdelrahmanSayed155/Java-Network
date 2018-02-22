package com.abdelrahman.uriconnection;

import java.net.URI;

public class URIINFO {

	public static void main(String[] args) throws Exception {
		URI uri =  new URI("https://stackoverflow.com");
		
		System.out.println(""+uri.getHost());
		System.out.println(""+uri.getPort());
		System.out.println(""+uri.getAuthority());
		System.out.println(""+uri.getRawSchemeSpecificPart());
		System.out.println(""+uri.getPath());
		System.out.println(""+uri.getQuery());
		System.out.println(""+uri.getRawFragment());

	}

}
