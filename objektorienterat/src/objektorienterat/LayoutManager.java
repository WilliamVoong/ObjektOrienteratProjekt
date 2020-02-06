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
    	  GUI_GAME game= new GUI_GAME(this);
    	  Game game_model=new Game();
    	  cards.add(new GUI_Welcome(this), WELCOMEPANEL);
          cards.add(new GUI_MainMenu(this), MENUPANEL);
          cards.add(new GUI_STATS(this), HIGHSCOREPANEL);
          cards.add(game, GAMEPANEL);
          new Game_Controller(game_model,game);
          pane.add(cards);
        System.out.println("hej");
    	
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
}
