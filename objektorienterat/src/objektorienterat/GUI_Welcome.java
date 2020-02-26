package src.objektorienterat;



import java.awt.Color;

import java.awt.Dimension;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.JOptionPane;

/*
 *
 * Welcome screen: responsibility is to display the mainMenu screen and its textfields
 * extends displayScreen, which its only purpose is the create a common baseline for the design, and be able to swap to other screens
 *
 */
public class GUI_Welcome extends DisplayScreen {
	private static final long serialVersionUID = 1L;
	Player currentUser;
	LayoutManager layoutManager;
	ScoreManager scoremanager;
	GUI_Welcome(SwappableScreen layoutManager, Player currentUser, ScoreManager scoremanager){

		super(layoutManager);
		this.currentUser=currentUser;
		this.scoremanager=scoremanager;
		JPanel buttonPanel=new JPanel();
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
		buttonPanel.setBackground(this.getBackground());

		JLabel treirad= new JLabel("Tre i rad");
		JLabel username= new JLabel("Enter your username: ");
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


		text.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try{
					StringInputChecker s= new StringInputChecker();
					String username = s.Check(text.getText());
					currentUser.setUsername(username);
					scoremanager.updateScorePlayer(); 
					System.out.print(currentUser.getGamesWon());
					layoutManager.swap(LayoutManager.MENUPANEL);
				} catch (StringEmptyException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null,"Please insert a nonempty String"," ****************** ERROR *****************",JOptionPane.ERROR_MESSAGE);
				}

			}											

		});
		add(buttonPanel);

	}
	public void setCurrentUser(Player user) {
		this.currentUser= user;
	}

}
