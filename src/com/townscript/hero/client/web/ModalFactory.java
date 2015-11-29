package com.townscript.hero.client.web;

public class ModalFactory {
	
	private static Modal modal;
	
	public static Modal getInstance() {
		if (modal == null) {
			modal = new Modal();
		}
		return modal;
	}

}
