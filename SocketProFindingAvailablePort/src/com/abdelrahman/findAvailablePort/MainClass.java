package com.abdelrahman.findAvailablePort;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MainClass {
	
	public static ServerSocket create(int[] ports) throws IOException {
	    for (int port : ports) {
	        try {
	            return new ServerSocket(port);
	        } catch (IOException ex) {
	            continue; // try next port
	        }
	    }
	    throw new IOException("no free port found");
	}
	

	public static void main(String[] args) {
		try {
		    ServerSocket s = create(new int[] { 3843, 4584, 4843 });
		    System.out.println("listening on port: " + s.getLocalPort());
		} catch (IOException ex) {
		    System.err.println("no available ports");
		}

	}

}
