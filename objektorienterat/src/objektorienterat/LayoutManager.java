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
    public void addComponentToPane(Container pane) {
    	  cards.setVisible(true);
    	  GameView game= new GameView(this);
    	  GameModel gameModel=new GameModel();
    	  cards.add(new GUI_Welcome(this), WELCOMEPANEL);
          cards.add(new GUI_MainMenu(this), MENUPANEL);
          cards.add(new GUI_Stats(this), HIGHSCOREPANEL);
         // cards.add(game, GAMEPANEL);
          new GameController(gameModel, game);
          cards.add(new GUI_Stats(this), HIGHSCOREPANEL);
          cards.add(new GUI_Game(this,gameModel,game),GAMEPANEL);
          pane.add(cards);
    	
    }


    public void swap(String string)  {
        try {
            if (string.equals(LOADGAME)) {
                GameView gameView= (GameView) FileHandler.load_game("Save_Gui17","bashar");
                GameModel gameModel = (GameModel) FileHandler.load_game("Save_model17","bashar");
                if(gameView==null)
                    JOptionPane.showMessageDialog(null, "There is no data saved for this Username before !!", "OBS!!", JOptionPane.ERROR_MESSAGE);
                new GameController(gameModel,gameView);
                cards.add(new GUI_Game(this,gameModel,gameView),LOADGAME);

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
	public void addNewScreen(JPanel panel, String string) {
		cards.add(panel,string);
	}
	public JPanel getCards() {
		return cards;
	}
}
