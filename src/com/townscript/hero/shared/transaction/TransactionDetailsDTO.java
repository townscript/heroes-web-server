package com.townscript.hero.shared.transaction;

import java.util.Date;

import com.google.gwt.user.client.rpc.IsSerializable;

public class TransactionDetailsDTO implements IsSerializable{

	private int txnId;
	
	private String uniqueOrderId;
	
	private String userName;
	
	private String userEmailId;
	
	private float txnAmount;

	private String currency;
	
	private String paymentGatewayId;
	
	private String transactionStatus ;
	
	private Date transactionTimestamp;
	
	private String transactionSource ; 
	
	private String phoneNumber;
	
	private int paymentSolutionId;

	private int merchantId;
	
	public int getTxnId() {
		return txnId;
	}

	public void setTxnId(int txnId) {
		this.txnId = txnId;
	}

	public String getUniqueOrderId() {
		return uniqueOrderId;
	}

	public void setUniqueOrderId(String uniqueOrderId) {
		this.uniqueOrderId = uniqueOrderId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmailId() {
		return userEmailId;
	}

	public void setUserEmailId(String userEmailId) {
		this.userEmailId = userEmailId;
	}

	public float getTxnAmount() {
		return txnAmount;
	}

	public void setTxnAmount(float txnAmount) {
		this.txnAmount = txnAmount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getPaymentGatewayId() {
		return paymentGatewayId;
	}

	public void setPaymentGatewayId(String paymentGatewayId) {
		this.paymentGatewayId = paymentGatewayId;
	}

	public String getTransactionStatus() {
		return transactionStatus;
	}

	public void setTransactionStatus(String transactionStatus) {
		this.transactionStatus = transactionStatus;
	}

	public Date getTransactionTimestamp() {
		return transactionTimestamp;
	}

	public void setTransactionTimestamp(Date transactionTimestamp) {
		this.transactionTimestamp = transactionTimestamp;
	}

	public String getTransactionSource() {
		return transactionSource;
	}

	public void setTransactionSource(String transactionSource) {
		this.transactionSource = transactionSource;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getPaymentSolutionId() {
		return paymentSolutionId;
	}

	public void setPaymentSolutionId(int paymentSolutionId) {
		this.paymentSolutionId = paymentSolutionId;
	}

	public int getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(int merchantId) {
		this.merchantId = merchantId;
	}
	
	
}
