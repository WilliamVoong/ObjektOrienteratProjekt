package src.objektorienterat;

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
    private Player currentUser;
    private FileHandler fileHandler;
    TreIRad(){
        layoutManager= new LayoutManager();
        stats = new Stats();
        currentUser= new Player("dummy",0,0,0);
        createGameModelViewControler();
        fileHandler=new FileHandler(gameModel,gameView);
        createScreens();
        setupScreenMananger();

    }

    private void createGameModelViewControler(){
        gameModel= new GameModel();
        gameView= new GameView(layoutManager,gameModel);
    }

    private void createScreens(){
        guiStats= new GUI_Stats(layoutManager, stats);
        guiMainMenu= new GUI_MainMenu(layoutManager,currentUser,fileHandler);
        guiGame= new GUI_Game(layoutManager, gameModel, gameView);
        guiWelcome= new GUI_Welcome(layoutManager, currentUser, stats);

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
}