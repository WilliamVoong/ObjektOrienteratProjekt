package src.objektorienterat;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

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



        JButton goBackToMenu= new JButton("go back to menu");
        JButton saveGame= new JButton("save game");
        JButton sugggestMove= new JButton("Suggest move");


        goBackToMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameModel.reset();
                gameView.reset();
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
                filehandler.setGamemodel(gameModel);
                filehandler.Save(player);

            }
        });

        setLayout(new BorderLayout());
        GridBagConstraints c=new GridBagConstraints();
        gameView.setBorder(BorderFactory.createLineBorder(Color.black, 30));
        JPanel wrapper = new JPanel(new BorderLayout());
        wrapper.add(Box.createGlue(), BorderLayout.CENTER);


        JPanel buttonPanel = new JPanel();
        buttonPanel.setBorder(new EmptyBorder(30,30,30,30));
        buttonPanel.setLayout(new GridBagLayout());
        buttonPanel.setBackground(getBackground());



        gameView.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonPanel.setAlignmentX(CENTER_ALIGNMENT);



        goBackToMenu.setUI(new StyledButtonUI());
        sugggestMove.setUI(new StyledButtonUI());
        saveGame.setUI(new StyledButtonUI());

        c.ipady=30;
        c.weighty=3;
        c.gridx=GridBagConstraints.PAGE_START;
        c.fill=GridBagConstraints.HORIZONTAL;


        buttonPanel.add( goBackToMenu,c);
        c.gridy+=3;
        buttonPanel.add( sugggestMove,c);
        c.gridy+=3;
        buttonPanel.add(saveGame,c);
        c.gridy+=3;
        buttonPanel.add(new JButton("hej"),c);






        add(gameView,BorderLayout.CENTER);
        add(buttonPanel,BorderLayout.EAST);
        add(Box.createGlue(), BorderLayout.NORTH);
        add(Box.createGlue(), BorderLayout.WEST);
        add(Box.createGlue(), BorderLayout.SOUTH);





        //add(text, BorderLayout.NORTH);
    }
    //public void setGamepanel(JPanel gamepanel){
    //  this.gameView=gamepanel;
    // }

}
