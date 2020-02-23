package src.objektorienterat;

import javax.swing.JPanel;
import javax.swing.UIManager;

import java.awt.Color;
import java.util.*;
/*
<<<<<<< HEAD
 *
 * Each screen of the gui game is a displayscreen, the purpose of this class is to create
 * a common baseline for the design for all the displayed panels in the treIrad game, for instance
 * same BG colors and etc.
 *
=======
 * 
 * Each screen of the gui game is a displayscreen, the purpose of this class is to create 
 * a common baseline for the design for all the displayed panels in the treIrad game, for instance 
 * same BG colors and etc.  
 * 
>>>>>>> c74f384db83641e3d5c38d9ee6c9487be56b5392
 */



public abstract class DisplayScreen extends JPanel {
	SwappableScreen layoutManager = new LayoutManager(); 
	

	DisplayScreen(SwappableScreen layoutManager){
		this.layoutManager=layoutManager;
		setBackground(new Color(0xFB292952));
		UIManager UI=new UIManager();
		UI.put("OptionPane.background",new Color(0xFB292952));
		UI.put("Panel.background", new Color(0xFB292952));
		UI.put("OptionPane.messageForeground", Color.white);
	}

}
