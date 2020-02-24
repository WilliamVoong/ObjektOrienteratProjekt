package src.objektorienterat;

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
import javax.swing.border.LineBorder;

import java.awt.GridLayout;

/*
 *
 * Stats screen: responsibility is to display the Stats screen and its textfields
 * extends displayScreen, which its only purpose is the create a common baseline for the design, and be able to swap to other screens
 *
 */
public class GUI_Stats extends DisplayScreen {
	private static final long serialVersionUID = 1L;
	Stats stats; 
	SwappableScreen screenswapper= new LayoutManagerStats(); 
	final static int SCOREPANEL_WIDTH=600;
	final static int SCOREPANEL_SPACING=10;
	JPanel panelPlacement= new JPanel();
	JPanel panelUser= new JPanel();
	JPanel panelWins= new JPanel();
	JPanel panelLost= new JPanel();
	JPanel panelNoGames= new JPanel();
	JPanel panelDraws= new JPanel();
	

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
	
	
	private void createItemsPanel(JPanel panelToDisplayTo) {
		JPanel panelHolderItems= new JPanel();
		List<JPanel> list= new ArrayList<JPanel>();
		panelHolderItems.setLayout(new GridLayout(1,6));
		panelPlacement= new JPanel();
		panelUser= new JPanel();
		panelWins= new JPanel();
		panelLost= new JPanel();
		panelNoGames= new JPanel();
		panelDraws= new JPanel();
		list.add(panelPlacement);
		list.add(panelUser); 
		list.add(panelWins); 
		list.add(panelLost); 
		list.add(panelNoGames); 
		list.add(panelDraws);
		for(JPanel panel: list) {
			panel.setBorder(BorderFactory.createLineBorder(Color.black));
			panel.setBackground(Color.WHITE);
			panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
			panelHolderItems.add(panel);
			
		}
		panelToDisplayTo.add(panelHolderItems);
		
	}
	private void ScorePanel(JPanel paneltoTo) {
		JPanel scorePanel=new JPanel();
		scorePanel.setBackground(Color.black);
		scorePanel.setAlignmentX(CENTER_ALIGNMENT);

		scorePanel= screenswapper.getCards(); 
		scorePanel.setMaximumSize((new Dimension(600,500)));
		Map<String, Player> listOfPlayers=stats.getPlayersSort(Stats.SORTBYGAMESWON);		
		Integer counter=1; 
		
		JPanel score= new JPanel();
		score.setLayout(new BoxLayout(score,BoxLayout.Y_AXIS));
		LabelForScore(score);	
		score.setBackground(Color.black);		
		createItemsPanel(score);
		screenswapper.addNewScreen(score, counter.toString());
		for(String username : listOfPlayers.keySet()) { 
		
			int numberOfPlayersToDrawOnEachPanel=10; 
			Player p=listOfPlayers.get(username);
			if(counter % 12 > numberOfPlayersToDrawOnEachPanel){
				score= new JPanel();
				score.setLayout(new BoxLayout(score,BoxLayout.Y_AXIS));
				LabelForScore(score);	
				score.setBackground(Color.black);		
				createItemsPanel(score);
				screenswapper.addNewScreen(score, counter.toString());
			}
			Integer counterToPlacement=counter; 
			
			
			panelPlacement.add( new CenteredJLabel(counterToPlacement.toString() + " ."));
			panelUser.add(new CenteredJLabel(p.getUsername()));
			panelWins.add(new CenteredJLabel(String.valueOf(p.getGamesWon())));
			panelLost.add(new CenteredJLabel(String.valueOf(p.getGamesLost())));
			panelNoGames.add(new CenteredJLabel(String.valueOf(p.getGamesPlayed())));
			panelDraws.add(new CenteredJLabel(String.valueOf(p.getGamesDrawn())));
				
			
			counter++;
		}
		
		paneltoTo.add(scorePanel);
		
	}
	/*
	 * creates the button panel.
	 * @paneltoAddto adds the buttonPanel that should be displayed. 
	 * 
	 */
	private void ButtonPanel(JPanel panelToAddTo) {
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
		panelToAddTo.add(buttonPanel);
	}

	
	/*
	 * 
	 * adds the header of all the headings i.e Placement games etc. 
	 */

	private void LabelForScore(JPanel paneltoTo){
		JPanel labelPanel= new JPanel();
	
		labelPanel.setBackground(Color.white);
		labelPanel.setMaximumSize((new Dimension(900,50)));;
		labelPanel.setLayout(new GridLayout(1,6)); 
		labelPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		List<JLabel> labels= new ArrayList<JLabel>();

		labels.add(new JLabel(" Placement "));
		labels.add(new JLabel(" User ")); 
		labels.add(new JLabel(" # Games "));
		labels.add(new JLabel(" Losts "));
		labels.add(new JLabel(" Wins "));
		labels.add(new JLabel(" Draws "));

		
		
		for(JLabel label: labels) {
		//label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			label.setFont(new Font("Helvetica", Font.PLAIN,15));
			label.setBorder(new LineBorder(Color.BLACK));
			label.setAlignmentX(Component.CENTER_ALIGNMENT);
			
			labelPanel.add(label);
			//labelPanel.add(Box.createRigidArea(new Dimension(SCOREPANEL_SPACING,SCOREPANEL_SPACING)));

		}
		paneltoTo.add(labelPanel);

	}
}




