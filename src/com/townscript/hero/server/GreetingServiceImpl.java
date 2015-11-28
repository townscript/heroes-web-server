package com.townscript.hero.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.townscript.hero.client.service.GreetingService;
import com.townscript.hero.shared.FieldVerifier;
import com.townscript.hero.shared.merchant.MerchantAccountDetailsDTO;
import com.townscript.hero.shared.merchant.MerchantDataDTO;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class GreetingServiceImpl extends RemoteServiceServlet implements
		GreetingService {

	public String greetServer(String input) throws IllegalArgumentException {
		// Verify that the input is valid. 
		if (!FieldVerifier.isValidName(input)) {
			// If the input is not valid, throw an IllegalArgumentException back to
			// the client.
			throw new IllegalArgumentException(
					"Name must be at least 4 characters long");
		}

		String serverInfo = getServletContext().getServerInfo();
		String userAgent = getThreadLocalRequest().getHeader("User-Agent");

		// Escape data from the client to avoid cross-site script vulnerabilities.
		input = escapeHtml(input);
		userAgent = escapeHtml(userAgent);

		return "Hello, " + input + "!<br><br>I am running " + serverInfo
				+ ".<br><br>It looks like you are using:<br>" + userAgent;
	}
	
	private String escapeHtml(String html) {
		if (html == null) {
			return null;
		}
		return html.replaceAll("&", "&amp;").replaceAll("<", "&lt;")
				.replaceAll(">", "&gt;");
	}

	@Override
	public int addMerchant(MerchantDataDTO merchantDataDTO) {
		
		
		return 0;
	}

	@Override
	public int addMerchantBankDetails(
			MerchantAccountDetailsDTO accountDetailsDTO) {
		return 0;
	}
}
