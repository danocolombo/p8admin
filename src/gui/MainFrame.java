package gui;
// gui/MainFrame.java
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import controller.Controller;

public class MainFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Controller controller;
	public MainFrame() {
		controller = new Controller();
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mnFile.add(mntmExit);
		
		JMenu mnHosts = new JMenu("Hosts");
		menuBar.add(mnHosts);
		
		JMenuItem mntmList = new JMenuItem("List");
		mntmList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				new HostList();
			}
		});
		mnHosts.add(mntmList);
		
		JMenuItem mntmNew = new JMenuItem("New");
		mnHosts.add(mntmNew);
		
		JMenu mnEvents = new JMenu("Events");
		menuBar.add(mnEvents);
		
		JMenuItem mntmList_1 = new JMenuItem("List");
		mnEvents.add(mntmList_1);
		
		JMenuItem mntmNew_1 = new JMenuItem("New");
		mnEvents.add(mntmNew_1);
		
		setMinimumSize(new Dimension(500, 400));
		setSize(600, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

}
