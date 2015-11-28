package com.townscript.hero.client;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.ui.RootPanel;
import com.townscript.hero.client.web.LoginPage;

public class DashboardMerchantHistoryListener implements ValueChangeHandler<String>{

	@Override
	public void onValueChange(ValueChangeEvent<String> event) {
		if(event.getValue().startsWith("login")){

			RootPanel.get("maincontainer").clear();
			RootPanel.get("maincontainer").add(LoginPage.getInstance());

		}
		
		if(!event.getValue().contains("dashboard") && 
				!event.getValue().contains("profile")){

			RootPanel.get("maincontainer").clear();
			RootPanel.get("maincontainer").add(LoginPage.getInstance());

		}
	}

}
