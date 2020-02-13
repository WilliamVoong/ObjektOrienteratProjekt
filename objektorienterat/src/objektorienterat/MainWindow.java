package src.objektorienterat;


import java.io.IOException;

import javax.swing.*;

/*
 * MainWindow has the responsiblity to display the main screen. 
 */
public class MainWindow extends JFrame implements Runnable {
	private LayoutManager screenSwapper;
	MainWindow(LayoutManager screenSwapper){
		super();
		this.screenSwapper= screenSwapper;
	}

	@Override
	public void run() {
	
		setVisible(true);
		screenSwapper.addComponentToPane(getContentPane());
		pack();
		setSize(900,900);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent e){
				System.out.println("Uncomment following to open another window!");
				//MainPage m = new MainPage();
				//m.setVisible(true);
				//GameController.save_game("Save_Gui16");
				//GameController.save_game_model("Save_model16");
				JOptionPane.showMessageDialog(null,"saving","saving",JOptionPane.INFORMATION_MESSAGE);
				e.getWindow().dispose();
				System.out.println("JFrame Closed!");
				System.exit(0);
			}
		});
	}


}
