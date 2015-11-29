package com.townscript.hero.client.web;

import org.gwtbootstrap3.client.ui.Button;
import org.gwtbootstrap3.client.ui.ModalBody;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class Modal extends Composite {

	private static ModalUiBinder uiBinder = GWT.create(ModalUiBinder.class);

	interface ModalUiBinder extends UiBinder<Widget, Modal> {
	}
	
	public interface OkayCallback {
		void onOkay();
	}
	
	private OkayCallback callback;

	@UiField ModalBody body;
	
	@UiField Button ok, close;
	
	public Modal() {
		initWidget(uiBinder.createAndBindUi(this));
		ok.getElement().setAttribute("data-dismiss", "modal");
		close.getElement().setAttribute("data-dismiss", "modal");
	}
	
	public void clearBody() {
		body.clear();
	}
	
	public void setCallBack(OkayCallback callback) {
		this.callback = callback;
	}
	
	public void addBody(Widget w) {
		body.add(w);
	}
	
	@UiHandler("ok")
	void onOkClick(ClickEvent event) {
		if (callback != null) {
			callback.onOkay();
		}
	}

}
