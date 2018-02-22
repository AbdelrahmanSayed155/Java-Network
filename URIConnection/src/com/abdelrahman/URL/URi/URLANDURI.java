package com.abdelrahman.URL.URi;

import java.net.URI;
import java.net.URL;

public class URLANDURI {

	public static void main(String[] args) throws Exception {
		URL url = null;
		URI uri = null;
		uri =  new URI("test.txt");
		url = uri.toURL();
	}

}
