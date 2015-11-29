package com.townscript.hero.client.web;

import org.gwtbootstrap3.client.ui.Button;
import org.gwtbootstrap3.client.ui.PasswordTextBox;
import org.gwtbootstrap3.client.ui.TextBox;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;
import com.townscript.hero.client.service.GreetingService;
import com.townscript.hero.client.service.GreetingServiceAsync;
import com.townscript.hero.shared.merchant.MerchantDataDTO;



public class RegisterPage extends Composite implements HasText{

	private static RegisterPageUiBinder uiBinder = GWT
			.create(RegisterPageUiBinder.class);

	interface RegisterPageUiBinder extends UiBinder<Widget, RegisterPage> {
	}

	@UiField Button signup;
	@UiField TextBox firstname,lastname,email;
	@UiField PasswordTextBox password;
	private boolean isClicked = false;
	
	public RegisterPage() {
		initWidget(uiBinder.createAndBindUi(this));
		
	}


	@UiHandler("signup")
	public void onSignUpClick(ClickEvent event){
		final GreetingServiceAsync service = (GreetingServiceAsync)GWT.create(GreetingService.class);
		ServiceDefTarget serviceDef = (ServiceDefTarget) service;
		serviceDef.setServiceEntryPoint(GWT.getModuleBaseURL()
				+ "greet");
		
		service.isMerchantExist(email.getText().trim(), new AsyncCallback<Boolean>() {
			
			@Override
			public void onSuccess(Boolean result) {
				if (result) {
					Window.alert("Merchant with this email id already exist");
				}else{
					if(isClicked){
						return;
					}
					isClicked = true;
					MerchantDataDTO dataDTO = getMerchantData();
					service.addMerchant(dataDTO, new AsyncCallback<Integer>() {
						
						@Override
						public void onSuccess(Integer result) {
							isClicked = false;
							History.newItem("login");
						}
						
						@Override
						public void onFailure(Throwable caught) {
							isClicked = false;
							Window.alert(caught.getMessage());
						}
					});
				}
			}
			
			@Override
			public void onFailure(Throwable caught) {
				isClicked = false;
				Window.alert(caught.getMessage());
			}
		});
		
		
		
	}
	
	private MerchantDataDTO getMerchantData() {
		
		MerchantDataDTO merchantDataDTO = new MerchantDataDTO();
		merchantDataDTO.setEmailId(email.getText().trim());
		merchantDataDTO.setFirstName(firstname.getText());
		merchantDataDTO.setLastName(lastname.getText().trim());
		merchantDataDTO.setPassword(password.getText().trim());
		return merchantDataDTO;
	}


	@Override
	public String getText() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setText(String text) {
		// TODO Auto-generated method stub
		
	}
	
	public static Widget getInstance() { 

		return new RegisterPage();
	}
}
