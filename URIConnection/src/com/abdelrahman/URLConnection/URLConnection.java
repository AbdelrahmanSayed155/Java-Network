package com.abdelrahman.URLConnection;

import java.net.MalformedURLException;
import java.net.URL;

public class URLConnection {

	public static void main(String[] args) throws Exception {
		URL url = new URL("https://www.opensuse.org/");
		Connecting.connect(url);
	}

}
