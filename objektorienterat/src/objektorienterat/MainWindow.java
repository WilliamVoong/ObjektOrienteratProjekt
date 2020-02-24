package src.objektorienterat;

import javax.swing.*;

/*
 * MainWindow has the responsiblity to display the main screen.
 */
public class MainWindow extends JFrame implements Runnable {
	private static final long serialVersionUID = 1L;
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
				System.exit(0);
			}
		});
	}


}
