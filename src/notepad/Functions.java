package notepad;

import java.awt.FileDialog;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class Functions {

	private GUI gui;
	String fileName; // File Load Open Functionality
	String fileAddress; // File Load Open Functionality

	/**
	 * Constructor
	 * 
	 */
	public Functions(GUI gui) {
		this.gui = gui;
	}

	/**
	 * File -> New File Functionality
	 */
	public void newFile() {
		gui.textArea.setText(""); // Erase current text
		gui.window.setTitle("New Text File"); // New Text File -> title: New
		fileName = null; // Reset filename -> default on starting the application
		fileAddress = null; // Reset fileAddress -> default on starting the application
	}

	/**
	 * File -> Open File Functionality
	 */

	public void open() {
		FileDialog fd = new FileDialog(gui.window, "Open", FileDialog.LOAD); // Open File Function -> Load : Open
		System.out.println("Open");
		fd.setVisible(true); // Set Visible

//		Get Something
		if (fd.getFile() != null) {
			fileName = fd.getFile(); // Get filename of file chosen
			fileAddress = fd.getDirectory(); // Get the address of the file
			gui.window.setTitle(fileName); // Set title as file name
			
		}
		System.out.println("File address and file name: " + fileAddress + " " + fileName);
		
		// Load content of text file using 
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileAddress + fileName)); // File address + file name reqd to read file
			gui.textArea.setText(""); //
			String line = null;
			// Read file line by line
			while((line = br.readLine())!= null) {
				gui.textArea.append(line + "\n"); // Append first line and line break -> add text line by name 
			}
			br.close(); // close buffered reader
					
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error Opening File");
			System.out.println(e);
		}
	}

	/**
	 * File -> Save File Functionality
	 *  (Override the current file)
	 */
	
	public void save() {
		if(fileName==null) {
//			New File -> Unsaved as of yet
			saveAs();
		}else {
//			Existing file -> Overwite
			try {
				FileWriter fw = new FileWriter(fileAddress + fileName);
				fw.write(gui.textArea.getText()); // Get text from text area
				fw.close(); // Close file Writer
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Error Saving File" + e);
			}
		}
	}
	
	
	/**
	 * File -> Save As File Functionality
	 *   
	 */
	
	public void saveAs() {
		FileDialog fd = new FileDialog(gui.window, "Save", FileDialog.SAVE); // Save File
		fd.setVisible(true);// Display Visible
		
		if(fd.getFile()!=null) {
			fileName = fd.getFile(); 
			fileAddress = fd.getDirectory();
			gui.window.setTitle(fileName);
		}
		
		try {
			FileWriter fw = new FileWriter(fileAddress + fileName);
			fw.write(gui.textArea.getText()); // Get text from text area
			fw.close(); // Close file Writer
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error Saving File");
			System.out.println(e);
		}
		
	}

	/**
	 * Exit application
	 */
	public void exit() {
		// TODO Auto-generated method stub
	 System.exit(0); // Shutdown application
	}

}
