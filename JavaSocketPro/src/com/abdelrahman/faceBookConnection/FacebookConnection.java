package com.abdelrahman.faceBookConnection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class FacebookConnection {

	public static void main(String[] args) throws Exception, IOException {
		String host = "www.facebook.com";
		String protocol = "https";
		int port =70;
		Socket socket = new Socket(protocol +"://"+host, port);
        boolean autoFlush = true;
        OutputStream os = socket.getOutputStream();
        PrintWriter writer = new PrintWriter(os, autoFlush);
        writer.println("GET/HTTP/1.1");
        writer.println("Host:"+host+":"+port);
        writer.println("Connection:Close");
        writer.println("");
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        boolean loop=true;
        StringBuilder builder =  new StringBuilder(8192);
        while(loop){
        	
        	if(reader.ready()){
        		int i;
        		while((i=reader.read())!=-1){
        			builder.append((char) i);
        		}
        	}
        	loop = false;
        }
        System.out.println(builder.toString());
        socket.close();
        os.close();
	}

}
