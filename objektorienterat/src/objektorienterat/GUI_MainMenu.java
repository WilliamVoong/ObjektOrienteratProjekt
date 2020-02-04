package src.objektorienterat;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;

public class GUI_MainMenu extends DisplayScreen {
	
	GUI_MainMenu(){
		super();
		add(new JLabel("V�lkommen till huvudmenyn"));
		setVisible(true);
		setPreferredSize(new Dimension(300,300));
		
	
	}

}
