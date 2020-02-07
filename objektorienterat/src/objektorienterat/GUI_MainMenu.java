package src.objektorienterat;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.border.Border;
import javax.swing.*;
import java.io.IOException;
import java.util.*;
import java.awt.event.*;
import java.awt.*;
public class GUI_MainMenu extends DisplayScreen {

	GUI_MainMenu(SwappableScreen layoutManager) {
		super(layoutManager);
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JButton goToGame= new JButton("Player vs AI");
		goToGame.setFont(new Font("Calibri", Font.PLAIN, 20));
		goToGame.setBackground(new Color(0x788BCE));
		goToGame.setForeground(Color.white);
		goToGame.setPreferredSize(new Dimension(200, 200));
		goToGame.setUI(new StyledButtonUI());
		JButton goToGamePlayer= new JButton("Player vs Player");
		goToGamePlayer.setFont(new Font("Calibri", Font.PLAIN, 20));
		goToGamePlayer.setBackground(new Color(0x788BCE));
		goToGamePlayer.setForeground(Color.white);
		goToGamePlayer.setPreferredSize(new Dimension(200, 200));
		goToGamePlayer.setUI(new StyledButtonUI());
		JButton goToGameHighscore=  new JButton("Score");
		goToGameHighscore.setFont(new Font("Calibri", Font.PLAIN, 20));
		goToGameHighscore.setBackground(new Color(0x788BCE));
		goToGameHighscore.setForeground(Color.white);
		goToGameHighscore.setPreferredSize(new Dimension(200, 200));
		goToGameHighscore.setUI(new StyledButtonUI());
		JButton gotoloadgame=  new JButton("Load GameModel");
		gotoloadgame.setFont(new Font("Calibri", Font.PLAIN, 20));
		gotoloadgame.setBackground(new Color(0x788BCE));
		gotoloadgame.setForeground(Color.white);
		gotoloadgame.setPreferredSize(new Dimension(200, 200));
		gotoloadgame.setUI(new StyledButtonUI());
		JButton exit= new JButton("Avsluta");
		JLabel welcome=new JLabel("Welcome to Main , Select you choice");
		welcome.setForeground(Color.white);
		welcome.setFont(new Font("Helvetica", Font.PLAIN,40));
		welcome.setAlignmentX(Component.CENTER_ALIGNMENT);
		setBackground(new Color(0xFB292952, true));
		add(Box.createRigidArea(new Dimension(0,100)));
		add(welcome);
		
		
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
			
		});
		goToGame.setMaximumSize(new Dimension(100,50));
		
		
		
		addWithVerticalAlignment(goToGame,50);
		addWithVerticalAlignment(goToGameHighscore,50);
		addWithVerticalAlignment(goToGamePlayer,50);
		addWithVerticalAlignment(gotoloadgame,50);
		addWithVerticalAlignment(exit,50);

		
		
		goToGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
				layoutManager.swap(LayoutManager.GAMEPANEL);
			}
			
		});

		gotoloadgame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {

				layoutManager.swap(LayoutManager.LOADGAME);

			}
		});
		
		
		

	}
	
	public void addWithVerticalAlignment(JButton c, int verticalAlignment){
		c.setMaximumSize(new Dimension(150,50));
		c.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(Box.createRigidArea(new Dimension(0,verticalAlignment)));
		add(c);
	}

}
