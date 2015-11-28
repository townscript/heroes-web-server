package com.townscript.heroes.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;
import com.townscript.heroes.client.web.LoginPage;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Heroesgwt implements EntryPoint {

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		GWT.runAsync(new RunAsyncCallback() {
			
			@Override
			public void onSuccess() {
				String initToken = History.getToken();

				History.addValueChangeHandler(new HeroesGwtHistoryListener());

				if (initToken.length() == 0) {
					RootPanel.get("maincontainer").clear();
					RootPanel.get("maincontainer").add(LoginPage.getInstance());


				} else {
					History.fireCurrentHistoryState();
				} 
			}
			
			@Override
			public void onFailure(Throwable reason) {
				Window.Location.reload();
			}
		});
	}
}
