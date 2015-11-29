package com.townscript.hero.shared.application;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.rpc.IsSerializable;

public class ApplicationDataDTO implements IsSerializable{

	private int appId;
	
	private int merchantId;
	
	private String tokenId;
	
	private String deviceSource;
	
	private String successUrl;
	
	private String failureUrl;

	private List<PaymentGatewayMapDTO> paymentGatewayMaps = new ArrayList<PaymentGatewayMapDTO>();

	public int getAppId() {
		return appId;
	}

	public void setAppId(int appId) {
		this.appId = appId;
	}

	public int getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(int merchantId) {
		this.merchantId = merchantId;
	}

	public String getTokenId() {
		return tokenId;
	}

	public void setTokenId(String tokenId) {
		this.tokenId = tokenId;
	}

	public String getDeviceSource() {
		return deviceSource;
	}

	public void setDeviceSource(String deviceSource) {
		this.deviceSource = deviceSource;
	}

	public String getSuccessUrl() {
		return successUrl;
	}

	public void setSuccessUrl(String successUrl) {
		this.successUrl = successUrl;
	}

	public String getFailureUrl() {
		return failureUrl;
	}

	public void setFailureUrl(String failureUrl) {
		this.failureUrl = failureUrl;
	}

	public List<PaymentGatewayMapDTO> getPaymentGatewayMaps() {
		return paymentGatewayMaps;
	}

	public void setPaymentGatewayMaps(List<PaymentGatewayMapDTO> paymentGatewayMaps) {
		this.paymentGatewayMaps = paymentGatewayMaps;
	}
	
	
	
}
