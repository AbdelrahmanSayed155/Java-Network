
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.masary.o2group.exceptions.ProviderCustomerNotFoundException;
import com.masary.o2group.exceptions.ProviderInquiryFailureException;
import com.masary.o2group.exceptions.ProviderIntegrationException;
import com.masary.o2group.exceptions.ProviderPaymentFailureException;
import com.masary.o2group.services.component.pojo.O2groupAcountDetailsRepresentation;
import com.masary.o2group.services.component.util.Md5GeneratorUtil;

@Component
// @Profile("standalone")
@Profile("!standalone")
public class ProviderCallerImpl implements ProviderCaller {

	// 01000003598
	@Value("${o2Group.provider.securitykey}")
	private String securitykey;

	@Value("${o2Group.provider.inquiryUrl}")
	private String inquiryUrl ;

	@Value("${o2Group.provider.paymentUrl}")
	private String paymentUrl ;

	private static final Logger logger = LoggerFactory.getLogger(ProviderCallerImpl.class);

	 @Override
	public O2groupAcountDetailsRepresentation inquireBill(String accountNumber, String globalTrxId) {
		logger.info("Trx : [{}] :  inquiry Bill Provider ", globalTrxId);
		
		String result = null;

		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(inquiryUrl);

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

	@Override
	public void payBill(String accountNumber, Integer denominationValue, String globalTrxId) {

		String responseJson = null;

		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(paymentUrl);

		List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();

		String md5Value = Md5GeneratorUtil.applyMd5("check" + accountNumber + denominationValue.toString(), securitykey,
				globalTrxId);
		urlParameters.add(new BasicNameValuePair("hashValue", md5Value));
		urlParameters.add(new BasicNameValuePair("phone", accountNumber));
		urlParameters.add(new BasicNameValuePair("package", denominationValue.toString()));
		urlParameters.add(new BasicNameValuePair("transNum", globalTrxId));

		try {
			logger.info("Trx : [{}] :  Payment  Provider  httpPost connection ", globalTrxId);
			httpPost.setEntity(new UrlEncodedFormEntity(urlParameters));
		} catch (UnsupportedEncodingException e) {
			logger.error("Trx : [{}] :  Payment  Provider  httpPost connection",globalTrxId,e);
			throw new ProviderIntegrationException("Exception of integeration with provider ");
		}

		CloseableHttpResponse response = null;
		try {
			response = httpclient.execute(httpPost);
			responseJson = EntityUtils.toString(response.getEntity(), "UTF-8");
			
			logger.info("Trx : [{}] :  Payment  Provider   Status Code [{}] , response body [{}] ", globalTrxId, response.getStatusLine() , responseJson);
			
			response.close();
		} catch (ClientProtocolException e) {
			logger.error("Trx : [{}] :  Payment  Provider ClientProtocol ",	globalTrxId,e);
			throw new ProviderIntegrationException("Exception of integeration with provider ");
		} catch (IOException e) {
			logger.error("Trx : [{}] :  Payment  Provider  IO connection ",	globalTrxId,e);
			throw new ProviderIntegrationException("Exception of integeration with provider ");
		}
		if (response.getStatusLine().getStatusCode() != 200) {
			logger.info("Trx : [{}] :  Payment   Provider : Status Code : [{}] ", globalTrxId,response.getStatusLine().getStatusCode());
			throw new ProviderPaymentFailureException(" Status code is not 200 ");
		}
		if (!responseJson.contains("Successfully Fill")) {
			throw new ProviderPaymentFailureException(" Not Successfully Fill ");
		}
	}




}
