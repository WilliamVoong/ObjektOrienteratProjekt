package src.objektorienterat;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class ScreenButton extends JButton{
	private JPanel panel= new JPanel();
	
	ScreenButton(String text, DisplayScreen panel){
		super(text); 

		this.panel=panel;
		setVisible(true);
	}
	
	public void SwapPanel(JFrame mainWindow){
		mainWindow.removeAll();
		mainWindow.add(panel);
		mainWindow.validate();
	}
	

}
