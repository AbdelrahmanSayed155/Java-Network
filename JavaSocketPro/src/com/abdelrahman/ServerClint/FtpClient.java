package com.abdelrahman.ServerClint;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class FtpClient {

	public static void main(String[] args) throws Exception, IOException {
     Socket socket = new Socket("localhost", 5555);

     File clintFile = new File("info.txt");
     long length =  clintFile.length();
     byte [] trnasferData =  new byte [20*1024];
     
     InputStream inputStream = new FileInputStream(clintFile);
     OutputStream outputStream =  socket.getOutputStream();
     
     int i;
     while((i=inputStream.read(trnasferData))>0){
    	 outputStream.write(trnasferData,0,i);
     }
     outputStream.close();
     inputStream.close();
     socket.close();
     
     
	}

}
