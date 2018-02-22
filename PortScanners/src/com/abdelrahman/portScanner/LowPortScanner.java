package com.abdelrahman.portScanner;

import java.net.Socket;

public class LowPortScanner {

	public static void main(String[] args) {
		
		/// this check port hav service 
		
		for(int port=0;port<65536;port++){
			try{
				Socket socket =  new Socket("localhost", port);
				System.out.println("port have server:"+port);
			}catch (Exception e) {
				System.out.println("port have't server:"+port);
			}
			
		}

	}

}
