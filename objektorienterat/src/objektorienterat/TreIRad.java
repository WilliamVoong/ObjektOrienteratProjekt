package src.objektorienterat;

import java.awt.Color;

import javax.swing.*;

public class TreIRad {
    private GameView gameView;
    private GameModel gameModel;
    private Stats stats;
    private LayoutManager layoutManager;
    private DisplayScreen guiStats;
    private DisplayScreen guiWelcome;
    private DisplayScreen guiGame;
    private DisplayScreen guiMainMenu;
   // private DisplayScreen guiloadgame ;
    private HumanPlayer currentUser;
    private FileHandler fileHandler;
    private HumanPlayer humanPlayer;
    private AI ai;
    private HumanPlayerFactory humanPlayerFactory;
    TreIRad(){
        layoutManager= new LayoutManager();
        stats = new Stats();

        createGameModelViewControler();
        currentUser= new HumanPlayer( new Player("bashar",0,0,0),gameModel,gameView);
        humanPlayer= new HumanPlayer(currentUser,gameModel,gameView);
        humanPlayerFactory= new HumanPlayerFactory(gameView,gameModel,stats);
        fileHandler=new FileHandler(gameModel,gameView);
        createScreens();
        setupScreenMananger();
        
        
    }

    private void createGameModelViewControler() {
        gameModel = new GameModel();
        ai = new AI(gameModel);
        gameModel.setPlayers(new AI(gameModel), ai);
        gameView = new GameView(layoutManager, gameModel);
    }
        private void createScreens() {
        guiStats= new GUI_Stats(layoutManager, stats);
        guiMainMenu= new GUI_MainMenu(layoutManager,humanPlayer,fileHandler,gameModel,humanPlayerFactory);
        guiGame= new GUI_Game(layoutManager, gameModel, gameView,humanPlayer, fileHandler);

       // guiloadgame= new GUI_Game(layoutManager, gameModel, gameView,humanPlayer, fileHandler);
        guiWelcome= new GUI_Welcome(layoutManager, currentUser, humanPlayerFactory);


    }

    private void setupScreenMananger(){
        layoutManager.addNewScreen(guiWelcome,LayoutManager.WELCOMEPANEL);
        layoutManager.addNewScreen(guiGame,LayoutManager.GAMEPANEL);
        layoutManager.addNewScreen(guiStats,LayoutManager.HIGHSCOREPANEL);
        layoutManager.addNewScreen(guiMainMenu,LayoutManager.MENUPANEL);
        //layoutManager.addNewScreen(guiloadgame,LayoutManager.LOADGAME);


    }

    public void startGame(){
        MainWindow w = new MainWindow(layoutManager);
        SwingUtilities.invokeLater(w);

    };
    
    public void setStylePopupWindow(){
    

    };
}