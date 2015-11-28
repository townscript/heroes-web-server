package com.townscript.hero.client.service;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.townscript.hero.shared.merchant.MerchantAccountDetailsDTO;
import com.townscript.hero.shared.merchant.MerchantDataDTO;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface GreetingServiceAsync {
	void greetServer(String input, AsyncCallback<String> callback)
			throws IllegalArgumentException;
	
	void addMerchant(MerchantDataDTO merchantDataDTO,AsyncCallback<Integer> callback);
	
	void addMerchantBankDetails(MerchantAccountDetailsDTO accountDetailsDTO,AsyncCallback<Integer> callback);
}
