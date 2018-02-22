package com.abdelrahman.full;

import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

public class FullExample {

	
	
	public static void netParameter(NetworkInterface interface1) throws SocketException{
		System.out.println("Naeme"+interface1.getName());
		System.out.println("GUI name"+interface1.getDisplayName());
		System.out.println(" byte mac address:"+interface1.getHardwareAddress());
		
		List<InterfaceAddress> interfaceAddresses =  interface1.getInterfaceAddresses();
		Iterator<InterfaceAddress> iterator = interfaceAddresses.iterator();
		while(iterator.hasNext()){
			InterfaceAddress interfaceAddress =(InterfaceAddress)iterator.next();
			System.out.println("address"+interfaceAddress.getAddress());
			System.out.println("NetworkPrefixLength"+interfaceAddress.getNetworkPrefixLength());
			System.out.println("Broadcast"+interfaceAddress.getBroadcast());
		}

	}
	
	public static void main(String[] args) throws Exception {
         Enumeration<NetworkInterface> enumeration = NetworkInterface.getNetworkInterfaces();
         while(enumeration.hasMoreElements()){
        	 NetworkInterface interface1 = enumeration.nextElement();
        	 netParameter(interface1);
         }

	}

}
