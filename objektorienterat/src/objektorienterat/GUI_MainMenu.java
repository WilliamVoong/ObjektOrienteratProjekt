package src.objektorienterat;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.border.Border;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import java.awt.*;
/*
 * 
 * Main Menu screen: responsibility is to display the mainmenu
 * 
 * 
 */

public class GUI_MainMenu extends DisplayScreen {
	GameController controller;
	GUI_MainMenu(SwappableScreen layoutManager) {
		super(layoutManager);
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JButton goToGame= new JButton("Player vs AI");
		JButton goToGamePlayer= new JButton("Player vs Player");
		JButton goToGameHighscore=  new JButton("Score");
		JButton gotoloadgame=  new JButton("Load GameModel");
		JButton exit= new JButton("Avsluta");
		JLabel welcome=new JLabel("Všlkommen till huvudmenyn"); 
	
	
		welcome.setFont(new Font("Helvetica", Font.PLAIN,60));
		welcome.setAlignmentX(Component.CENTER_ALIGNMENT);
		welcome.setForeground(Color.white);
		welcome.setFont(new Font("Helvetica", Font.PLAIN,40));
		welcome.setAlignmentX(Component.CENTER_ALIGNMENT);

		

		setStyle(goToGame);
		setStyle(goToGamePlayer);
		setStyle(goToGameHighscore);
		setStyle(gotoloadgame);
		setStyle(exit);

		
		add(Box.createRigidArea(new Dimension(0,100)));
		add(welcome);
		
		goToGame.setMaximumSize(new Dimension(100,50));
		addWithVerticalAlignment(goToGame,50);
		addWithVerticalAlignment(goToGameHighscore,50);
		addWithVerticalAlignment(goToGamePlayer,50);
		addWithVerticalAlignment(exit,50);

		
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
			
		});
		
		goToGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// controller.clearGame(); -> TODO
				layoutManager.swap(LayoutManager.GAMEPANEL);
			}
			
		});
		goToGameHighscore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layoutManager.swap(LayoutManager.HIGHSCOREPANEL);
			}
			
		});
		
		goToGamePlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// controller.clearGame(); -> TODO
				layoutManager.swap(LayoutManager.GAMEPANEL);
			}
			
		});
		
		
		

	}
	/* Function
	 * Centralizes button and create natural spacing between them;
	 * 
	 */
	public void addWithVerticalAlignment(JButton c, int verticalAlignment){
		c.setMaximumSize(new Dimension(150,50));
		c.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(Box.createRigidArea(new Dimension(0,verticalAlignment)));
		add(c);
	}

	/*
	 * 
	 * Stylizes the button	
	 */
	public void setStyle(JButton button){
		button.setFont(new Font("Calibri", Font.PLAIN, 20));
		button.setBackground(new Color(0x788BCE));
		button.setForeground(Color.white);
		button.setPreferredSize(new Dimension(200, 200));
		button.setUI(new StyledButtonUI());

	}

}
