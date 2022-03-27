package notepad;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Key Handler for Keyboard Input
 * 
 * @author Michael
 *
 */
public class KeyHandler implements KeyListener {

	GUI gui;

	/**
	 * Constructor to access GUI Class
	 */
	public KeyHandler(GUI gui) {
		// TODO Auto-generated constructor stub
		this.gui = gui;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
//		Save Functionality -> Ctrl + s
		if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_S) {
			gui.file.save();
			System.out.println("Save");
		}
		
//		Undo Functionality -> Ctrl + z
		if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_Z) {
			gui.edit.undo();
			System.out.println("Undo");
		}
		
//		Redo Functionality -> Ctrl + y
		if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_Y) {
			gui.edit.redo();
			System.out.println("Redo");
		}
		
//		Open File Menu -> Alt + f
		if (e.isAltDown() && e.getKeyCode() == KeyEvent.VK_F) {
//			Access file menu
			gui.menuFile.doClick();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
