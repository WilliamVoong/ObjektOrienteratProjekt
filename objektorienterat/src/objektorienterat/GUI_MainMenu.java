package src.objektorienterat;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import java.awt.*;
public class GUI_MainMenu extends DisplayScreen {

	GUI_MainMenu(SwappableScreen layoutManager) {
		super(layoutManager);
		add(new JLabel("Välkommen till huvudmenyn"));
		setVisible(true);
		setPreferredSize(new Dimension(300, 300));
		JButton goToGame= new JButton();
		goToGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layoutManager.swap(LayoutManager.GAMEPANEL);
			}
			
		});
		add(goToGame);

	}

}
