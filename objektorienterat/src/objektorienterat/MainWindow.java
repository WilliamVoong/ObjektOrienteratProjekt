package src.objektorienterat;


import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/*
 * MainWindow has the responsiblity to display the main screen. 
 */
public class MainWindow extends JFrame {
	private DisplayScreen currentlyDisplayed;

	MainWindow()  {
		super();
		setVisible(true);
		
		LayoutManager manager= new LayoutManager(); 
		manager.addComponentToPane(getContentPane());
		pack();
		setSize(900,900);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent e){
				System.out.println("Uncomment following to open another window!");
				//MainPage m = new MainPage();
				//m.setVisible(true);
				JOptionPane.showMessageDialog(null,"saving","saving",JOptionPane.INFORMATION_MESSAGE);
				try {
					Game_Controller.Save_game();
				}catch (Exception ex)
				{
					System.out.println(ex);
				}
				e.getWindow().dispose();
				System.out.println("JFrame Closed!");
			}
		});
		try {
			FileHandler.load_game("test");
		}catch (Exception e)
		{

		}
	}


}
