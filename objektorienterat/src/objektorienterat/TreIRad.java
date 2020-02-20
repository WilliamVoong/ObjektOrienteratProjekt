package src.objektorienterat;

import java.awt.Color;

import javax.swing.*;
/*
 * 
 * The purpose of this class to create all the references of the treIrad game and create all the compositions. 
 *
 * 
 */
public class TreIRad {
    private GameView gameView;
    private GameModel gameModel;
    private Stats stats;
    private LayoutManager layoutManager;
    private DisplayScreen guiStats;
    private DisplayScreen guiWelcome;
    private DisplayScreen guiGame;
    private DisplayScreen guiMainMenu;
    private Player currentUser;
    private FileHandler fileHandler;
    private GameAdmin gameAdmin; 
    private AI ai;
   
    TreIRad(){
        layoutManager= new LayoutManager();
        stats = new Stats();
        
        gameModel= new GameModel();
        gameView= new GameView(layoutManager,gameModel);  
        currentUser= new Player("nameNotCurrentltlyDetermined",0,0,0,gameModel,gameView);
        gameAdmin= new GameAdmin(currentUser, gameModel, gameView);
        
        createGameModelViewControler();
        
        fileHandler=new FileHandler(gameModel,gameView);
        createScreens();
        setupScreenMananger();
        
        
    }

    private void createGameModelViewControler(){
       
        
      
         
    }

    private void createScreens(){
        guiStats= new GUI_Stats(layoutManager, stats);
        guiMainMenu= new GUI_MainMenu(layoutManager, fileHandler, gameAdmin );
        guiGame= new GUI_Game(layoutManager, gameModel, gameView,currentUser, fileHandler);
        guiWelcome= new GUI_Welcome(layoutManager, currentUser);

    }

    private void setupScreenMananger(){
        layoutManager.addNewScreen(guiWelcome,LayoutManager.WELCOMEPANEL);
        layoutManager.addNewScreen(guiGame,LayoutManager.GAMEPANEL);
        layoutManager.addNewScreen(guiStats,LayoutManager.HIGHSCOREPANEL);
        layoutManager.addNewScreen(guiMainMenu,LayoutManager.MENUPANEL);
    }

    public void startGame(){
        MainWindow w = new MainWindow(layoutManager);
        SwingUtilities.invokeLater(w);

    };
    
    public void setStylePopupWindow(){
    

    };
}