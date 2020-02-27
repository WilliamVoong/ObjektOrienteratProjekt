package src.objektorienterat;

import javax.swing.JPanel;
import javax.swing.UIManager;

import java.awt.Color;
/*
 *
 * Each screen of the gui game is a displayscreen, the purpose of this class is to create
 * a common baseline for the design for all the displayed panels in the treIrad game, for instance
 * same BG colors and etc.
 *
 */

public abstract class DisplayScreen extends JPanel {
	private static final long serialVersionUID = 1L;
	SwappableScreen layoutManager = new LayoutManager(); 
	
	DisplayScreen(SwappableScreen layoutManager){
		this.layoutManager=layoutManager;
		setBackground(new Color(0xFB292952));
		UIManager.put("OptionPane.background",new Color(0xFB292952));
		UIManager.put("Panel.background", new Color(0xFB292952));
		UIManager.put("OptionPane.messageForeground", Color.white);
	}

}
