package src.objektorienterat;

import java.awt.CardLayout;

import javax.swing.JPanel;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;

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
    public final static String LOADGAME="Loadgame";
    JPanel cards = new JPanel(new CardLayout());
    
    LayoutManager(){
    	
    	
    }
    public void addComponentToPane(Container pane) throws Exception {
    	  cards.setVisible(true);
    	  GUI_GAME game= new GUI_GAME(this);
    	  Game game_model=new Game(new Object());
    	  cards.add(new GUI_Welcome(this), WELCOMEPANEL);
          cards.add(new GUI_MainMenu(this), MENUPANEL);
          cards.add(new GUI_STATS(this), HIGHSCOREPANEL);
          cards.add(game, GAMEPANEL);
        new Game_Controller(game_model,game);
          pane.add(cards);
          System.out.println("hej");
    	
    }

    public void swap(String string)  {
        try {
            if (string.equals(LOADGAME)) {
                GUI_GAME gam_load = FileHandler.load_game("Save_Gui");
                Game game_load_model = FileHandler.load_game_model("Save_model");
                new Game_Controller(game_load_model,gam_load);
                cards.add(gam_load,LOADGAME);

            }
        }catch (Exception e)
        {

        }
    	CardLayout c1= (CardLayout) (cards.getLayout());
    	c1.show(cards, string);
    	
    }
	@Override
	public JPanel getPanel() {
		// TODO Auto-generated method stub
		return cards;
	}
}
