package src.objektorienterat;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class GUI_Stats extends DisplayScreen {
	Stats stats; 
	JPanel mainPanel= new JPanel(); 
	SwappableScreen screenswapper= new LayoutManagerStats(); 
	
	GUI_Stats(LayoutManager manager){
		super(manager); 
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		JLabel scoreText=new JLabel("Score"); 
		scoreText.setForeground(Color.WHITE);
		scoreText.setFont(new Font("Helvetica", Font.PLAIN,60));
		scoreText.setAlignmentX(Component.CENTER_ALIGNMENT);
		scoreText.setBackground(Color.black);
		JButton backToMenu= new JButton("Go Back To Menu"); 
		backToMenu.setUI(new StyledButtonUI());
		
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		mainPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		mainPanel.setBackground(Color.BLACK);
		mainPanel.add(scoreText);
		
		
		JPanel holderPanel= new JPanel();
		holderPanel.setLayout(new BoxLayout(holderPanel,BoxLayout.Y_AXIS));
		holderPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		holderPanel.add(scoreText);
		drawScorePanel(holderPanel);
		drawButtonPanel(holderPanel);
		
	
		
		backToMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                layoutManager.swap(LayoutManager.MENUPANEL);
            }
        });
		
		
	
		holderPanel.setBackground(Color.black);
		add(Box.createHorizontalGlue());
		add(holderPanel);
		
		add(Box.createRigidArea(new Dimension(100,100)));
		add(backToMenu);
		add(Box.createHorizontalGlue());
		

		
		
		
		
	}
	private void drawScorePanel(JPanel paneltodrawTo) {
		JPanel scorePanel=new JPanel();
		scorePanel.setBackground(Color.black);
		scorePanel.setAlignmentX(CENTER_ALIGNMENT);
	
		scorePanel= screenswapper.getCards(); 
		scorePanel.setMaximumSize((new Dimension(200,400)));;
		scorePanel.setPreferredSize((new Dimension(100,300)));;
		scorePanel.setMinimumSize((new Dimension(100,300)));;
		
		for(int i =0 ; i < 10; i++) {
			JPanel score= new JPanel();
			score.setLayout(new BoxLayout(score, BoxLayout.Y_AXIS));
			score.setAlignmentX(CENTER_ALIGNMENT);
			score.setBackground(new Color(0x00AAF0CD) );
			for(int j =0 ; j < 10; j++) {
				JLabel s= new JLabel("example score" + j+i);
				s.setAlignmentX(Component.CENTER_ALIGNMENT);
				score.add(s);
			} 
			Integer a= i;
			screenswapper.addNewScreen(score, a.toString());
		}
		//add(Box.createHorizontalGlue());
		
		paneltodrawTo.add(scorePanel);
		//add(Box.createVerticalGlue());
		//add(Box.createHorizontalGlue());
		
	}
	private void drawButtonPanel(JPanel paneltodrawTo) {
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
		paneltodrawTo.add(buttonPanel);
	}
	
	/*	NOT DONE!!!!!!!!!!!!!!
	 * creates panel for every 10 stats added to the screen.
	 *  TODOOOO 
	 */
	private void drawStats()
	{
		
		JPanel score= new JPanel();
		score.setLayout(new BoxLayout(score, BoxLayout.Y_AXIS));
		score.setAlignmentX(CENTER_ALIGNMENT);
		score.setBackground(new Color(0x00AAF0CD) );
		for(int j =0 ; j < 10; j++) {
			JLabel s= new JLabel("example score" + j);
			s.setAlignmentX(Component.CENTER_ALIGNMENT);
			score.add(s);
		} 
		
	}; 
	


}
