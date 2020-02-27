package src.objektorienterat;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ScreenButton extends JButton {
	private static final long serialVersionUID = 1L;

	ScreenButton(String text, DisplayScreen panel) {
		super(text);
		setVisible(true);

	}

	public void SwapPanel(JFrame mainWindow) {
		mainWindow.removeAll();
		mainWindow.validate();
	}



}
