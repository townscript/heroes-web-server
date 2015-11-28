package com.townscript.hero.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.RootPanel;
import com.townscript.hero.client.web.LoginPage;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class DashboardMerchant implements EntryPoint {
	
	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		GWT.runAsync(new RunAsyncCallback() {
			
			@Override
			public void onSuccess() {
				String initToken = History.getToken();

				History.addValueChangeHandler(new DashboardMerchantHistoryListener());

				if (initToken.length() == 0) {
					History.newItem("login", true);

				} else {
					History.fireCurrentHistoryState();
				} 
			}
			
			@Override
			public void onFailure(Throwable reason) {
				// TODO Auto-generated method stub
				
			}
		});
	}
}
