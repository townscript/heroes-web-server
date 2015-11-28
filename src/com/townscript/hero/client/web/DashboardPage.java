package com.townscript.hero.client.web;

import java.util.Comparator;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.ColumnSortEvent.ListHandler;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.ListDataProvider;
import com.townscript.hero.shared.transaction.TransactionDetailsDTO;

public class DashboardPage extends Composite {

	private static DashboardPageUiBinder uiBinder = GWT
			.create(DashboardPageUiBinder.class);

	interface DashboardPageUiBinder extends UiBinder<Widget, DashboardPage> {
	}

	@UiField CellTable<TransactionDetailsDTO> table;

	public DashboardPage() {
		initWidget(uiBinder.createAndBindUi(this));

		
		// Create name column.
		TextColumn<TransactionDetailsDTO> nameColumn = new TextColumn<TransactionDetailsDTO>() {
			@Override
			public String getValue(TransactionDetailsDTO txn) {
				return txn.getUserName();
			}
		};
		
		table.addColumn(nameColumn, "Name");

		TextColumn<TransactionDetailsDTO> emailColumn = new TextColumn<TransactionDetailsDTO>() {
			@Override
			public String getValue(TransactionDetailsDTO txn) {
				return txn.getUserEmailId();
			}
		};
		
		table.addColumn(emailColumn, "Email Id");
		// Create a data provider.
	    ListDataProvider<TransactionDetailsDTO> dataProvider = new ListDataProvider<TransactionDetailsDTO>();
	    

		// Connect the table to the data provider.
		dataProvider.addDataDisplay(table);
		    
	    // Add the data to the data provider, which automatically pushes it to the
	    // widget.
	    List<TransactionDetailsDTO> list = dataProvider.getList();
	    for(int i=0; i< 10; i++){
		    TransactionDetailsDTO txn = new TransactionDetailsDTO();
		    txn.setUserName("Sushant Pawar");
		    txn.setUserEmailId("sushant@townscript.com");
		    
		    list.add(txn);
	    }
	    
	    // Add a ColumnSortEvent.ListHandler to connect sorting to the
	    // java.util.List.
	    ListHandler<TransactionDetailsDTO> columnSortHandler = new ListHandler<TransactionDetailsDTO>(
	        list);
	    columnSortHandler.setComparator(nameColumn,
	        new Comparator<TransactionDetailsDTO>() {
	          public int compare(TransactionDetailsDTO o1, TransactionDetailsDTO o2) {
	            if (o1 == o2) {
	              return 0;
	            }

	            // Compare the name columns.
	            if (o1 != null) {
	              return (o2 != null) ? o1.getUserName().compareTo(o2.getUserName()) : 1;
	            }
	            return -1;
	          }
	        });
	    table.addColumnSortHandler(columnSortHandler);

	    // We know that the data is sorted alphabetically by default.
	    table.getColumnSortList().push(nameColumn);
	    
	}

	public static DashboardPage getInstance() {
		return new DashboardPage();
	}
}
