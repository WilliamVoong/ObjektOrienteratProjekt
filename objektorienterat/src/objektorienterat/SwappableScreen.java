package src.objektorienterat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import javax.swing.JFrame;
import javax.swing.JPanel;

public interface SwappableScreen extends Serializable {
	public void swap(String string);
	//public JPanel getPanel();
	public void addNewScreen(JPanel panel, String string); 
	public JPanel getCards();
}
