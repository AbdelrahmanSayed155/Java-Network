package com.abdelrahman.networkInterface;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Collections;
import java.util.Enumeration;

public class NetworkInterfaceMainClass {

	public static void main(String[] args) throws SocketException {
		
		/// all interface which provide you with internet
        Enumeration interfaces = NetworkInterface.getNetworkInterfaces();
        while(interfaces.hasMoreElements()){
        	NetworkInterface networkInterface = (NetworkInterface) interfaces.nextElement();
        	System.out.println(networkInterface);
        	System.out.println("network name"+networkInterface.getName());
        	System.out.println(" GUI name is "+networkInterface.getDisplayName());
        	System.out.println("MTU:"+networkInterface.getMTU());
        	System.out.println("io:"+networkInterface.isLoopback());
        	System.out.println("active:"+networkInterface.isUp());
        	System.out.println(" it is Sub");
        	/// for get subinterfaces
        	Enumeration<NetworkInterface> subnetwork = networkInterface.getSubInterfaces();
        	for(NetworkInterface networkInterface2:Collections.list(subnetwork)){
        		System.out.println("sub displayName"+networkInterface2.getDisplayName());
        		System.out.println("sub NetworkName"+networkInterface2.getDisplayName());
        	}
        	//// for getting ips of intefces 
        	System.out.println(" it is ips");
        	Enumeration<InetAddress> ips =  networkInterface.getInetAddresses();
        	for(InetAddress inetAddress:Collections.list(ips)){
        		System.out.println("innetAdrress{" +inetAddress+"}" );
        	}
        	System.out.println("--------------------");
        	
        }

	}

}
