package src.objektorienterat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;

public class Clock extends PropertyChangeSupport implements ActionListener {
    private final int perioad=10;
    private  int Second;
    javax.swing.Timer timer=new javax.swing.Timer(1000,this);

    public Clock(Object sourceBean) {
        super(sourceBean);
        timer.start();
    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        System.out.println( Second++);
        firePropertyChange("second",0,getSecond());
    }

    private int getSecond(){
        return Second;
    }



}
