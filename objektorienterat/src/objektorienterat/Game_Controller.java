package src.objektorienterat;


import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;

import javax.swing.JOptionPane;

public  class  Game_Controller implements Serializable {
    private  static Game theModel;
    private  static GUI_GAME theView;



    public Game_Controller(Game theModel, GUI_GAME theView) {
         this.theModel = theModel;
        this.theView = theView;
        Clock clock=new Clock(new Object());
        clock.addPropertyChangeListener(theView);
        theModel.addPropertyChangeListener(theView);
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                theView.addCellListener(new Coordinate(i, j), new CellListener());
            }
        }
    }

    public Game getTheModel(){return theModel;}

    public GUI_GAME getTheView(){return theView;

    }

    public static void save_game(String filename) throws IOException
    {
        FileHandler.Save_game(theView,filename);
    }

    public static void save_game_model(String filename) throws IOException
    {
        FileHandler.Save_game_model(theModel,filename);
    }



    public Game_Controller(Game_Controller game_controller)
    {
        theView=game_controller.getTheView();
        theModel=game_controller.getTheModel();
    }




    class CellListener implements ActionListener {
        /* kommer förbättra detta senare */
        @Override
        public void actionPerformed(ActionEvent e) {
            Sound_effect.playSound("buttonclick.wav");
            Cell c = (Cell)e.getSource();
            //theView.Change_color(c.getCoordinate(),new Color(0x6CCEAE));
            if(c.getText().equals("")) {
                Coordinate coord = c.getCoordinate();
                theModel.mark(coord);
                // theView.setCellText(coord, theModel.getMark(coord)); old version without Observer
                switch(theModel.checkForWinner(coord)) {
                    case -1:
                        Coordinate AIcoord = AI.move(theModel.getMarks(), theModel.getMarkCount());
                        if(AIcoord != null) {
                            theModel.mark(AIcoord);
                            //theView.setCellText(AIcoord, theModel.getMark(AIcoord)); without observer
                            //theView.Change_color(AIcoord,new Color(0xBC83CE));
                            switch(theModel.checkForWinner(AIcoord)) {
                                case -1: break;
                                case 0:
                                    Sound_effect.playSound("win.wav");
                                    JOptionPane.showMessageDialog(null, "O won!", "O won!", JOptionPane.INFORMATION_MESSAGE);

                                    break;
                                case 1:
                                    JOptionPane.showMessageDialog(null, "X won!", "X won!", JOptionPane.INFORMATION_MESSAGE);
                                    break;
                            }
                        }
                        break;
                    case 0:
                        JOptionPane.showMessageDialog(null, "O won!", "O won!", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    case 1:
                        JOptionPane.showMessageDialog(null, "X won!", "X won!", JOptionPane.INFORMATION_MESSAGE);
                }
            }
            theView.repaint();
        }

    }



}
