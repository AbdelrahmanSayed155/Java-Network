import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.net.ssl.HttpsURLConnection;

public class HttpConMainClass {

	public static void main(String[] args) throws IOException {
		URL url = new URL("https://www.w3.org/Protocols/HTTP/HTRESP.html");//new URL("https://www.opensuse.org");
		HttpsURLConnection httpsURLConnection = (HttpsURLConnection)url.openConnection();
        long date =  httpsURLConnection.getDate();
        long expireDate = httpsURLConnection.getExpiration();
        long  modifiedDate = httpsURLConnection.getLastModified();
        String contentType=  httpsURLConnection.getContentType();
        int contentLenght=  httpsURLConnection.getContentLength();
        String  requstMethod=  httpsURLConnection.getRequestMethod();
        int responseCode = httpsURLConnection.getResponseCode();
        String  responseMessage = httpsURLConnection.getResponseMessage();
        System.out.println(" date:"+new Date(date));
        System.out.println(" expire date:"+new Date(expireDate));
        System.out.println(" last modify date:"+new Date(modifiedDate));
        System.out.println("Content Type :"+contentType);
        System.out.println("content Lenght :"+contentLenght);
        System.out.println("requstMethod :"+requstMethod);
        System.out.println("responseCode :"+responseCode);
        System.out.println("responseMessage :"+responseMessage);
        
        
        /// get header Data 
        
        Map<String, List<String>> header = httpsURLConnection.getHeaderFields();
        Set<String> headerKey =  header.keySet();
        for(String key:headerKey){
        	System.out.println("key is{"+key+"} , has data {"+header.get(key)+"} \n");
        }
        
        
	}

}
