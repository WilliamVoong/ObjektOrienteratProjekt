package src.objektorienterat;
import java.awt.BorderLayout;



import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.GridBagConstraints;




/*
<<<<<<< HEAD
 *
 * Welcome screen: responsibility is to display the Stats screen and its textfields
 * extends displayScreen, which its only purpose is the create a common baseline for the design, and be able to swap to other screens
 *
=======
 * 
 * Welcome screen: responsibility is to display the Stats screen and its textfields
 * extends displayScreen, which its only purpose is the create a common baseline for the design, and be able to swap to other screens
 * 
>>>>>>> c74f384db83641e3d5c38d9ee6c9487be56b5392
 */
public class GUI_Stats extends DisplayScreen {
	Stats stats;
	JPanel mainPanel= new JPanel();
	SwappableScreen screenswapper= new LayoutManagerStats();
	final static int SCOREPANEL_WIDTH=600;
	final static int SCOREPANEL_SPACING=10;

	GUI_Stats(LayoutManager manager, Stats stats){
		super(manager);
		this.stats=stats;
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));


		JLabel scoreText=new JLabel("Score");
		scoreText.setForeground(Color.WHITE);
		scoreText.setFont(new Font("Helvetica", Font.PLAIN,60));
		scoreText.setAlignmentX(Component.CENTER_ALIGNMENT);
		scoreText.setBackground(Color.black);
		JButton backToMenu= new JButton("Go Back To Menu");
		backToMenu.setUI(new StyledButtonUI());



		JPanel holderPanel= new JPanel();
		holderPanel.setLayout(new BoxLayout(holderPanel,BoxLayout.Y_AXIS));
		holderPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

		holderPanel.add(scoreText);
		ScorePanel(holderPanel);
		ButtonPanel(holderPanel);
		backToMenu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				layoutManager.swap(LayoutManager.MENUPANEL);
			}
		});


		holderPanel.setPreferredSize(new Dimension(500,500));
		holderPanel.setBackground(Color.black);
		add(Box.createHorizontalGlue());
		add(holderPanel);
		add(Box.createRigidArea(new Dimension(100,100)));
		add(backToMenu);
		add(Box.createHorizontalGlue());






	}
	private void ScorePanel(JPanel paneltoTo) {
		JPanel scorePanel=new JPanel();
		scorePanel.setBackground(Color.black);
		scorePanel.setAlignmentX(CENTER_ALIGNMENT);
		scorePanel.setLayout(new BoxLayout(scorePanel,BoxLayout.Y_AXIS));
		scorePanel= screenswapper.getCards();
		scorePanel.setMaximumSize((new Dimension(600,500)));;

		for(int i =0 ; i < 10; i++) {
			JPanel score= new JPanel();
			score.setBackground(new Color(0x00AAF0CD) );
			score.setLayout(new BoxLayout(score,BoxLayout.Y_AXIS));
			LabelForScore(score);
			for(int j =0 ; j < 10; j++) {
				JLabel s= new JLabel("example score " + j+i);
				s.setAlignmentX(Component.CENTER_ALIGNMENT);
				score.add(s);
			}
			Integer a= i;
			screenswapper.addNewScreen(score, a.toString());
		}

		paneltoTo.add(scorePanel);

	}
	private void ButtonPanel(JPanel paneltoTo) {
		JPanel buttonPanel=new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));

		JButton prev= new JButton(" < ");
		JButton next= new JButton(" > ");
		next.setUI(new StyledButtonUI());
		prev.setUI(new StyledButtonUI());

		prev.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				CardLayout c1= (CardLayout) (screenswapper.getCards().getLayout());
				c1.previous(screenswapper.getCards());

			}

		});
		next.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				CardLayout c1= (CardLayout) (screenswapper.getCards().getLayout());
				c1.next(screenswapper.getCards());
			}

		});
		buttonPanel.add(prev);
		buttonPanel.add(next);
		paneltoTo.add(buttonPanel);
	}

	/*	NOT DONE!!!!!!!!!!!!!!
	 * creates panel for every 10 stats added to the screen.
	 *  TODOOOO
	 */
	private void Stats(JPanel paneltoTo)
	{

			JPanel scorePanel=new JPanel();	
			scorePanel.setBackground(Color.black);
			scorePanel.setAlignmentX(CENTER_ALIGNMENT);
			scorePanel.setLayout(new BoxLayout(scorePanel,BoxLayout.Y_AXIS));
			scorePanel= screenswapper.getCards(); 
			scorePanel.setMaximumSize((new Dimension(600,500)));;
	    
			
			int counter=1; 
			int numberOfPlayersToDrawOnEachPanel=13; 
			Map<String, Player> listOfPlayers=stats.getPlayersSort(Stats.SORTBYGAMESWON);
			
			JPanel score= new JPanel();
			score.setLayout(new BoxLayout(score, BoxLayout.Y_AXIS));
			score.setAlignmentX(CENTER_ALIGNMENT);
			score.setBackground(new Color(0x00AAF0CD) );
			
			for(String username : listOfPlayers.keySet()) {
				Player p=listOfPlayers.get(username);
				if(counter > numberOfPlayersToDrawOnEachPanel) {
					score= new JPanel();	
					screenswapper.addNewScreen(score, p.toString());
				}else { 	
						JLabel s= new JLabel("example score");
						s.setAlignmentX(Component.CENTER_ALIGNMENT);
						score.add(s);
				}
	
			}
		paneltoTo.add(scorePanel);
	}
		
	private void LabelForScore(JPanel paneltoTo){
		JPanel labelPanel= new JPanel();
	
		labelPanel.setBackground(Color.white);
		labelPanel.setMaximumSize((new Dimension(600,50)));;
		labelPanel.setLayout(new GridLayout(1,5)); 
		labelPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		List<JLabel> labels= new ArrayList<JLabel>();
		labels.add(new JLabel(" User "));
		labels.add(new JLabel(" # Games "));
		labels.add(new JLabel(" Losts "));
		labels.add(new JLabel(" Wins "));
		labels.add(new JLabel(" Draws "));

		for(JLabel label: labels) {
			//label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			label.setFont(new Font("Helvetica", Font.PLAIN,20));
			label.setBorder(new LineBorder(Color.BLACK));
			label.setAlignmentX(Component.CENTER_ALIGNMENT);

			labelPanel.add(label,CENTER_ALIGNMENT);
			//labelPanel.add(Box.createRigidArea(new Dimension(SCOREPANEL_SPACING,SCOREPANEL_SPACING)));

		}
		paneltoTo.add(labelPanel);

	}
}




