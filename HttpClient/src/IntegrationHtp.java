
public class IntegrationHtp {

	
	public O2groupAcountDetailsRepresentation inquireBill(String accountNumber, String globalTrxId) {
		
		String result = null;

		CloseableHttpClient httpclient = HttpClients.createDefault();
		httpPost httpPost = new HttpPost(inquiryUrl);

		List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();

		String md5Value = Md5GeneratorUtil.applyMd5("check" + accountNumber, securitykey, globalTrxId);

		urlParameters.add(new BasicNameValuePair("hashValue", md5Value));
		urlParameters.add(new BasicNameValuePair("phone", accountNumber));

		try {
			httpPost.setEntity(new UrlEncodedFormEntity(urlParameters));
			logger.info("Trx : [{}] :  inquiry  Provider  httpPost connection ", globalTrxId);

		} catch (UnsupportedEncodingException e) {
			logger.error("Trx : [{}] :  inquiry  Provider  httpPost connection ",globalTrxId,e);
			throw new ProviderIntegrationException("Exception of integeration with provider ");
		}

		CloseableHttpResponse response = null;
		try {
			response = httpclient.execute(httpPost);
			result = EntityUtils.toString(response.getEntity(), "UTF-8");
			response.close();
			logger.info("Trx : [{}] :  inquiry  Provider  :[{}] , Status Code [{}] , response body [{}]  ", globalTrxId,accountNumber, response.getStatusLine() , result);
		} catch (ClientProtocolException e) {
			logger.error("Trx : [{}] :  inquiry  Provider ClientProtocol ",globalTrxId,e);
			throw new ProviderIntegrationException("Exception of integeration with provider ");
		} catch (IOException e) {
			logger.error("Trx : [{}] :  inquiry  Provider  IO connection ",globalTrxId,e);
			throw new ProviderIntegrationException("Exception of integeration with provider ");
		}

		if (response.getStatusLine().getStatusCode() != 200) {
			logger.error("Trx : [{}] :  inquiry  Provider : Status Code [{}] ", globalTrxId, response.getStatusLine().getStatusCode());
			throw new ProviderInquiryFailureException(" Status code is not 200 ");
		}
	
		String userName =InquiryJsonParser.extractUserName(result, globalTrxId);
		O2groupAcountDetailsRepresentation  o2groupAcountDetailsRepresentation = null;
	
		    o2groupAcountDetailsRepresentation = new O2groupAcountDetailsRepresentation();
			o2groupAcountDetailsRepresentation.setClientName(userName);
			o2groupAcountDetailsRepresentation.setClientNumber(accountNumber);
		
		return o2groupAcountDetailsRepresentation;
		 
	}
	
	public static void main(String[] args) {
		

	}

}
