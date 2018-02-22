package com.abdelrahman.javanetwork;

import java.io.File;

public class URIMainClass {

	public static void main(String[] args) throws Exception {
		File uriFile =  new File("test.txt");
		System.out.println("URI"+uriFile.toURI().toString());
		System.out.println("URL"+uriFile.toURL().toString());
	}

}
