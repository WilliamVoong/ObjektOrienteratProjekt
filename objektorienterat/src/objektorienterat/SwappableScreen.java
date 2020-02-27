package src.objektorienterat;

import java.io.Serializable;
import javax.swing.JPanel;

public interface SwappableScreen extends Serializable {
	public void swap(String string);
	//public JPanel getPanel();
	public void addNewScreen(JPanel panel, String string); 
	public JPanel getCards();
}
