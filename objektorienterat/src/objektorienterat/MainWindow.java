package src.objektorienterat;


import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
/*
 * MainWindow has the responsiblity to display the main screen. 
 */
public class MainWindow extends JFrame {
	private DisplayScreen currentlyDisplayed;

	MainWindow() {
		super();
		setVisible(true);
		LayoutManager manager= new LayoutManager(); 
		manager.addComponentToPane(getContentPane());
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


}
