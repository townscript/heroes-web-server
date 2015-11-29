package com.townscript.hero.client.web;

import java.util.ArrayList;
import java.util.List;

import org.gwtbootstrap3.client.ui.CheckBoxButton;
import org.gwtbootstrap3.client.ui.TextBox;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.townscript.hero.shared.application.ApplicationDataDTO;
import com.townscript.hero.shared.application.PaymentGatewayMapDTO;
import com.townscript.hero.shared.application.PaymentOptions;

public class ApplicationLayout extends Composite {

	private static ApplicationLayoutUiBinder uiBinder = GWT
			.create(ApplicationLayoutUiBinder.class);

	interface ApplicationLayoutUiBinder extends
			UiBinder<Widget, ApplicationLayout> {
	}
	
	@UiField TextBox appName, successUrl, failureUrl;
	@UiField CheckBoxButton isCitrus, isPayUMoney, isNormal;

	public ApplicationLayout() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	public ApplicationDataDTO getApplicationForm() {
		ApplicationDataDTO app = new ApplicationDataDTO();
		app.setTokenId(appName.getText());
		app.setFailureUrl(failureUrl.getText());
		app.setSuccessUrl(successUrl.getText());
		
		List<PaymentGatewayMapDTO> map = new ArrayList<PaymentGatewayMapDTO>();
		if (isCitrus.isActive()) {
			PaymentGatewayMapDTO dto = new PaymentGatewayMapDTO();
			dto.setPaymentOption(PaymentOptions.CITRUSPAY.getPaymentSolutionSource());
			map.add(dto);
		}
		
		if (isPayUMoney.isActive()) {
			PaymentGatewayMapDTO dto = new PaymentGatewayMapDTO();
			dto.setPaymentOption(PaymentOptions.PAYUMONEY.getPaymentSolutionSource());
			map.add(dto);
		}
		
		if (isNormal.isActive()) {
			PaymentGatewayMapDTO dto = new PaymentGatewayMapDTO();
			dto.setPaymentOption(PaymentOptions.CCDBCARD.getPaymentSolutionSource());
			map.add(dto);
		}
		
		app.setPaymentGatewayMaps(map);
		
		return app;
	}
	
	public ApplicationLayout(ApplicationDataDTO dto) {
		initWidget(uiBinder.createAndBindUi(this));
		
		appName.setText(dto.getTokenId());
		successUrl.setText(dto.getSuccessUrl());
		failureUrl.setText(dto.getFailureUrl());
		
		for (PaymentGatewayMapDTO map : dto.getPaymentGatewayMaps()) {
			if(map.getPaymentOption().equalsIgnoreCase(PaymentOptions.CITRUSPAY.getPaymentSolutionSource())){
				isCitrus.setActive(true);
			}
			if (map.getPaymentOption().equalsIgnoreCase(PaymentOptions.PAYUMONEY.getPaymentSolutionSource())) {
				isPayUMoney.setActive(true);
			}
			if (map.getPaymentOption().equalsIgnoreCase(PaymentOptions.CCDBCARD.getPaymentSolutionSource())) {
				isNormal.setActive(true);
			}
		}
		
	}

}
