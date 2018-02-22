package com.abdelrahman.netWorkScanner;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class NetworkScanner {
	
	public static void checkHosts(String subnet){
		   int timeout=1000;
		   for (int i=1;i<255;i++){
		       String host=subnet + "." + i;
		       try {
				if (InetAddress.getByName(host).isReachable(timeout)){
				       System.out.println(host + " is reachable");
				   }
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   }
		}
	
	public static void main(String[]args){
		checkHosts("192.168.0");
	}

}
