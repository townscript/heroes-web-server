package com.townscript.hero.client.web;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class ApplicationLayout extends Composite {

	private static ApplicationLayoutUiBinder uiBinder = GWT
			.create(ApplicationLayoutUiBinder.class);

	interface ApplicationLayoutUiBinder extends
			UiBinder<Widget, ApplicationLayout> {
	}

	public ApplicationLayout() {
		initWidget(uiBinder.createAndBindUi(this));
	}

}
