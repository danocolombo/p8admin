package gui;
// gui/HostTableModel.java
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;
import model.Host;

public class HostTableModel extends AbstractTableModel {

	/**
	 * 
	 */
	private ArrayList<Host> hList;
	//private String[] colNames = {"Church", "Address", "City", "State", "Zipcode", "Contact", "Email", "Phone"};
	private String[] colNames = {"Church", "Address","Contact", "Email", "Phone"};
	public HostTableModel() {
	
	}
	public void setData(ArrayList<Host> hList) {
		this.hList = hList;
	}
	private static final long serialVersionUID = 1L;

	@Override
	public String getColumnName(int column) {
		
		return colNames[column];
	}
	@Override
	public int getRowCount() {
		// the number of entries in the arraylist
		return hList.size();
	}

	@Override
	public int getColumnCount() {
		// identify the number of columns
//		return 8;
		return 5;
	}

	@Override
	public Object getValueAt(int row, int col) {
		// the data definition from the database.host definition
		String tmp;
		Host h = hList.get(row);
		switch(col) {
		case 0:
			return h.getChurchName();
		case 1:
			tmp = h.getChurchStreet() + " " + h.getChurchCity() + ", " + h.getChurchState() + " " + h.getChurchPostalCode();
			return tmp;
		case 2: 
			return h.getContactName();
		case 3:
			return h.getContactEmail();
		case 4:
			return h.getContactPhone();
		}
//		case 1:
//			return h.getChurchStreet();
//		case 2: 
//			return h.getChurchCity();
//		case 3:
//			return h.getChurchState();
//		case 4:
//			return h.getChurchPostalCode();
//		case 5:
//			return h.getContactName();
//		case 6:
//			return h.getContactEmail();
//		case 7:
//			return h.getContactPhone();
//		}
		// should never hit this because the column count above defines only 8 columns...
		return null;
	}

}
