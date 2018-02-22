package org.soap.abdelrahman;

import java.rmi.RemoteException;

import net.webservicex.www.GeoIP;
import net.webservicex.www.GeoIPServiceSoapProxy;

public class IplocatorFinder {

	public static void main(String[] args) {
/////  82.129.130.245
		///74.125.239.142
//		if(args.length<1){
//			System.out.println("You must pass only one IP");
//		}else{
			String ipAddress = "74.125.239.142";//"82.129.130.245";//args[0];
			GeoIPServiceSoapProxy geoProxy = new GeoIPServiceSoapProxy() ;
			try {
				GeoIP ip = geoProxy.getGeoIP(ipAddress);
				System.out.println("Country Name:" + ip.getCountryName()+"/n Country Code:"+ip.getCountryCode());
			} catch (RemoteException e) {
				e.printStackTrace();
				System.out.println("Exception is "+e.getMessage());
			}
		//}
	}

}
