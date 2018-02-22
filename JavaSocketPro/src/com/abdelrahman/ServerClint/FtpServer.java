package com.abdelrahman.ServerClint;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class FtpServer {

	public static void main(String[] args) throws Exception {
		//// Server Scoket 
		ServerSocket serverSocket = null;
		serverSocket = new ServerSocket(5555);
		//// Recever Socket 
		Socket recivSocket = serverSocket.accept();
		/// reading from user 
		InputStream  inputStream = null;
		OutputStream outputStream = null;
		inputStream =  recivSocket.getInputStream();
		File file = new File("transfer.txt");
		outputStream = new FileOutputStream(file);
		
		byte [] data = new byte[20*1024];
		
		
		int readNumber;
		while((readNumber = inputStream.read(data))>0){
			outputStream.write(data);
		}
		outputStream.close();
		inputStream.close();
		recivSocket.close();
		serverSocket.close();
		
	}

}
