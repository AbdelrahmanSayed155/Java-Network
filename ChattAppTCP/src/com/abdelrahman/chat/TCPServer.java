package com.abdelrahman.chat;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TCPServer {

	public static void main(String[] args) throws Exception {
		ServerSocket serverSocket = null ;
		int port =7070;
		try{
			serverSocket = new ServerSocket(port);
		}catch (Exception e) {
			System.exit(1);
		}
		
		while(true){
			Socket reciver =  serverSocket.accept();
		    Scanner scanner = new Scanner(reciver.getInputStream());
		    PrintWriter printWriter = new PrintWriter( reciver.getOutputStream(),true);
		    int numofMessage = 0;
		    String inputMessage ;
		    while(!(inputMessage = scanner.nextLine()).equalsIgnoreCase("Close")){
		    	System.out.println("recieve message ");
		    	numofMessage++;
		    	System.out.println("Message"+numofMessage+":"+inputMessage);
		    }
		    scanner.close();
		    reciver.close();
		    printWriter.close();
		}
		
	}

}
