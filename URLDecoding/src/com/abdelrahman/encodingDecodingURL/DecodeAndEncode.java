package com.abdelrahman.encodingDecodingURL;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class DecodeAndEncode {
	
	public static void main( String [] args) throws Exception{
		//// convert encoding of url
		/// %20 mean space 
	String  urlAfterDecode = new String("https://www.google.com/search?biw=1366&bih=662&tbm=isch&sa=1&ei=V4aKWvLcD5DMwQLVnpjICQ&q=tree+ds&oq=tree+ds&gs_l=psy-ab.3..0i19k1l7j0i8i30i19k1l2.177178.178339.0.179409.3.3.0.0.0.0.218.507.0j2j1.3.0....0...1c.1.64.psy-ab..0.3.504...0j0i67k1.0.xLgp5cZ4FZs");
	String urldecoding = URLDecoder.decode(urlAfterDecode,"UTF-8");
	System.out.println(urlAfterDecode);
	System.out.println(urldecoding);
	System.out.println("------------");
	String urlbeforEncoding ="https://www.google.com/search?biw=1366&bih=662&tbm=isch";
	String urlAfterncoding = URLEncoder.encode(urlbeforEncoding,"UTF-8");
	System.out.println(urlbeforEncoding);
	System.out.println(urlAfterncoding);
	
	}
}
