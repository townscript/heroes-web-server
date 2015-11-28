package com.townscript.heroes.client;


import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.ui.RootPanel;
import com.townscript.heroes.client.web.LoginPage;

public class HeroesGwtHistoryListener  implements ValueChangeHandler<String> {

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
