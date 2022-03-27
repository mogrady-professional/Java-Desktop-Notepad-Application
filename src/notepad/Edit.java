package notepad;

/**
 * Edit Functionality -> Undo Manager
 * 
 * @author Michael
 *
 */
public class Edit {
	GUI gui;

	public Edit(GUI gui) {
		this.gui = gui;
		
	}
	
	public void undo() {
		gui.um.undo();
	}

	public void redo() {
		gui.um.redo();
	}
 
}
