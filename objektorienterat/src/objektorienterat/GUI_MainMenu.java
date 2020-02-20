package src.objektorienterat;

import javax.swing.border.Border;
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
				gameAdmin.newGame(GameAdmin.PVC);
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

					String playerName = checker.Check(JOptionPane.showInputDialog(null,"Insert the username of p2"));
					gameAdmin.setPlayer2(new Player(playerName,0,0,0));
					layoutManager.swap(LayoutManager.GAMEPANEL);

				}catch (StringEmptyException e1) {
					// TODO Auto-generated catch block
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


/*				GameModel temp=filehandler.Load(gameAdmin.getCurrentUser());
				GameView temp2=gameAdmin.getView();
				gameAdmin.setModel(temp);
				gameAdmin.getView().setModel(temp);
				gameAdmin.setCurrentUser((Player) temp.getCurrentlyPlaying());
				gameAdmin.newGame(GameAdmin.PVC);
				layoutManager.swap(LayoutManager.GAMEPANEL);*/

				GameModel temp=filehandler.Load(gameAdmin.getCurrentUser());
				gameAdmin.getModel().setMarks(temp.getMarks());
				gameAdmin.newGame(GameAdmin.PVC);
				layoutManager.swap(LayoutManager.GAMEPANEL);




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
	 *
	 * Stylizes the button	and sets the size of the buttons
	 */
	private void setStyle(JButton button){
		button.setPreferredSize(new Dimension(200, 200));
		button.setUI(new StyledButtonUI());

	}


}
