package com.townscript.hero.shared;

import com.google.gwt.user.client.rpc.IsSerializable;

public class UiValidationError extends Exception implements IsSerializable {

	public UiValidationError() {
		super();
	
	}
 
	private static final long serialVersionUID = 1L;
	
	private int errorcode;
	
	public UiValidationError(String errormessage,int errorcode){
		
		super(errormessage);
		
	    setErrorcode(errorcode);
		
	}

	public int getErrorcode() {
		return errorcode;
	}

	public void setErrorcode(int errorcode) {
		this.errorcode = errorcode;
	}

}
