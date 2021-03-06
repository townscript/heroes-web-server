package com.townscript.hero.client;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.RootPanel;
import com.townscript.hero.client.web.DashboardPage;
import com.townscript.hero.client.web.LoginPage;
import com.townscript.hero.client.web.RegisterPage;

public class DashboardMerchantHistoryListener implements ValueChangeHandler<String>{

	@Override
	public void onValueChange(ValueChangeEvent<String> event) {
		if(event.getValue().startsWith("login")){

			RootPanel.get("maincontainer").clear();
			RootPanel.get("maincontainer").add(LoginPage.getInstance());

		}
		if(event.getValue().startsWith("signup")){

			RootPanel.get("maincontainer").clear();
			RootPanel.get("maincontainer").add(RegisterPage.getInstance());

		}
		
		if(event.getValue().startsWith("dashboard")){

			RootPanel.get("maincontainer").clear();
			RootPanel.get("maincontainer").add(DashboardPage.getInstance());

		}
		
		if(!event.getValue().contains("dashboard") && 
				!event.getValue().contains("signup") && !event.getValue().contains("dashboard")){
			
			History.newItem("login", true);

		}
	}

}
