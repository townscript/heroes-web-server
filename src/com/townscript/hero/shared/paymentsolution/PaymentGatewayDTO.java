package com.townscript.hero.shared.paymentsolution;

import com.google.gwt.user.client.rpc.IsSerializable;

public class PaymentGatewayDTO implements IsSerializable {

	private int pgId;
	
	private String paymentGatewayName;
	
	private String url;
	
	private String salt;
	
	private String key;

	public int getPgId() {
		return pgId;
	}

	public void setPgId(int pgId) {
		this.pgId = pgId;
	}

	public String getPaymentGatewayName() {
		return paymentGatewayName;
	}

	public void setPaymentGatewayName(String paymentGatewayName) {
		this.paymentGatewayName = paymentGatewayName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
	
	
}
