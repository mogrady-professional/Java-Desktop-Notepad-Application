package notepad;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class GUI implements ActionListener {

	JFrame window;
	JTextArea textArea;
	JScrollPane scrollPane; // Scroll Pane
	JMenuBar menuBar; // Menu Bar

	JMenu menuFile, menuEdit, menuFormat, menuColor; // File Menu
	JMenuItem iNew, iOpen, iSave, iSaveAs, iExit; // Options

	Functions file = new Functions(this); // Send this function

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new GUI();
	}

	/**
	 * Constructor
	 */
	public GUI() {
		createWindow(); // Window
		createTextArea(); // Text Area
		createMenuBar(); // Menu Bar
		createFileMenu(); // File menu
		window.setVisible(true);
		window.setLocationRelativeTo(null); // Center Frame on Display
	}

	public void createWindow() {
		window = new JFrame("Java Desktop Notepad Application");
		window.setSize(800, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void createTextArea() {
		textArea = new JTextArea();

		scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); // set conditions for scroller

		// add scroll pane to window
		window.add(scrollPane);
		scrollPane.setBorder(BorderFactory.createEmptyBorder()); // no border between textPane and JFrame
		// window.add(textArea);
	}

	/**
	 * Menu Bar
	 */
	public void createMenuBar() {

		menuBar = new JMenuBar();
		window.setJMenuBar(menuBar);

//		Menu Options
		menuFile = new JMenu("File"); // File
		menuBar.add(menuFile); // Add file option to JFrame

		menuEdit = new JMenu("Edit"); // File
		menuBar.add(menuEdit); // Add file option to JFrame

		menuFormat = new JMenu("Format"); // File
		menuBar.add(menuFormat); // Add file option to JFrame

		menuColor = new JMenu("Colour"); // File
		menuBar.add(menuColor); // Add file option to JFrame
	}

	/**
	 * File Menu Options
	 */
	public void createFileMenu() {
		iNew = new JMenuItem("New"); // New File
		iNew.addActionListener(this); // Add addActionListener to this button
		iNew.setActionCommand("New"); // setActionCommand
		menuFile.add(iNew);

		iOpen = new JMenuItem("Open"); // Open File
		iOpen.addActionListener(this); // Add addActionListener to this button
		iOpen.setActionCommand("Open"); // setActionCommand
		menuFile.add(iOpen);

		iSave = new JMenuItem("Save"); // Save File
		iSave.addActionListener(this); // Add addActionListener to this button
		iSave.setActionCommand("Save"); // setActionCommand
		menuFile.add(iSave);

		iSaveAs = new JMenuItem("Save As"); // Save As
		iSaveAs.addActionListener(this); // Add addActionListener to this button
		iSaveAs.setActionCommand("SaveAs"); // setActionCommand
		menuFile.add(iSaveAs);

		iExit = new JMenuItem("Exit"); // Exit
		iExit.addActionListener(this); // Add addActionListener to this button
		iExit.setActionCommand("Exit"); // setActionCommand
		menuFile.add(iExit);
	}

	/**
	 * Menu
	 * @param e event
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		String command = e.getActionCommand(); // Get setActionCommand -> New

		switch (command) {
		case "New" -> file.newFile();
		case "Open" -> file.open();
		case "Save" -> file.save();
		case "SaveAs" -> file.saveAs();
		case "Exit" -> file.exit();
		default -> throw new IllegalArgumentException("Unexpected value: " + command);
		}

	}
}
