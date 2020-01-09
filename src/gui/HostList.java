package gui;
// HostList.java
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import controller.Controller;
import model.Host;
//import model.Database;
public class HostList extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable theTable;
	private HostTableModel hostModel;
	private JPopupMenu popup;
	private Controller controller;
	public HostList() {
		controller = new Controller();
		ArrayList<Host> host = new ArrayList<Host>();	
		host = controller.getHostArray();
		hostModel = new HostTableModel();
		
		for(Host h : host ) {
			System.out.println(h.getChurchName());
		}
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel titlePanel = new JPanel();
		getContentPane().add(titlePanel, BorderLayout.NORTH);
		
		JLabel lblHostList = new JLabel("Host List");
		titlePanel.add(lblHostList);
		
		JPanel buttonPanel = new JPanel();
		getContentPane().add(buttonPanel, BorderLayout.SOUTH);
		
		JButton btnNew = new JButton("New Host");
		buttonPanel.add(btnNew);
		
		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		//create table and associated model
		theTable = new JTable(hostModel);
		popup = new JPopupMenu();
		JMenuItem editEvent = new JMenuItem("Edit Host");
		popup.add(editEvent);
		JMenuItem viewEvent = new JMenuItem("View Event(s)");
		popup.add(viewEvent);
		JMenuItem deleteEvent = new JMenuItem("DELETE Host");
		popup.add(deleteEvent);
		theTable.addMouseListener(new MouseAdapter() {
			//this will trigger the right click in the table to display the popup menu
			public void mousePressed(MouseEvent e) {
				if(e.getButton() == MouseEvent.BUTTON3) {
					popup.show(theTable, e.getX(), e.getY());
				}
			}
			
		});
		
		scrollPane.setViewportView(theTable);
		this.setData(host);
		
		setMinimumSize(new Dimension(500, 400));
		setSize(600, 500);
		setLocationRelativeTo(getParent());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void setData(ArrayList<Host> hList) {
		hostModel.setData(hList);
		
	}
	public void refresh() {
		hostModel.fireTableDataChanged();
	}

}
