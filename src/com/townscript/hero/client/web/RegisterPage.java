package com.townscript.hero.client.web;

import org.gwtbootstrap3.client.ui.Button;
import org.gwtbootstrap3.client.ui.PasswordTextBox;
import org.gwtbootstrap3.client.ui.TextBox;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;



public class RegisterPage extends Composite implements HasText{

	private static RegisterPageUiBinder uiBinder = GWT
			.create(RegisterPageUiBinder.class);

	interface RegisterPageUiBinder extends UiBinder<Widget, RegisterPage> {
	}

	@UiField Button signup;
	@UiField TextBox firstname,lastname,email;
	@UiField PasswordTextBox password;
	
	public RegisterPage() {
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

		return new RegisterPage();
	}
}
