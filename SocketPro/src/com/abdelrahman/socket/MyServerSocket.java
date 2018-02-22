package com.abdelrahman.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class MyServerSocket {

	public static void main(String[] args)throws UnknownHostException,IOException {
		System.out.println("Starting Server  Side ");
		ServerSocket serverSocket =  new ServerSocket(4444);////0-1023 to 65535
		System.out.println("Server Waiting Client to connect");
		Socket serverclient=serverSocket.accept();
		System.out.println("Client Connected");
		
		InputStreamReader inReader =  new InputStreamReader(serverclient.getInputStream());
		BufferedReader bReader =  new BufferedReader(inReader);
		String message =  bReader.readLine();
		System.out.println("Client Send {"+message+"}");
		
       //////// server sent to client 
		OutputStreamWriter outWriter = new OutputStreamWriter(serverclient.getOutputStream());
		///you need printwriter to write into output stream 
		PrintWriter pw = new PrintWriter(outWriter);
		//pw.write(message);
		pw.println("Hello{"+message+"}");
		pw.flush();
				

	}

}
