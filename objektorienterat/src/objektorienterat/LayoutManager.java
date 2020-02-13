package src.objektorienterat;

import java.awt.CardLayout;

import javax.swing.JPanel;
import java.awt.*;
/**
 *  LayoutManager has the responsibility of what panel that are being displayed. 
 * 
 * @author william
 *
 */
public class LayoutManager implements SwappableScreen{
	public final static String MENUPANEL = "MenuPanel";
    public final static String WELCOMEPANEL = "Welcome";
    public final static String GAMEPANEL = "GamePlay";
    public final static String HIGHSCOREPANEL = "HighScore";
   
    JPanel cards = new JPanel(new CardLayout());
    
    LayoutManager(){
    	
    	
    }
    public void addComponentToPane(Container pane) {
    	  cards.setVisible(true);
    	  GameView game= new GameView(this);
    	  
    	  cards.add(new GUI_Welcome(this), WELCOMEPANEL);
          cards.add(new GUI_MainMenu(this), MENUPANEL);

          cards.add(new GUI_Stats(this), HIGHSCOREPANEL);
         // cards.add(game, GAMEPANEL);
          new GameController(new GameModel(), game);

          cards.add(new GUI_Stats(this), HIGHSCOREPANEL);
          cards.add(new GUI_Game(this,game), GAMEPANEL);
        

          pane.add(cards);
    	
    }
    public void swap(String string) {
    	CardLayout c1= (CardLayout) (cards.getLayout());
    	c1.show(cards, string);
    	
    }
	@Override
	public JPanel getPanel() {
		// TODO Auto-generated method stub
		return cards;
	}
	public void addNewScreen(JPanel panel, String string) {
		cards.add(panel,string);
	}
	public JPanel getCards() {
		return cards;
	}
}
