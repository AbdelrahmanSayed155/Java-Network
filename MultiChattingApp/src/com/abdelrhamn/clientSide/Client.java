package com.abdelrhamn.clientSide;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) throws Exception {
		InetAddress localhost =  InetAddress.getLocalHost();
		int port = 1234;
		Socket client = new Socket(localhost, port);
        Scanner scanner = new Scanner(client.getInputStream());
        PrintWriter writer  = new PrintWriter(client.getOutputStream());
        Scanner entryScanner = new Scanner(System.in);
        String message,response;
        do{
        	System.out.print("enterYor message ");
        	message = entryScanner.nextLine();
        	writer.println(message);
        	response =  scanner.nextLine();
        	System.out.println("Server"+response);
        }while(!message.equalsIgnoreCase("close"));
        
        client.close();
	}

}
