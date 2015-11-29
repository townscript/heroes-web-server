package com.townscript.hero.shared.application;

import com.google.gwt.user.client.rpc.IsSerializable;

public class PaymentGatewayMapDTO implements IsSerializable{

	private int mapId;
	
	private int pgId;
	
	private int applicationId;
	
	private String paymentOption;

	public int getMapId() {
		return mapId;
	}

	public void setMapId(int mapId) {
		this.mapId = mapId;
	}

	public int getPgId() {
		return pgId;
	}

	public void setPgId(int pgId) {
		this.pgId = pgId;
	}

	public int getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(int applicationId) {
		this.applicationId = applicationId;
	}

	public String getPaymentOption() {
		return paymentOption;
	}

	public void setPaymentOption(String paymentOption) {
		this.paymentOption = paymentOption;
	}
	
	
}
