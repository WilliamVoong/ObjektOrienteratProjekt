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
        setBackground(Color.WHITE);
        
        
        setLayout(new BorderLayout());
        
      
        
        GridBagConstraints c=new GridBagConstraints();
        gameView.setBorder(BorderFactory.createLineBorder(Color.black, 30));
 
        
        JPanel wrapper = new JPanel(new BorderLayout()); 
        wrapper.add(Box.createGlue(), BorderLayout.CENTER);
        



        //this.gameView= new DisplayScreen(layoutManager);


        JPanel buttonPanel = new JPanel();
        buttonPanel.setBorder(new EmptyBorder(30,30,30,30));
        //buttonPanel.setLayout(new GridLayout(5,1));
        //buttonPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonPanel.setLayout(new GridBagLayout()); 
        buttonPanel.setBackground(getBackground());
        

        gameView.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonPanel.setAlignmentX(CENTER_ALIGNMENT);

        JButton goBackToMenu= new JButton("go back to menu");
        JButton saveGame= new JButton("save game");
        JButton sugggestMove= new JButton("Suggest move");
        
       
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
