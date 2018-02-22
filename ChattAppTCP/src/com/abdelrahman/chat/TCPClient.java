package com.abdelrahman.chat;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class TCPClient {

	public static void main(String[] args) throws Exception {
		Socket socket = new Socket("localhost", 7070);
		
		Scanner scanner = new Scanner(socket.getInputStream());
	    PrintWriter printWriter = new PrintWriter( socket.getOutputStream(),true);
	    Scanner  scanner2 =  new Scanner(System.in);
	    String message , response;
	    while(true){
	    	message = scanner2.nextLine();
	    	response = scanner.nextLine();
	    	if(! message.equalsIgnoreCase("close")){
	    		break;
	    	}
	    }
	    scanner2.close();
	    printWriter.close();
	    scanner.close();
	    socket.close();
	}

}
