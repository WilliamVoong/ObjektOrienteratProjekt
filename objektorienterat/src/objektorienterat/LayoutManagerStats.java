package src.objektorienterat;

import java.awt.CardLayout;

import javax.swing.JPanel;

public class LayoutManagerStats implements SwappableScreen{
	JPanel cards = new JPanel(new CardLayout());
	CardLayout c1= (CardLayout) (cards.getLayout());
	@Override
	public void swap(String screenToShow) {
		
		c1.next(cards);
	}

	@Override
	public JPanel getPanel() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void addNewScreen(JPanel panel, String string) {
		cards.add(panel,string);
	}

	public JPanel getCards() {
		// TODO Auto-generated method stub
		return cards;
	}
}
