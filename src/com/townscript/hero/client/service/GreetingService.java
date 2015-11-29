package com.townscript.hero.client.service;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.townscript.hero.shared.UiValidationError;
import com.townscript.hero.shared.ValidateSessionError;
import com.townscript.hero.shared.application.ApplicationDataDTO;
import com.townscript.hero.shared.merchant.MerchantAccountDetailsDTO;
import com.townscript.hero.shared.merchant.MerchantDataDTO;
import com.townscript.hero.shared.transaction.TransactionDetailsDTO;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("greet")
public interface GreetingService extends RemoteService {
	
	int addMerchant(MerchantDataDTO merchantDataDTO) throws UiValidationError,ValidateSessionError;
	
	MerchantDataDTO loadMerchantDataDTO(String email) throws UiValidationError, ValidateSessionError;
	
	MerchantDataDTO loadMerchantDataDTO(int merchantId) throws UiValidationError,ValidateSessionError;
	
	int addMerchantBankDetails(MerchantAccountDetailsDTO accountDetailsDTO) throws UiValidationError,ValidateSessionError;
	
	int updateMerchantBankDetails(MerchantAccountDetailsDTO merchantAccountDetailsDTO) throws UiValidationError,ValidateSessionError;
	
	int addApplicationData(ApplicationDataDTO applicationDataDTO) throws UiValidationError,ValidateSessionError;
	
	int updateApplicationData(ApplicationDataDTO applicationDataDTO) throws UiValidationError,ValidateSessionError;
	
	ApplicationDataDTO loadApplicationDataDTO(int applicationId) throws UiValidationError,ValidateSessionError;
	
	void deleteApplicationData(int applicationId) throws UiValidationError,ValidateSessionError;
	
	List<ApplicationDataDTO> loadAllApplicationDataDTOs() throws UiValidationError,ValidateSessionError;
	
	List<TransactionDetailsDTO> loadAllTransactionDetailsDTOs(int merchantId) throws UiValidationError,ValidateSessionError;
	
	MerchantAccountDetailsDTO loadMerchantAccountDetailsDTO(int accountId) throws UiValidationError,ValidateSessionError;
	
	List<MerchantAccountDetailsDTO> loadBankDetails(int merchantId) throws UiValidationError,ValidateSessionError;
	
	boolean isMerchantExist(String emailId) throws UiValidationError,ValidateSessionError;
	
	void setMerchantInSession(MerchantDataDTO merchantDataDTO) throws UiValidationError,ValidateSessionError;
}
