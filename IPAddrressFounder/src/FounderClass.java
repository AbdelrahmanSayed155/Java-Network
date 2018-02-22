import java.net.InetAddress;
import java.net.UnknownHostException;

public class FounderClass {
	
	public static void main(String []args) throws Exception{
	
		String host = "www.facebook.com";
		InetAddress address = InetAddress.getByName(host);
		
		System.out.println(" ip address"+address.toString());
	}

}
