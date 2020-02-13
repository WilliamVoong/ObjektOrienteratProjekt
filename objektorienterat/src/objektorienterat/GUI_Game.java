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


    GUI_Game(SwappableScreen layoutManager,GameModel gameModel,GameView gameView){
    	
    	
    
        super(layoutManager);
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
                gameView.blinkButton(AI.move(gameModel.getMarks(),gameModel.getMarkCount()));
                Sound_effect.playSound("help.wav");

            }
        });

        saveGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                FileHandler.Save_game(gameModel,"Save_model17","bashar");
                FileHandler.Save_game(gameView,"Save_Gui17","bashar");

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
