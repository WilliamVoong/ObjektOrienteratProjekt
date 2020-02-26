package src.objektorienterat;

import javax.swing.*;
import java.util.*;
import java.util.List;
import java.awt.event.*;
import java.awt.*;
/*
 *
 * Main Menu screen: responsibility is to display the mainMenu
 * extends displayScreen, which its only purpose is the create a common baseline for the design, and be able to swap to other screens
 *
 */

public class GUI_MainMenu extends DisplayScreen {

	private static final long serialVersionUID = 1L;

	private FileHandler filehandler;
	private GameAdmin gameAdmin;
	private List<JButton> buttons;


	GUI_MainMenu(SwappableScreen layoutManager ,  FileHandler filehandler, GameAdmin gameAdmin) {

		super(layoutManager);
		this.filehandler=filehandler;
		this.gameAdmin=gameAdmin;
		buttons= new ArrayList<JButton>();
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		JButton changeUser=  new JButton("Change user");
		JButton goToGamePVC= new JButton("Player vs AI");
		JButton goToGamePVP= new JButton("Player vs Player");
		JButton goToGameHighscore=  new JButton("Score");
		JButton gotoloadgame=  new JButton("Load GameModel");
		JButton exit= new JButton("Avsluta");
		JLabel welcome=new JLabel(" Welcome to the game");
		buttons.add(goToGamePVC);
		buttons.add(goToGamePVP);
		buttons.add(goToGameHighscore);
		buttons.add(gotoloadgame);
		buttons.add(changeUser);
		buttons.add(exit);
		welcome.setFont(new Font("Helvetica", Font.PLAIN,60));
		welcome.setAlignmentX(Component.CENTER_ALIGNMENT);
		welcome.setForeground(Color.white);
		welcome.setFont(new Font("Helvetica", Font.PLAIN,40));
		welcome.setAlignmentX(Component.CENTER_ALIGNMENT);

		add(Box.createRigidArea(new Dimension(0,100)));
		add(welcome);

		for(JButton button: buttons) {
			setStyle(button);
			addToPanelWithVerticalAlignment(button,50);
		}
		changeUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layoutManager.swap(LayoutManager.WELCOMEPANEL);
			}

		});


		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}

		});

		goToGamePVC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameAdmin.newGamePVC(false);
				System.out.println("Currently Player 1: " + gameAdmin.getCurrentUser().getUsername());
				layoutManager.swap(LayoutManager.GAMEPANEL);
			}

		});
		goToGameHighscore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layoutManager.swap(LayoutManager.HIGHSCOREPANEL);
			}

		});
		goToGamePVP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StringInputChecker checker= new StringInputChecker();
				try {

					String p2name = checker.Check(JOptionPane.showInputDialog(null,"Insert the username of p2"));
					gameAdmin.newGamePVP(p2name, false);
					layoutManager.swap(LayoutManager.GAMEPANEL);
				}catch (StringEmptyException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null,"Please insert a nonempty String"," ****************** ERROR *****************",JOptionPane.ERROR_MESSAGE);
				}
				catch (NullPointerException e1) {
					System.out.println("user pressed cancel or pressed x in the windowFrame");
				}

			}

		});

		gotoloadgame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

                // i created loadgame in game model to avoid that AI starting playing alwyays after loading
				//because after loading it is always user turn so i dont need to do random in this way , so when i creates new game the paramter in
				//gameinit false to let random process and when it is loading it is True.
 				try
				{GameModel temp=filehandler.Load(gameAdmin.getCurrentUser());
				gameAdmin.loadgame(temp);
					layoutManager.swap(LayoutManager.GAMEPANEL);
				/*	gameAdmin.getModel().setMarks(temp.getMarks());
					gameAdmin.getModel().setMarkCount(temp.getMarkCount());
					gameAdmin.getModel().setLastMove(temp.getLastMove());
					//gameAdmin.newGame(GameAdmin.PVC);
					gameAdmin.getModel().gameInit(true);
					layoutManager.swap(LayoutManager.GAMEPANEL);*/

				}catch (NullPointerException ex)
				{
					Sound_effect.playSound("WS.wav");
					JOptionPane.showMessageDialog(null,"OBS! There is no Data saved for this player name !!"," ****************** ERROR *****************",JOptionPane.ERROR_MESSAGE);


				}
			}
		});




	}
	/* Function
	 * Centralizes button and create natural spacing between them;
	 *
	 */
	private void addToPanelWithVerticalAlignment(JButton c, int verticalAlignment){
		c.setMaximumSize(new Dimension(150,50));
		c.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(Box.createRigidArea(new Dimension(0,verticalAlignment)));
		add(c);
	}

	/*
<<<<<<< HEAD
	 *
=======
	 * 
>>>>>>> c74f384db83641e3d5c38d9ee6c9487be56b5392
	 * Stylizes the button	and sets the size of the buttons
	 */
	private void setStyle(JButton button){
		button.setPreferredSize(new Dimension(200, 200));
		button.setUI(new StyledButtonUI());

	}
	


}
