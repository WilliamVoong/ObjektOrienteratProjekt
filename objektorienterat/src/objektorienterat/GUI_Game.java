package src.objektorienterat;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import javax.swing.*;

public class GUI_Game extends DisplayScreen {

	Player player;
	FileHandler filehandler;
    GameModel gameModel;
    GameView gameView;


    GUI_Game(SwappableScreen layoutManager,GameModel gameModel,GameView gameView, Player player, FileHandler filehandler){
        super(layoutManager);
        this.filehandler=filehandler; 
        this.player=player;
        this.gameModel=gameModel;
        this.gameView=gameView;
    	//this.gameView= new DisplayScreen(layoutManager);

        setLayout(new BorderLayout());
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel,BoxLayout.Y_AXIS));
        buttonPanel.setBackground(Color.BLACK);



        JButton goBackToMenu= new JButton("go back to menu");
        JButton saveGame= new JButton("save game");
        JButton sugggestMove= new JButton("Suggest move");

        goBackToMenu.setUI(new StyledButtonUI());
        JLabel text=new JLabel("hej");
        
        
        
        text.setPreferredSize(new Dimension(100,100));
        goBackToMenu.setAlignmentX(Component.CENTER_ALIGNMENT);

        goBackToMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                layoutManager.swap(LayoutManager.MENUPANEL);
            }
        });

        sugggestMove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Coordinate AIcoord = AI.smartMove(gameModel.getMarks(),gameModel.getMarkCount());
                if(AIcoord==null)
                    AIcoord=AI.randomMove(gameModel.getMarks());
                Sound_effect.playSound("help.wav");
                gameView.blinkButton(AIcoord);

            }
        });

        saveGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                filehandler.Save(new Player("pelle",0,0,0));
            }
        });


        buttonPanel.add(Box.createRigidArea(new Dimension(0,100)));
        buttonPanel.add(goBackToMenu);
        buttonPanel.add(saveGame);
        buttonPanel.add(sugggestMove);

        add(gameView,BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.EAST);


        //add(text, BorderLayout.NORTH);
    }
   //public void setGamepanel(JPanel gamepanel){
	 //  this.gameView=gamepanel;
  // }
   
}
