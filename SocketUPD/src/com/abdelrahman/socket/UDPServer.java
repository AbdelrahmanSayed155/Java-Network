package com.abdelrahman.socket;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServer {

     public static void main(String []ar) throws Exception {
    	 DatagramSocket datagramSocket = null;
		try{
    	  datagramSocket = new DatagramSocket(666);
    	 
    	 /// recieve message from client 
    	 byte [] recieveArrayData = new byte[1024];
 		 DatagramPacket receivedatagramPacket = new DatagramPacket(recieveArrayData,recieveArrayData.length);
 		 System.out.println("Server starting .......");
 		datagramSocket.receive(receivedatagramPacket);
 		String reciveMessage = new String(receivedatagramPacket.getData());
 		
 		int num =  Integer.parseInt(reciveMessage.trim());
 		num = num*10;
 		
 		
 		byte [] sentArrayData =  (num+"").getBytes();
		InetAddress address = InetAddress.getLocalHost();
		DatagramPacket sendDatagramPacket = new DatagramPacket(sentArrayData, sentArrayData.length, address,receivedatagramPacket.getPort());
		datagramSocket.send(sendDatagramPacket);
		}catch (Exception e) {
			if(!datagramSocket.isClosed()){
				datagramSocket.close();
			}
		}
		
		if(!datagramSocket.isClosed()){
			datagramSocket.close();
		}
	  }
}
