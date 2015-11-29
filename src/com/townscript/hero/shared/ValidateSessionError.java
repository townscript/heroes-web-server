package com.townscript.hero.shared;

import com.google.gwt.user.client.rpc.IsSerializable;

public class ValidateSessionError extends Exception implements IsSerializable {

	/**
	 * @author Upen
	 */
	private static final long serialVersionUID = 1L;
	
	public ValidateSessionError(){
		super();
	}
	public ValidateSessionError(String errorMessage){
		
		super(errorMessage);

		
	}

}
