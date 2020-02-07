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
    public final static String LOADGAME="Loadgame";
    JPanel cards = new JPanel(new CardLayout());
    
    LayoutManager(){
    	
    	
    }
    public void addComponentToPane(Container pane) throws Exception {
    	  cards.setVisible(true);
    	  GameView game= new GameView(this);
    	  GameModel game_model=new GameModel();
    	  cards.add(new GUI_Welcome(this), WELCOMEPANEL);
          cards.add(new GUI_MainMenu(this), MENUPANEL);
          cards.add(new GUI_Stats(this), HIGHSCOREPANEL);
          cards.add(game, GAMEPANEL);
        new GameController(game_model,game);
          pane.add(cards);
          System.out.println("hej");
    	
    }

    public void swap(String string)  {
        try {
            if (string.equals(LOADGAME)) {
                GameView gam_load = FileHandler.load_game("Save_Gui");
                GameModel game_load_model = FileHandler.load_game_model("Save_model");
                new GameController(game_load_model,gam_load);
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
