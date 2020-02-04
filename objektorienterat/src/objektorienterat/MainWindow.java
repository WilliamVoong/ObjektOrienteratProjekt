package src.objektorienterat;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainWindow extends JFrame{
	private DisplayScreen currentlyDisplayed;
	MainWindow(){
		super(); 
		setVisible(true);


		GUI_Welcome welcomescreen= new GUI_Welcome(); 
		GUI_MainMenu menu = new GUI_MainMenu();
		ScreenButton goToMenu= new ScreenButton("Go to menu", welcomescreen);
		add(welcomescreen);
		currentlyDisplayed=welcomescreen; 
		
		goToMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwapPanel(menu); 
			}
		});
	
		welcomescreen.add(goToMenu); 
		
		
	
		
		
		pack(); 
		
		
		
	}
	
	public void SwapPanel(DisplayScreen panel){
		remove(currentlyDisplayed);
		add(panel);
		validate();
		repaint();
		currentlyDisplayed=panel; 
		
	}
	
	
}
