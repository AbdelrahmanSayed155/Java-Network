package com.abdelrahman.networkInterface2;

import java.net.InetAddress;
import java.net.NetworkInterface;

public class GettingMacAddrress {

	public static void main(String[] args) throws Exception {
		InetAddress address = InetAddress.getLocalHost();
		NetworkInterface networkInterface =  NetworkInterface.getByInetAddress(address);
		
		byte [] Mac = networkInterface.getHardwareAddress();
		for(int i=0;i<Mac.length;i++){
			System.out.format("%02X%s", Mac[i],(i<Mac.length-1)?"-":"");
		}

	}

}
