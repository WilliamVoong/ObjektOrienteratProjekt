package src.objektorienterat;

import java.awt.Component;

import javax.swing.JLabel;

public class CenteredJLabel extends JLabel {
	CenteredJLabel(String string){
			super(string);
			setAlignmentX(Component.CENTER_ALIGNMENT);
	}
}
