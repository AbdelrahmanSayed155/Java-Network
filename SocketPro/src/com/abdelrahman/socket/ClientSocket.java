package com.abdelrahman.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
////  server Socket for TCP
/*
 DatagramSocket is designed for UDP and ServerSocket for TCP. TCP is more reliable in terms that it ensures delivery, UDP not. But UDP packets are much smaller and have no such big headers like TCP packets have.

If it is smaller then there is more probability that it arrives faster. UDP used mostly in areas where you do no mind about retransmission. You just do not need this, because information become obsolete. Sound, for example.

It is better to make small pause or repeat last packet than to play some piece that was send first but received second.

It is up to you to take decision. If you do not mind that can lose small piece of data - use UDP. Otherwise use TCP
 * */
public class ClientSocket {
	
	public static void main(String []args) throws UnknownHostException,IOException {
		System.out.println("Starting Client Side ");
		String ip="localhost";
		int port=4444;
		Socket s = null;
	
			 s = new Socket(ip,port) ;
		
		String message = "Abdelrahman Sayed";
		/// every socket have output stream and input stream 
		OutputStreamWriter outWriter = new OutputStreamWriter(s.getOutputStream());
		///you need printwriter to write into output stream 
		PrintWriter pw = new PrintWriter(outWriter);
		//pw.write(message);
		pw.println(message);
		pw.flush();
		//// recieve message from server
		InputStreamReader inReader =  new InputStreamReader(s.getInputStream());
		BufferedReader bReader =  new BufferedReader(inReader);
		String message2 =  bReader.readLine();
		System.out.println("Server Send {"+message2+"}");
	}
}
