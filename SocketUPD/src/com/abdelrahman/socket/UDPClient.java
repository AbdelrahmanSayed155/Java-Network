package com.abdelrahman.socket;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {
	public static void main(String []args) throws Exception {
		
		DatagramSocket datagramSocket = null;
		try{
		 datagramSocket = new DatagramSocket();
		int data = 8;
		byte [] arrayData =  String.valueOf(data).getBytes();
		InetAddress address = InetAddress.getLocalHost();
		System.out.println("Cleint Starting {"+address.toString()+"}");
		DatagramPacket sendDatagramPacket = new DatagramPacket(arrayData, arrayData.length, address,666);
		datagramSocket.send(sendDatagramPacket);
		///// recieve from server 
		byte [] recieveArrayData = new byte[1024];
		DatagramPacket receivedatagramPacket = new DatagramPacket(recieveArrayData,recieveArrayData.length);
		datagramSocket.receive(receivedatagramPacket);
		String reciveMessage = new String(receivedatagramPacket.getData());
		System.out.println("Message recieve from Server " + reciveMessage.trim());
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
