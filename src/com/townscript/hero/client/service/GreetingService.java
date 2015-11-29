package com.townscript.hero.client.service;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.townscript.hero.shared.UiValidationError;
import com.townscript.hero.shared.application.ApplicationDataDTO;
import com.townscript.hero.shared.merchant.MerchantAccountDetailsDTO;
import com.townscript.hero.shared.merchant.MerchantDataDTO;
import com.townscript.hero.shared.transaction.TransactionDetailsDTO;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("greet")
public interface GreetingService extends RemoteService {
	
	int addMerchant(MerchantDataDTO merchantDataDTO) throws UiValidationError;
	
	MerchantDataDTO loadMerchantDataDTO(String email) throws UiValidationError;
	
	MerchantDataDTO loadMerchantDataDTO(int merchantId) throws UiValidationError;
	
	int addMerchantBankDetails(MerchantAccountDetailsDTO accountDetailsDTO) throws UiValidationError;
	
	int updateMerchantBankDetails(MerchantAccountDetailsDTO merchantAccountDetailsDTO) throws UiValidationError;
	
	int addApplicationData(ApplicationDataDTO applicationDataDTO) throws UiValidationError;
	
	int updateApplicationData(ApplicationDataDTO applicationDataDTO) throws UiValidationError;
	
	ApplicationDataDTO loadApplicationDataDTO(int applicationId) throws UiValidationError;
	
	void deleteApplicationData(int applicationId) throws UiValidationError;
	
	List<ApplicationDataDTO> loadAllApplicationDataDTOs() throws UiValidationError;
	
	List<TransactionDetailsDTO> loadAllTransactionDetailsDTOs(int merchantId) throws UiValidationError;
	
	MerchantAccountDetailsDTO loadMerchantAccountDetailsDTO(int accountId) throws UiValidationError;
	
	List<MerchantAccountDetailsDTO> loadBankDetails(int merchantId) throws UiValidationError;
	
	boolean isMerchantExist(String emailId) throws UiValidationError;
	
	
}
