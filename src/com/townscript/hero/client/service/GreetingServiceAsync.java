package com.townscript.hero.client.service;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.townscript.hero.shared.application.ApplicationDataDTO;
import com.townscript.hero.shared.merchant.MerchantAccountDetailsDTO;
import com.townscript.hero.shared.merchant.MerchantDataDTO;
import com.townscript.hero.shared.transaction.TransactionDetailsDTO;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface GreetingServiceAsync {
	
	void addMerchant(MerchantDataDTO merchantDataDTO,AsyncCallback<Integer> callback);
	
	void loadMerchantDataDTO(String email,AsyncCallback<MerchantDataDTO> callback);
	
	void loadMerchantDataDTO(int merchantId,AsyncCallback<MerchantDataDTO> callback);
	
	void addMerchantBankDetails(MerchantAccountDetailsDTO accountDetailsDTO,AsyncCallback<Integer> callback);
	
	void updateMerchantBankDetails(MerchantAccountDetailsDTO merchantAccountDetailsDTO,AsyncCallback<Integer> callback);
	
	void addApplicationData(ApplicationDataDTO applicationDataDTO,AsyncCallback<Integer> callback);
	
	void updateApplicationData(ApplicationDataDTO applicationDataDTO,AsyncCallback<Integer> callback);
	
	void loadApplicationDataDTO(int applicationId,AsyncCallback<ApplicationDataDTO> callback);
	
	void deleteApplicationData(int applicationId,AsyncCallback<Void> callback);
	
	void loadAllApplicationDataDTOs(
			AsyncCallback<List<ApplicationDataDTO>> callback);
	
	void loadAllTransactionDetailsDTOs(int merchantId,AsyncCallback<List<TransactionDetailsDTO>> callback);
	
	void loadMerchantAccountDetailsDTO(int account,AsyncCallback<MerchantAccountDetailsDTO> callback);
	
	void loadBankDetails(int merchantId,AsyncCallback<List<MerchantAccountDetailsDTO>> callback);
	
	void isMerchantExist(String emailId,AsyncCallback<Boolean> callback);
	
	void setMerchantInSession(MerchantDataDTO merchantDataDTO,AsyncCallback<Void> callback);
}
