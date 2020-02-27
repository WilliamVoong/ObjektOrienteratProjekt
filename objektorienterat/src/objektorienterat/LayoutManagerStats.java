package src.objektorienterat;

import java.awt.CardLayout;

import javax.swing.JPanel;
/*
 * A layoutmanager for the stats class;
 *
 */
public class LayoutManagerStats implements SwappableScreen{
	private static final long serialVersionUID = 1L;
	JPanel cards = new JPanel(new CardLayout());
	CardLayout c1= (CardLayout) (cards.getLayout());
	@Override
	public void swap(String screenToShow) {

	}

	@Override
	

	public void addNewScreen(JPanel panel, String string) {
		cards.add(panel,string);
	}

	public JPanel getCards() {
		// TODO Auto-generated method stub
		return cards;
	}
}
