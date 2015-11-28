package com.townscript.hero.client.web;

import org.gwtbootstrap3.client.ui.Button;
import org.gwtbootstrap3.client.ui.Paragraph;
import org.gwtbootstrap3.client.ui.PasswordTextBox;
import org.gwtbootstrap3.client.ui.TextBox;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;

public class LoginPage extends Composite  implements HasText {

	private static LoginPageUiBinder uiBinder = GWT
			.create(LoginPageUiBinder.class);

	interface LoginPageUiBinder extends UiBinder<Widget, LoginPage> {
	}

	@UiField TextBox userName;
	@UiField PasswordTextBox password;
	@UiField Paragraph signup;
	@UiField Button login;
	
	public LoginPage() {
		initWidget(uiBinder.createAndBindUi(this));
		
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

	@UiHandler("signup")
	public void onLoginClick(ClickEvent event) {
		 History.newItem("signup");
	}
}
