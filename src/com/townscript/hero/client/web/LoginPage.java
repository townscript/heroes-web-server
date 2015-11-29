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


public class LoginPage extends Composite  implements HasText {

	private static LoginPageUiBinder uiBinder = GWT
			.create(LoginPageUiBinder.class);

	interface LoginPageUiBinder extends UiBinder<Widget, LoginPage> {
	}

	@UiField TextBox userName;
	@UiField PasswordTextBox password;
	@UiField Button login;
	
	public LoginPage() {
		initWidget(uiBinder.createAndBindUi(this));
		
	}

	@UiHandler("login")
	public void onLoginClick(ClickEvent event) {
		final GreetingServiceAsync service = (GreetingServiceAsync)GWT.create(GreetingService.class);
		ServiceDefTarget serviceDef = (ServiceDefTarget) service;
		serviceDef.setServiceEntryPoint(GWT.getModuleBaseURL()
				+ "greet");
		
		service.isMerchantExist(userName.getText().trim(), new AsyncCallback<Boolean>() {
			
			@Override
			public void onSuccess(Boolean result) {
				if (result) {
					
					service.loadMerchantDataDTO(userName.getText().trim(), new AsyncCallback<MerchantDataDTO>() {
						
						@Override
						public void onSuccess(MerchantDataDTO result) {
							if (result != null) {
								if (result.getPassword().equals(password.getText().trim())) {
									service.setMerchantInSession(result, new AsyncCallback<Void>() {
										
										@Override
										public void onSuccess(Void result) {
											History.newItem("dashboard");
										}
										
										@Override
										public void onFailure(Throwable caught) {
											
										}
									});
									
								}else{
									Window.alert("Please enter correct password");
								}
							}else{
								Window.alert("Merchant not found");
								
							}
						}
						
						@Override
						public void onFailure(Throwable caught) {
							Window.alert(caught.getMessage());
						}
					});
					
				}else{
					Window.alert("Merchant with this email id is not exist");
				}
			}
			
			@Override
			public void onFailure(Throwable caught) {
				Window.alert(caught.getMessage());
			}
		});
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

		return new LoginPage();
	}

}
