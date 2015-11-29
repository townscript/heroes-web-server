package com.townscript.hero.client.web;

import java.util.Comparator;
import java.util.List;

import org.gwtbootstrap3.client.ui.Paragraph;

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
import com.google.gwt.user.cellview.client.ColumnSortEvent.ListHandler;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.ListDataProvider;
import com.townscript.hero.shared.application.ApplicationDataDTO;

public class DashboardPage extends Composite {

	private static DashboardPageUiBinder uiBinder = GWT
			.create(DashboardPageUiBinder.class);

	interface DashboardPageUiBinder extends UiBinder<Widget, DashboardPage> {
	}

	@UiField CellTable<ApplicationDataDTO> table;
	@UiField org.gwtbootstrap3.client.ui.Button addNew;

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
				ApplicationLayout layout = new ApplicationLayout();
				ModalFactory.getInstance().addBody(layout);
//				temp.removeFromParent();
			}
		});
		
		// Create a data provider.
	    ListDataProvider<ApplicationDataDTO> dataProvider = new ListDataProvider<ApplicationDataDTO>();
	    

		// Connect the table to the data provider.
		dataProvider.addDataDisplay(table);
		    
	    // Add the data to the data provider, which automatically pushes it to the
	    // widget.
	    List<ApplicationDataDTO> list = dataProvider.getList();
	    for(int i=0; i< 10; i++){
		    ApplicationDataDTO txn = new ApplicationDataDTO();
		    txn.setTokenId("Barclays Fresh Store");
		    txn.setSuccessUrl("http://example.com");
		    
		    list.add(txn);
	    }
	    
	    // Add a ColumnSortEvent.ListHandler to connect sorting to the
	    // java.util.List.
	    ListHandler<ApplicationDataDTO> columnSortHandler = new ListHandler<ApplicationDataDTO>(
	        list);
	    columnSortHandler.setComparator(nameColumn,
	        new Comparator<ApplicationDataDTO>() {
	          public int compare(ApplicationDataDTO o1, ApplicationDataDTO o2) {
	            if (o1 == o2) {
	              return 0;
	            }

	            // Compare the name columns.
	            if (o1 != null) {
	              return (o2 != null) ? o1.getTokenId().compareTo(o2.getTokenId()) : 1;
	            }
	            return -1;
	          }
	        });
	    table.addColumnSortHandler(columnSortHandler);

	    // We know that the data is sorted alphabetically by default.
	    table.getColumnSortList().push(nameColumn);
	    
	}
	
	@UiHandler("addNew")
	void onNewClick(ClickEvent event) {
		ModalFactory.getInstance().clearBody();
		ApplicationLayout layout = new ApplicationLayout();
		ModalFactory.getInstance().addBody(layout);
	}

	public static native void clickElement(Element elem) /*-{
	    elem.click();
	}-*/;
	
	public static DashboardPage getInstance() {
		return new DashboardPage();
	}
}
