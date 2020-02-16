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
        setLayout(new GridBagLayout());
        GridBagConstraints c=new GridBagConstraints();
        ;







        //this.gameView= new DisplayScreen(layoutManager);


        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel,BoxLayout.Y_AXIS));
        buttonPanel.setBackground(Color.BLACK);



        JButton goBackToMenu= new JButton("go back to menu");
        JButton saveGame= new JButton("save game");
        JButton sugggestMove= new JButton("Suggest move");

        goBackToMenu.setUI(new StyledButtonUI());
        JLabel text=new JLabel("hej");
        
        
        
        //text.setPreferredSize(new Dimension(100,100));
        //we
        // wegoBackToMenu.setAlignmentX(Component.CENTER_ALIGNMENT);

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
                filehandler.Save(player);
            }
        });


        buttonPanel.add(Box.createRigidArea(new Dimension(0,100)));
        buttonPanel.add(goBackToMenu);
        buttonPanel.add(saveGame);
        buttonPanel.add(sugggestMove);
        //add(buttonPanel, c);


        c.fill=GridBagConstraints.HORIZONTAL;
        c.gridx=1;
        c.gridy=0;
        c.gridwidth=1;
        c.gridheight=1;

        add(sugggestMove,c);
        c.gridy++;
        add(saveGame,c);
        c.gridy++;
        add(goBackToMenu);

        c.gridwidth=5;
        c.gridheight=5;
        c.gridx=0;
        c.gridy=0;
        c.ipady=600;
        c.ipadx=600;
        add(gameView,c);



        //add(text, BorderLayout.NORTH);
    }
   //public void setGamepanel(JPanel gamepanel){
	 //  this.gameView=gamepanel;
  // }
   
}
