package notepad;

/**
 * Format Menu Functionality
 * 
 * @author Michael
 *
 */
public class Format {
	GUI gui;

	/**
	 * Constructor
	 * 
	 * @param gui
	 */
	public Format(GUI gui) {
this.gui = gui;
	}

	public void wordWrap() {
		if(gui.wordWrapOn == false) {
			gui.wordWrapOn = true;
			gui.textArea.setLineWrap(true);// line break
			gui.textArea.setWrapStyleWord(true);// wrap word on word break
			gui.iWrap.setText("Word Wrap: on");// Update text
		}else if(gui.wordWrapOn==true) {
			gui.wordWrapOn = false;
			gui.textArea.setLineWrap(false);// line break
			gui.textArea.setWrapStyleWord(false);// wrap word on word break
			gui.iWrap.setText("Word Wrap: off");// Update text
		}
	}

}
