package src.objektorienterat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

public interface SwappableScreen{
	public void swap(String string);
	public JPanel getPanel();
}
