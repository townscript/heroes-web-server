package com.townscript.hero.client.service;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.townscript.hero.shared.merchant.MerchantDataDTO;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("greet")
public interface GreetingService extends RemoteService {
	String greetServer(String name) throws IllegalArgumentException;
	
//	int addMerchant(MerchantDataDTO merchantDataDTO);
	
	
}
