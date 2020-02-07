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
		JLabel welcome=new JLabel("Welcome to Main , Select you choice");
		JButton goToGamePlayer= new JButton("Player vs Player");
		JButton goToGameHighscore=  new JButton("Score");
		JButton gotoloadgame=  new JButton("Load Game");
		JButton exit= new JButton("Avsluta"); 
		
		welcome.setFont(new Font("Helvetica", Font.PLAIN,60));
		welcome.setAlignmentX(Component.CENTER_ALIGNMENT);
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
