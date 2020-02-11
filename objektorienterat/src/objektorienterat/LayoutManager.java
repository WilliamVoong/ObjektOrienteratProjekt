package src.objektorienterat;

import java.awt.CardLayout;

import javax.swing.*;
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
    	  GameView gameView= new GameView(this);
    	  GameModel game_model=new GameModel();
    	  cards.add(new GUI_Welcome(this), WELCOMEPANEL);
          cards.add(new GUI_MainMenu(this), MENUPANEL);
          cards.add(new GUI_Stats(this), HIGHSCOREPANEL);
          cards.add(gameView, GAMEPANEL);
        new GameController(game_model,gameView);
          pane.add(cards);
          System.out.println("hej");
    	
    }

    public void swap(String string)  {
        try {
            if (string.equals(LOADGAME)) {
                GameView gameView= (GameView) FileHandler.load_game("Save_Gui15","bilal");
                GameModel gameModel = (GameModel) FileHandler.load_game("Save_model15","bilal");
                if(gameView==null)
                    JOptionPane.showMessageDialog(null, "There is no data saved for this Username before !!", "OBS!!", JOptionPane.ERROR_MESSAGE);
                new GameController(gameModel,gameView);
                cards.add(gameView,LOADGAME);

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
