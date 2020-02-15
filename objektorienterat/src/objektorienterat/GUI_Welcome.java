package src.objektorienterat;



import java.awt.Color;

import java.awt.Dimension;

import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.JOptionPane;

/*
 * 
 * The gui of the Welcomescreen. 
 * Has the responsiblity of the userinterface of the welcome screen. 
 * 
 */
public class GUI_Welcome extends DisplayScreen {
	Player currentlyPlaying;
	Stats stats; 
	LayoutManager layoutManager;
	
	GUI_Welcome(SwappableScreen layoutManager, Player currentlyPlayin, Stats stats){
		
		super(layoutManager);
		this.stats=stats;
		this.currentlyPlaying=currentlyPlaying;
		
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
				
				
				try{
					StringInputChecker s= new StringInputChecker();
					String username = s.Check(text.getText());
					boolean playerExists= stats.getPlayers().containsKey(username);
					if(playerExists) {
						Player Player2Play = stats.getPlayers().get(username);
					}else {
						Player Player2Play = new Player(username,0,0,0); 
						setCurrentlyPlaying(username);
						stats.getPlayers().put(username, new Player(username,0,0,0));
					}
					layoutManager.swap(LayoutManager.MENUPANEL);
					
				} catch (StringEmptyException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null,"Please insert a nonempty String"," ****************** ERROR *****************",JOptionPane.ERROR_MESSAGE);
					
				}
				
				
				
				
				//layoutManager.addNewScreen(new Gui_MainMenu(new Filehandler("filename",username)));
				 // meny �r f�rutbest�md, men m�ste best�ma en player. 
															//  d�remot skapa menypanel innan vi skriver in texten 
			}												//  men referensen 

		});
		add(buttonPanel);

	}
	public void setCurrentlyPlaying(String username){
		currentlyPlaying=	new Player(username,0,0,0); 
	}
}
