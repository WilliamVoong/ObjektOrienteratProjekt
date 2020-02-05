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
		JPanel playerinput=new JPanel();
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); 
		playerinput.setLayout(new BoxLayout(playerinput, BoxLayout.Y_AXIS));
		
		JLabel treirad= new JLabel("Tre i rad");
		JLabel username= new JLabel("skriv in ditt spelarnamn"); 
		
		
		treirad.setFont(new Font("Helvetica", Font.PLAIN,60));
		treirad.setSize(new Dimension(200,200));
		add(treirad);
		add(new JLabel("Username:"));
		setVisible(true);
		setPreferredSize(new Dimension(300, 300));
		
		JTextField text = new JTextField(10);
		JButton button= new JButton("hej");
	
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
		add(text);

	}
}
