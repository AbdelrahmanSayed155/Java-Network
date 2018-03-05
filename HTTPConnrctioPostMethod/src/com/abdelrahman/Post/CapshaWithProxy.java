/**
 * 
 */
package com.abdelrahman.Post;

/**
 * @author Abdelrahman Sayed
 *
 * Mar 5, 2018
 */
public class CapshaWithProxy {

	/*
	 *public static CapcheDTO validateCaptcha(String token) {
        CapcheDTO capcheDTO=new CapcheDTO();
        try {
            System.out.println("using Proxy");
            Map<String, String> env = System.getenv();
            String proxyString = env.get("https_proxy");
            System.out.println("Proxy is :"+proxyString);
            String [] hostAndPort = proxyString.split(":");

            // Proxy proxy  =  new Proxy(Proxy.Type.HTTP, new InetSocketAddress("proxy.preprod.openshift.vodafone.com.eg", 3128));
            Proxy proxy  = null;
            if(proxyString.startsWith("http"))
            {
                  proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress( hostAndPort[1].substring(2,hostAndPort[1].length()), Integer.parseInt(hostAndPort[2])));
            }else{
                 proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(hostAndPort[0], Integer.parseInt(hostAndPort[1])));
            }
            env = System.getenv();
            String secretPassword = env.get("GOOGLE_CAPTCHA_SECRET");
            ObjectMapper mapper = new ObjectMapper().enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
            String urlParameters  = "secret="+ secretPassword+"&response="+token;
            byte[] postData       = urlParameters.getBytes( StandardCharsets.UTF_8 );
            String request        = "https://www.google.com/recaptcha/api/siteverify";
            URL    url            = new URL( request );
            HttpURLConnection conn= (HttpURLConnection) url.openConnection(proxy);
            conn.setDoOutput( true );
            conn.setRequestMethod( "POST" );
            conn.setRequestProperty( "Content-Type", "application/x-www-form-urlencoded");
            try( DataOutputStream wr = new DataOutputStream( conn.getOutputStream())) {
                wr.write( postData );
            }
            BufferedReader br = null;
            StringBuilder  sb= null;
            String localoutput;
            if ((conn.getResponseCode()+"").startsWith("2")){
                br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
                sb = new StringBuilder();
                while ((localoutput = br.readLine()) != null) {
                    sb.append(localoutput);
                }
                System.out.println(" success Respose " + sb.toString());
            }else{
                br = new BufferedReader(new InputStreamReader((conn.getErrorStream())));
                sb = new StringBuilder();
                while ((localoutput = br.readLine()) != null) {
                    sb.append(localoutput);
                }
                System.out.println("error Respose " + sb.toString());
            }
            System.out.println("Output from Server .... \n");
            String output = sb.toString();
            logger.info("----+++google cachpa response"+output);
            capcheDTO = mapper.readValue(output, CapcheDTO.class);
        } catch (Exception e) {
            logger.error("Exception in validateCaptcha :");
            e.printStackTrace();
            capcheDTO=null;
        }
        return capcheDTO;
    } 
	 * 
	 * */
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
