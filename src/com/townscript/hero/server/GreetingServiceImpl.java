package com.townscript.hero.server;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.net.URLEncoder;
import java.util.List;

import org.json.simple.JSONObject;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.townscript.hero.client.service.GreetingService;
import com.townscript.hero.shared.UiValidationError;
import com.townscript.hero.shared.application.ApplicationDataDTO;
import com.townscript.hero.shared.merchant.MerchantAccountDetailsDTO;
import com.townscript.hero.shared.merchant.MerchantDataDTO;
import com.townscript.hero.shared.transaction.TransactionDetailsDTO;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class GreetingServiceImpl extends RemoteServiceServlet implements
		GreetingService {

	private static final String MERCHANT_ADD_URL= "merchant/add";
	private static final String MERCHANT_LOAD_URL= "merchant/get";
	private static final String MERCHANT_LOAD_BY_ID_URL= "merchant/getbyid";
	private static final String MERCHANT_IS_EXIST_URL= "merchant/isexist";
	private static final String MERCHANT_ADD_ACCOUNT_URL= "account/add";
	private static final String MERCHANT_UPDATE_ACCOUNT_URL= "account/update";
	private static final String MERCHANT_LOAD_ACCOUNT_URL= "account/get";
	private static final String MERCHANT_LOAD_ALL_ACCOUNT_URL= "account/getall";
	private static final String APPLICATION_ADD_URL= "application/add";
	private static final String APPLICATION_UPDATE_URL= "application/update";
	private static final String APPLICATION_LOAD_URL= "application/get";
	private static final String APPLICATION_LOAD_ALL_URL= "application/getall";
	private static final String APPLICATION_DELETE_URL= "application/delete";
	private static final String TRANSACTION_LOAD_ALL_URL = "transaction/getall";
	
	private static final String serverBaseUrl = ServerFactory.getApiServerAddress();
	
	@Override
	public int addMerchant(MerchantDataDTO merchantDataDTO) throws UiValidationError {
		
		String jsonString = new Gson().toJson(merchantDataDTO);
		
		String data = null;
		
		try {
			
			data = URLEncoder.encode("json_data", "UTF-8") + "="
					+ URLEncoder.encode(jsonString, "UTF-8");
			
			int id = TestHttpUtility.getHttpPostResponse(serverBaseUrl, MERCHANT_ADD_URL, data);
			merchantDataDTO.setMerchantId(id);
			return id;
		} catch (UnsupportedEncodingException e) {

			e.printStackTrace();
			throw new UiValidationError(e.getMessage(), 401);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new UiValidationError(e.getMessage(), 401);
		}
	}

	@Override
	public int addMerchantBankDetails(
			MerchantAccountDetailsDTO accountDetailsDTO) throws UiValidationError {
		String jsonString = new Gson().toJson(accountDetailsDTO);
		
		String data = null;
		
		try {
			
			data = URLEncoder.encode("json_data", "UTF-8") + "="
					+ URLEncoder.encode(jsonString, "UTF-8");
			
			int id = TestHttpUtility.getHttpPostResponse(serverBaseUrl, MERCHANT_ADD_ACCOUNT_URL, data);
			accountDetailsDTO.setAccountId(id);
			return id;
			
		} catch (UnsupportedEncodingException e) {

			e.printStackTrace();
			throw new UiValidationError(e.getMessage(), 401);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new UiValidationError(e.getMessage(), 401);
		}
	}


	@Override
	public MerchantDataDTO loadMerchantDataDTO(String email)
			throws UiValidationError {
		
		String webPage = MERCHANT_LOAD_URL + "?emailid=" + email ;
		MerchantDataDTO merchantDataDTO ;
		JSONObject jsonObject = (JSONObject) TestHttpUtility.getHttpGetResponse(serverBaseUrl,
				webPage);

		if (jsonObject.get("result").equals("Success")) {

			String data = (String) jsonObject.get("data");
			Type merchantObject = new TypeToken<MerchantDataDTO>() {
			}.getType();

			merchantDataDTO = new Gson().fromJson(data, merchantObject);
			return merchantDataDTO;
		}else{
			long longcode = (Long) jsonObject.get("code");
			int code = (int) longcode;
			System.out.println("Error code : " + code);
			System.out.println("Error message : " + jsonObject.get("message"));
			throw new UiValidationError((String)jsonObject.get("message"), 401);
		}
		
	}

	@Override
	public MerchantDataDTO loadMerchantDataDTO(int merchantId)
			throws UiValidationError {
		String webPage = MERCHANT_LOAD_BY_ID_URL + "?id=" + String.valueOf(merchantId) ;
		MerchantDataDTO merchantDataDTO ;
		JSONObject jsonObject = (JSONObject) TestHttpUtility.getHttpGetResponse(serverBaseUrl,
				webPage);

		if (jsonObject.get("result").equals("Success")) {

			String data = (String) jsonObject.get("data");
			Type merchantObject = new TypeToken<MerchantDataDTO>() {
			}.getType();

			merchantDataDTO = new Gson().fromJson(data, merchantObject);
			return merchantDataDTO;
		}else{
			long longcode = (Long) jsonObject.get("code");
			int code = (int) longcode;
			System.out.println("Error code : " + code);
			System.out.println("Error message : " + jsonObject.get("message"));
			throw new UiValidationError((String)jsonObject.get("message"), 401);
		}
	}
	
	@Override
	public int updateMerchantBankDetails(
			MerchantAccountDetailsDTO merchantAccountDetailsDTO) throws UiValidationError {
		String jsonString = new Gson().toJson(merchantAccountDetailsDTO);
		
		String data = null;
		
		try {
			
			data = URLEncoder.encode("json_data", "UTF-8") + "="
					+ URLEncoder.encode(jsonString, "UTF-8");
			
			int id = TestHttpUtility.getHttpPostResponse(serverBaseUrl, MERCHANT_UPDATE_ACCOUNT_URL, data);
			merchantAccountDetailsDTO.setAccountId(id);
			return id;
			
		} catch (UnsupportedEncodingException e) {

			e.printStackTrace();
			throw new UiValidationError(e.getMessage(), 401);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new UiValidationError(e.getMessage(), 401);
		}
	}

	@Override
	public int addApplicationData(ApplicationDataDTO applicationDataDTO) throws UiValidationError {
		
		String merchantId = (String) getThreadLocalRequest().getSession().getAttribute("merchantId");
		
		applicationDataDTO.setMerchantId(Integer.parseInt(merchantId));
		
		String jsonString = new Gson().toJson(applicationDataDTO);
		
		String data = null;
		
		try {
			
			data = URLEncoder.encode("json_data", "UTF-8") + "="
					+ URLEncoder.encode(jsonString, "UTF-8");
			
			int id = TestHttpUtility.getHttpPostResponse(serverBaseUrl, APPLICATION_ADD_URL, data);
			applicationDataDTO.setAppId(id);
			return id;
			
		} catch (UnsupportedEncodingException e) {

			e.printStackTrace();
			throw new UiValidationError(e.getMessage(), 401);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new UiValidationError(e.getMessage(), 401);
		}
	}

	@Override
	public int updateApplicationData(ApplicationDataDTO applicationDataDTO) throws UiValidationError {
		
		String jsonString = new Gson().toJson(applicationDataDTO);
		
		String data = null;
		
		try {
			
			data = URLEncoder.encode("json_data", "UTF-8") + "="
					+ URLEncoder.encode(jsonString, "UTF-8");
			
			int id = TestHttpUtility.getHttpPostResponse(serverBaseUrl, APPLICATION_UPDATE_URL, data);
			applicationDataDTO.setAppId(id);
			return id;
			
		} catch (UnsupportedEncodingException e) {

			e.printStackTrace();
			throw new UiValidationError(e.getMessage(), 401);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new UiValidationError(e.getMessage(), 401);
		}
	}

	@Override
	public ApplicationDataDTO loadApplicationDataDTO(int applicationId) throws UiValidationError {
		
		String webPage = APPLICATION_LOAD_URL + "?appid=" + String.valueOf(applicationId) ;
		
		ApplicationDataDTO applicationDataDTO ;
		JSONObject jsonObject = (JSONObject) TestHttpUtility.getHttpGetResponse(serverBaseUrl,
				webPage);

		if (jsonObject.get("result").equals("Success")) {

			String data = (String) jsonObject.get("data");
			Type merchantObject = new TypeToken<ApplicationDataDTO>() {
			}.getType();

			applicationDataDTO = new Gson().fromJson(data, merchantObject);
			return applicationDataDTO;
		}else{
			long longcode = (Long) jsonObject.get("code");
			int code = (int) longcode;
			System.out.println("Error code : " + code);
			System.out.println("Error message : " + jsonObject.get("message"));
			throw new UiValidationError((String)jsonObject.get("message"), 401);
		}
	}

	@Override
	public void deleteApplicationData(int applicationId) throws UiValidationError {
		
		String stringApplicationId = new Integer(applicationId)
		.toString();
		String data = null;
		try {
			data = URLEncoder.encode("appid", "UTF-8") + "="
					+ URLEncoder.encode(stringApplicationId, "UTF-8");
			int index= TestHttpUtility.getHttpPostResponse(
					serverBaseUrl, APPLICATION_DELETE_URL, data);
			
			System.out.println("Application data With index "+index+" Deleted");
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			throw new UiValidationError(e.getMessage(), 401);
		}catch (Exception e) {
			e.printStackTrace();
			throw new UiValidationError(e.getMessage(), 401);
		}
		
	}

	@Override
	public List<ApplicationDataDTO> loadAllApplicationDataDTOs() throws UiValidationError {
		
		String merchantId = (String) getThreadLocalRequest().getSession().getAttribute("merchantId");
		
		String webPage = APPLICATION_LOAD_ALL_URL + "?merchantid=" + String.valueOf(merchantId) ;
		
		List<ApplicationDataDTO> applicationDataDTO ;
		JSONObject jsonObject = (JSONObject) TestHttpUtility.getHttpGetResponse(serverBaseUrl,
				webPage);

		if (jsonObject.get("result").equals("Success")) {

			String data = (String) jsonObject.get("data");
			Type merchantObject = new TypeToken<List<ApplicationDataDTO>>() {
			}.getType();

			applicationDataDTO = new Gson().fromJson(data, merchantObject);
			return applicationDataDTO;
		}else{
			long longcode = (Long) jsonObject.get("code");
			int code = (int) longcode;
			System.out.println("Error code : " + code);
			System.out.println("Error message : " + jsonObject.get("message"));
			throw new UiValidationError((String)jsonObject.get("message"), 401);
		}
	}

	@Override
	public List<TransactionDetailsDTO> loadAllTransactionDetailsDTOs(
			int merchantId) throws UiValidationError {
		String webPage = TRANSACTION_LOAD_ALL_URL + "?merchantid=" + String.valueOf(merchantId) ;
		
		List<TransactionDetailsDTO> transactionDetailsDTOs ;
		JSONObject jsonObject = (JSONObject) TestHttpUtility.getHttpGetResponse(serverBaseUrl,
				webPage);

		if (jsonObject.get("result").equals("Success")) {

			String data = (String) jsonObject.get("data");
			Type transactionObject = new TypeToken<List<TransactionDetailsDTO>>() {
			}.getType();

			transactionDetailsDTOs = new Gson().fromJson(data, transactionObject);
			return transactionDetailsDTOs;
		}else{
			long longcode = (Long) jsonObject.get("code");
			int code = (int) longcode;
			System.out.println("Error code : " + code);
			System.out.println("Error message : " + jsonObject.get("message"));
			throw new UiValidationError((String)jsonObject.get("message"), 401);
		}
		
	}

	@Override
	public MerchantAccountDetailsDTO loadMerchantAccountDetailsDTO(
			int accountId) throws UiValidationError {
		
		String webPage = MERCHANT_LOAD_ACCOUNT_URL + "?accountid=" + String.valueOf(accountId) ;
		
		MerchantAccountDetailsDTO merchantAccountDetailsDTO ;
		JSONObject jsonObject = (JSONObject) TestHttpUtility.getHttpGetResponse(serverBaseUrl,
				webPage);

		if (jsonObject.get("result").equals("Success")) {

			String data = (String) jsonObject.get("data");
			Type merchantAccountObject = new TypeToken<MerchantAccountDetailsDTO>() {
			}.getType();

			merchantAccountDetailsDTO = new Gson().fromJson(data, merchantAccountObject);
			return merchantAccountDetailsDTO;
		}else{
			long longcode = (Long) jsonObject.get("code");
			int code = (int) longcode;
			System.out.println("Error code : " + code);
			System.out.println("Error message : " + jsonObject.get("message"));
			throw new UiValidationError((String)jsonObject.get("message"), 401);
		}
		
	}

	@Override
	public List<MerchantAccountDetailsDTO> loadBankDetails(int merchantId) throws UiValidationError {
		
		String webPage = MERCHANT_LOAD_ALL_ACCOUNT_URL + "?merchantid=" + String.valueOf(merchantId) ;
		
		List<MerchantAccountDetailsDTO> merchantAccountDetailsDTOs ;
		JSONObject jsonObject = (JSONObject) TestHttpUtility.getHttpGetResponse(serverBaseUrl,
				webPage);

		if (jsonObject.get("result").equals("Success")) {

			String data = (String) jsonObject.get("data");
			Type merchantAccountObject = new TypeToken<List<MerchantAccountDetailsDTO>>() {
			}.getType();

			merchantAccountDetailsDTOs = new Gson().fromJson(data, merchantAccountObject);
			return merchantAccountDetailsDTOs;
		}else{
			long longcode = (Long) jsonObject.get("code");
			int code = (int) longcode;
			System.out.println("Error code : " + code);
			System.out.println("Error message : " + jsonObject.get("message"));
			throw new UiValidationError((String)jsonObject.get("message"), 401);
		}
	}

	@Override
	public boolean isMerchantExist(String emailId) throws UiValidationError {
		
		String webPage = MERCHANT_IS_EXIST_URL + "?isexist=" + emailId ;
		
		boolean isExist = false ;
		JSONObject jsonObject = (JSONObject) TestHttpUtility.getHttpGetResponse(serverBaseUrl,
				webPage);

		if (jsonObject.get("result").equals("Success")) {

			String data = (String) jsonObject.get("data");
			Type isExistObject = new TypeToken<Boolean>() {
			}.getType();

			isExist = new Gson().fromJson(data, isExistObject);
			return isExist;
		}else{
			long longcode = (Long) jsonObject.get("code");
			int code = (int) longcode;
			System.out.println("Error code : " + code);
			System.out.println("Error message : " + jsonObject.get("message"));
			throw new UiValidationError((String)jsonObject.get("message"), 401);
		}
	}

	
}
