package src.objektorienterat;


import java.io.IOException;

import javax.swing.*;

/*
 * MainWindow has the responsiblity to display the main screen. 
 */
public class MainWindow extends JFrame {
	private DisplayScreen currentlyDisplayed;

	MainWindow() throws Exception {
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
				try{
					GameController.save_game("Save_Gui15");
					GameController.save_game_model("Save_model15");

				}catch (IOException ex)
				{
					System.out.println(ex);
				}

				JOptionPane.showMessageDialog(null,"saving","saving",JOptionPane.INFORMATION_MESSAGE);
				e.getWindow().dispose();
				System.out.println("JFrame Closed!");
				System.exit(0);
			}
		});

	}


}
