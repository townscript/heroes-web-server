package com.townscript.hero.client.web;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class RegisterPage extends Composite implements HasText{

	private static RegisterPageUiBinder uiBinder = GWT
			.create(RegisterPageUiBinder.class);

	interface RegisterPageUiBinder extends UiBinder<Widget, RegisterPage> {
	}

	@UiField Label signup,login;
	@UiField TextBox firstname,lastname,email;
	@UiField PasswordTextBox password;
	
	public RegisterPage() {
		initWidget(uiBinder.createAndBindUi(this));
		
	}

	 @UiHandler("login")
	 public void onLoginClick(ClickEvent event) {
		 History.newItem("login");
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
