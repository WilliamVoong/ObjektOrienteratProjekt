package src.objektorienterat;



import java.awt.Color;

import java.awt.Dimension;

import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import java.awt.*;

public class GUI_Welcome extends DisplayScreen {

	/**
	 * 
	 */

	GUI_Welcome(SwappableScreen layoutManager) {
		super(layoutManager);
		add(new JLabel("Username:"));
		setVisible(true);
		setPreferredSize(new Dimension(300, 300));
		setBackground(Color.white);
		JTextField text = new JTextField(10);
		JButton button= new JButton("hej");
	
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.print("hej");
				layoutManager.swap(LayoutManager.MENUPANEL);
				
			}

		});
		add(button);
		text.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(text.getText());

			}

		});
		add(text);

	}
}
