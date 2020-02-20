package src.objektorienterat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ScreenButton extends JButton {



	ScreenButton(String text, DisplayScreen panel) {
		super(text);
		setVisible(true);

	}

	public void SwapPanel(JFrame mainWindow) {
		mainWindow.removeAll();
		mainWindow.validate();
	}



}
