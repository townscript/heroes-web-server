package com.townscript.hero.client.web;

import java.util.List;

import com.google.gwt.cell.client.ButtonCell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.ListDataProvider;
import com.townscript.hero.client.service.GreetingService;
import com.townscript.hero.client.service.GreetingServiceAsync;
import com.townscript.hero.client.web.Modal.OkayCallback;
import com.townscript.hero.shared.application.ApplicationDataDTO;

public class DashboardPage extends Composite {

	private static DashboardPageUiBinder uiBinder = GWT
			.create(DashboardPageUiBinder.class);

	interface DashboardPageUiBinder extends UiBinder<Widget, DashboardPage> {
	}

	@UiField CellTable<ApplicationDataDTO> table;
	@UiField org.gwtbootstrap3.client.ui.Button addNew;


	// Create a data provider.
    private ListDataProvider<ApplicationDataDTO> dataProvider = new ListDataProvider<ApplicationDataDTO>();
    
	@SuppressWarnings("unchecked")
	public DashboardPage() {
		initWidget(uiBinder.createAndBindUi(this));

		final Button temp = new Button();
		temp.getElement().setAttribute("data-target", "#myModal");
		temp.getElement().setAttribute("data-toggle", "modal");
		temp.setVisible(false);
		RootPanel.get().add(temp);
		
		// Create name column.
		TextColumn<ApplicationDataDTO> nameColumn = new TextColumn<ApplicationDataDTO>() {
			@Override
			public String getValue(ApplicationDataDTO txn) {
				return txn.getTokenId();
			}
		};
		
		table.addColumn(nameColumn, "App Name");

		TextColumn<ApplicationDataDTO> emailColumn = new TextColumn<ApplicationDataDTO>() {
			@Override
			public String getValue(ApplicationDataDTO txn) {
				return txn.getSuccessUrl();
			}
		};
		
		table.addColumn(emailColumn, "Success Url");
		
		ButtonCell buttonCell = new ButtonCell();
		
		Column buttonColumn = new Column<ApplicationDataDTO, String>(buttonCell) {
		  @Override
		  public String getValue(ApplicationDataDTO object) {
		    return "Edit";
		  }
		};
		table.addColumn(buttonColumn, "Action");
		
		buttonColumn.setFieldUpdater(new FieldUpdater<ApplicationDataDTO, String>() {
			public void update(int index, ApplicationDataDTO object, String value) {
				
				clickElement(temp.getElement());
				ModalFactory.getInstance().clearBody();
				final ApplicationLayout layout = new ApplicationLayout(object);
				
				ModalFactory.getInstance().addBody(layout);
				ModalFactory.getInstance().setCallBack(new OkayCallback() {
					
					@Override
					public void onOkay() {
						GreetingServiceAsync service = (GreetingServiceAsync)GWT.create(GreetingService.class);
					    ServiceDefTarget serviceDef = (ServiceDefTarget) service;
					    serviceDef.setServiceEntryPoint(GWT.getModuleBaseURL()
					    		+ "greet");
					    service.updateApplicationData(layout.getApplicationForm(), new AsyncCallback<Integer>() {
							
							@Override
							public void onSuccess(Integer result) {
								
							}
							
							@Override
							public void onFailure(Throwable caught) {
								Window.alert(caught.getMessage());
							}
						});
					    
					}
				});
//				temp.removeFromParent();
			}
		});	    

	    GreetingServiceAsync service = (GreetingServiceAsync)GWT.create(GreetingService.class);
	    ServiceDefTarget serviceDef = (ServiceDefTarget) service;
	    serviceDef.setServiceEntryPoint(GWT.getModuleBaseURL()
	    		+ "greet");
	    
	    service.loadAllApplicationDataDTOs(new AsyncCallback<List<ApplicationDataDTO>>() {
			
			@Override
			public void onSuccess(List<ApplicationDataDTO> result) {
				// Add the data to the data provider, which automatically pushes it to the
			    // widget.
			    List<ApplicationDataDTO> list = dataProvider.getList();
			    list.clear();
			    list.addAll(result);
			}
			
			@Override
			public void onFailure(Throwable caught) {
				Window.alert(caught.getMessage());
			}
		});
	    

		// Connect the table to the data provider.
		dataProvider.addDataDisplay(table);
		    
	    
	}
	
	@UiHandler("addNew")
	void onNewClick(ClickEvent event) {
		ModalFactory.getInstance().clearBody();
		final ApplicationLayout layout = new ApplicationLayout();
		ModalFactory.getInstance().addBody(layout);
		ModalFactory.getInstance().setCallBack(new OkayCallback() {
			
			@Override
			public void onOkay() {
				GreetingServiceAsync service = (GreetingServiceAsync)GWT.create(GreetingService.class);
			    ServiceDefTarget serviceDef = (ServiceDefTarget) service;
			    serviceDef.setServiceEntryPoint(GWT.getModuleBaseURL()
			    		+ "greet");
			    
			    service.addApplicationData(layout.getApplicationForm(), new AsyncCallback<Integer>() {
					
					@Override
					public void onSuccess(Integer result) {
						ApplicationDataDTO app = layout.getApplicationForm();
						app.setAppId(result);
						
						List<ApplicationDataDTO> list = dataProvider.getList();
					    list.add(app);
					}
					
					@Override
					public void onFailure(Throwable caught) {
						Window.alert(caught.getMessage());
					}
				});
			}
		});
	}

	public static native void clickElement(Element elem) /*-{
	    elem.click();
	}-*/;
	
	public static DashboardPage getInstance() {
		return new DashboardPage();
	}
}
