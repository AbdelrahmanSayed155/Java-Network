package com.abdelrahman.PortScanner;

import java.net.Socket;

public class MainClass {
	
	public static void main(String []args){
		
		String address =  "localhost";
		Socket socket;
		for(int portNumber=1;portNumber<=65535;portNumber++){
			try{
				socket =  new Socket(address,portNumber);
				System.out.println("Socket opened in port " + portNumber);
			}catch (Exception e) {
				System.out.println("Excption in opening port in" + portNumber);
			}
		}
	}

}
