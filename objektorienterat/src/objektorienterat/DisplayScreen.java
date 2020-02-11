package src.objektorienterat;

import javax.swing.JPanel;

import java.awt.Color;
import java.util.*;
/*
 * 
 * each displayscreen has a layout manager that is the interface of swappable screen
 * 
 * 
 */


public class DisplayScreen extends JPanel {
	SwappableScreen layoutManager = new LayoutManager(); 
	
	DisplayScreen(SwappableScreen layoutManager){
		this.layoutManager=layoutManager; 
		setBackground(new Color(0x46A79D));
	}

}
