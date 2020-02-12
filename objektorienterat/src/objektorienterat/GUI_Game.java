package src.objektorienterat;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import javax.swing.*;

public class GUI_Game extends DisplayScreen {
	JPanel game; 
    GUI_Game(SwappableScreen layoutManager, JPanel gameView){
    	
    	
    
        super(layoutManager);
    	game= new DisplayScreen(layoutManager);
    	game=gameView;
        setLayout(new BorderLayout());
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel,BoxLayout.X_AXIS));
        buttonPanel.setBackground(Color.BLACK);



        JButton goBackToMenu= new JButton("go back to menu");
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


        buttonPanel.add(Box.createRigidArea(new Dimension(0,100)));
        buttonPanel.add(goBackToMenu);
        add(game,BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.EAST);
        //add(text, BorderLayout.NORTH);
    }
   public void setGamepanel(JPanel gamepanel){
	   this.game=gamepanel; 
   } 
   
}