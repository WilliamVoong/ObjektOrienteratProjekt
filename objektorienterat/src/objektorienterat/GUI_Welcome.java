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
		JPanel buttonPanel=new JPanel();
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); 
		
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
		buttonPanel.setBackground(this.getBackground());
		
		JLabel treirad= new JLabel("Tre i rad");
		JLabel username= new JLabel("Enter your username:   "); 
		treirad.setForeground(Color.WHITE);
		username.setForeground(Color.WHITE);
		
		JTextField text = new JTextField(10);
		
		treirad.setFont(new Font("Helvetica", Font.PLAIN,60));
		text.setMaximumSize(new Dimension(130,30));
		treirad.setAlignmentX(CENTER_ALIGNMENT);
		buttonPanel.setAlignmentX(CENTER_ALIGNMENT);
		
		add(Box.createRigidArea(new Dimension(0,300)));
		add(treirad);
		add(Box.createRigidArea(new Dimension(0,30)));
		
		buttonPanel.add(username);
		buttonPanel.add(text);
		setVisible(true);
		setPreferredSize(new Dimension(300, 300));
		
		
	
		/*button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				layoutManager.swap(LayoutManager.MENUPANEL);
				
			}

		});*/
		//add(button);
		text.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(text.getText());
				layoutManager.swap(LayoutManager.MENUPANEL);
			}

		});
		add(buttonPanel);

	}
}
