package com.abdelrahman.ServerSide;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;


/// udp is good in transfer movies , sound 
/// tcp is good in transfer text 
public class UDPServer {
	public static void main(String[] args) throws Exception{
		DatagramSocket server;
		int port=4444;
		DatagramPacket inPacket, outPacket;
		byte [] buffer;
		server = new DatagramSocket(port);
		String message;
		String outMessage;
		int messageNum = 0;
		do{
			buffer = new byte[256];
			inPacket = new DatagramPacket(buffer, buffer.length);
			server.receive(inPacket);
			InetAddress  clentAddress = inPacket.getAddress();
			int clientPort = inPacket.getPort();
			message = new String(inPacket.getData(), 0, inPacket.getLength());
			messageNum++;
			outMessage = " your message recieved "+ message;
			outPacket = new DatagramPacket(outMessage.getBytes(), outMessage.length(), clentAddress,clientPort);
			server.send(outPacket);
		}while(!message.equalsIgnoreCase("close"));
		
		server.close();
	}

}
