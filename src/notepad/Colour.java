package notepad;

import java.awt.Color;

/**
 * 
 * @author Michael
 *
 */
public class Colour {
	GUI gui;
	
	public Colour(GUI gui) {
		this.gui = gui;
		
	}
	
	/**
	 * Change Colour
	 */
	public void changeColour(String colour) {	
		switch (colour) {
		case "White": {
			gui.window.getContentPane().setBackground(Color.WHITE); // Font White
			gui.textArea.setBackground(Color.white); // Background black
			gui.textArea.setForeground(Color.black); // Foreground black
			break;
		}
		case "Black": {
			gui.window.getContentPane().setBackground(Color.BLACK); // Font White
			gui.textArea.setBackground(Color.black); // Background black
			gui.textArea.setForeground(Color.white); // Foreground black
			break;
		}
		case "Blue": {
			gui.window.getContentPane().setBackground(Color.BLUE); // Font White
			gui.textArea.setBackground(Color.blue); // Background black
			gui.textArea.setForeground(Color.white); // Foreground black
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + colour);
		}
	}
	
 
	

 
}
