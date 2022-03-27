package notepad;

import java.awt.Font;

/**
 * Format Menu Functionality
 * 
 * @author Michael
 *
 */
public class Format {
	GUI gui;
	Font arial, comicSansMS, timesNewRoman; // Font Selection
	String selectedFont;

	/**
	 * Constructor
	 * 
	 * @param gui
	 */
	public Format(GUI gui) {
		this.gui = gui;
	}

	/**
	 * Word Wrap
	 */
	public void wordWrap() {
		if (gui.wordWrapOn == false) {
			gui.wordWrapOn = true;
			gui.textArea.setLineWrap(true);// line break
			gui.textArea.setWrapStyleWord(true);// wrap word on word break
			gui.iWrap.setText("Word Wrap: on");// Update text
		} else if (gui.wordWrapOn == true) {
			gui.wordWrapOn = false;
			gui.textArea.setLineWrap(false);// line break
			gui.textArea.setWrapStyleWord(false);// wrap word on word break
			gui.iWrap.setText("Word Wrap: off");// Update text
		}
	}
	
	/**
	 * Font Size
	 */
	public void createFont(int fontSize) {
		arial = new Font("Arial", Font.PLAIN, fontSize);
		comicSansMS = new Font("Comic Sans MS", Font.PLAIN, fontSize);
		timesNewRoman = new Font("Times New Roman", Font.PLAIN, fontSize);	
		
		// Call Font Set Size Method -> Recreate font
		setFont(selectedFont);
	}
	
	/**
	 * Pass in Selected Fonts
	 * @param font
	 */
	public void setFont(String font) {
		selectedFont = font;
		switch (selectedFont) {
		case "Arial" -> gui.textArea.setFont(arial);
		case "Comic Sans MS" -> gui.textArea.setFont(comicSansMS);
		case "Times New Roman" -> gui.textArea.setFont(timesNewRoman);
		default ->
		throw new IllegalArgumentException("Unexpected value: " + selectedFont);
		}
	}

}
