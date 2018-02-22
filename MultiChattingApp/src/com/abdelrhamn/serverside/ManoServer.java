package com.abdelrhamn.serverside;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ManoServer {

	public static void main(String[] args) throws Exception {
		ServerSocket server;
		int port = 1234;
		server = new ServerSocket(port);
		do{
		Socket client = server.accept();
		ClientHand clientHand = new ClientHand(client);
		clientHand.start();
		}while(true);
	}

}

 class ClientHand extends Thread{
	private Socket client;
	private Scanner input;
	private PrintWriter writer;
	
	public ClientHand(Socket client) throws Exception{
		this.client = client;
		input = new Scanner(client.getInputStream());
		writer = new PrintWriter(client.getOutputStream());
	}
	
	public void run(){
		String recived;
		do{
			recived = input.nextLine();
			System.out.println("Client:"+recived);
			
		}while(!recived.equalsIgnoreCase("exit"));
		
		if (client!=null){
			try {
				client.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
