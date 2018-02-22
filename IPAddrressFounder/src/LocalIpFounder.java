import java.net.InetAddress;

public class LocalIpFounder {

	public static void main(String[] args) throws Exception {
		InetAddress address = InetAddress.getLocalHost();
		System.out.println("local address:"+address.toString());

	}

}
