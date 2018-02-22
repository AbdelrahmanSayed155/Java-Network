package com.abdelrahman.lowport;

import java.net.Socket;

public class PortScanner {
	
	
	public static void main(String [] args){
	
		String host =  "localhost";
		for(int port = 1;port<65536;port++){
			try{
			Socket socket = new Socket(host, port);
			System.out.println("Server in port:"+port);
			}catch(Exception ex){
				System.out.println("not Server in port:"+port);
			}
		}
	}

}
