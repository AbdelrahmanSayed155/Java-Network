package com.abdelrahman.ClientSide;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UDPClient {

	public static void main(String[] args) throws Exception {
		InetAddress inetAddress = InetAddress.getLocalHost();
		DatagramSocket client;
		int port=4444;
		DatagramPacket inPacket, outPacket;
		byte [] buffer;
		client = new DatagramSocket();
		
		Scanner entryData = new Scanner(System.in);
		String message ="" , response="";
		do{
			System.out.println("enter your message :");
			message = entryData.nextLine();
			outPacket = new DatagramPacket(message.getBytes(), message.length(), inetAddress, port);
			client.send(outPacket);
			
			buffer = new byte[256];
			inPacket = new DatagramPacket(buffer, buffer.length);
			client.receive(inPacket);
			response = new String(inPacket.getData(), 0, inPacket.getLength());
			System.out.println("server:"+response);
		}while(!message.equalsIgnoreCase("close"));
			
		client.close();
		

	}

}
