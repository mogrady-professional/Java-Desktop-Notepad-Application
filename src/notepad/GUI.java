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
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;

public class GUI implements ActionListener {

	JFrame window;
//	Text Area
	JTextArea textArea;
	boolean wordWrapOn = false; // Word Wrap Disabled by Default
//	Top Menu Bar
	JScrollPane scrollPane; // Scroll Pane
	JMenuBar menuBar; // Menu Bar
// 	File Menu
	JMenu menuFile, menuEdit, menuFormat, menuColor; // File Menu [JMenu] -> Menu Option
	JMenuItem iNew, iOpen, iSave, iSaveAs, iExit; // Options [JMenuItem] -> Dropdown Items
//	Edit Menu
	JMenuItem iUndo, iRedo;
//	Format Menu
	JMenuItem iWrap, iFontArial, iFontCSMS, iFontTNR, iFontSize8, iFontSize16, iFontSize20, iFontSize24, iFontSize28;
	JMenu menuFont, menuFontSize;
//	Colour Menu
	JMenuItem iColour1, iColour2, iColour3;
//	Menu Functionality
	File file = new File(this); // File Functionality
	Format format = new Format(this); // Format Functionality
	Colour colour = new Colour(this); // Colour Functionality
	Edit edit = new Edit(this); // Edit Functionality
//	Key Handler
	KeyHandler kHandler = new  KeyHandler(this); // Pass GUI class to constructor
//	Undo Functionality
	/**
	 * UndoManager manages a list of UndoableEdits,providing a way to undo or redo the appropriate edits. 
	 */
	UndoManager um = new UndoManager();


	/**
	 * Constructor Calls
	 */
	public GUI() {
		createWindow(); // Window
		createTextArea(); // Text Area
//			Menu
		createMenuBar(); // Menu Bar
		createFileMenu(); // File menu
		createEditMenu(); // Edit Menu
		createFormatMenu(); // Format Menu
		createColourMenu(); // Colour Menu
//		Defaults
		format.selectedFont = "Arial"; // default font
		format.createFont(16);
		; // default font size
		format.wordWrap();// Word Wrap
//		colour.changeColour("White");
		
		window.setVisible(true);
		window.setLocationRelativeTo(null); // Center Frame on Display
	}

	public void createWindow() {
//		window = new JFrame("Java Desktop Notepad Application");
		window = new JFrame("Notepad");
		window.setSize(800, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * Format to add Undo Manager Functionality
	 */
	public void createTextArea() {
		textArea = new JTextArea();
		
		textArea.addKeyListener(kHandler); // Listen for keypress
		
		textArea.getDocument().addUndoableEditListener(new UndoableEditListener() {
			
			@Override
			public void undoableEditHappened(UndoableEditEvent e) {
				// TODO Auto-generated method stub
				um.addEdit(e.getEdit());
			}
		});

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
	 * Edit Menu
	 */

	public void createEditMenu() {
		iUndo = new JMenuItem("Undo");
		iUndo.addActionListener(this); // Add addActionListener to this button
		iUndo.setActionCommand("Undo"); // setActionCommand
		menuEdit.add(iUndo);
		
		iRedo = new JMenuItem("Redo");
		iRedo.addActionListener(this); // Add addActionListener to this button
		iRedo.setActionCommand("Redo"); // setActionCommand
		menuEdit.add(iRedo);
	}
	
	
	/**
	 * Format Menu No need to add actionlistener as this is just JMenu
	 */
	public void createFormatMenu() {
//		Word Wrap
		iWrap = new JMenuItem("Word Wrap: Off");
		iWrap.addActionListener(this);
		iWrap.setActionCommand("Word Wrap");
		menuFormat.add(iWrap);
//		Font
		menuFont = new JMenu("Font");
		menuFormat.add(menuFont);

//		Font Options
		iFontArial = new JMenuItem("Arial");
		iFontArial.addActionListener(this);
		iFontArial.setActionCommand("Arial");
		menuFont.add(iFontArial);

		iFontCSMS = new JMenuItem("Comic Sans MS");
		iFontCSMS.addActionListener(this);
		iFontCSMS.setActionCommand("Comic Sans MS");
		menuFont.add(iFontCSMS);

		iFontTNR = new JMenuItem("Times New Roman");
		iFontTNR.addActionListener(this);
		iFontTNR.setActionCommand("Times New Roman");
		menuFont.add(iFontTNR);

//		Font Sizing

//		Font Size
		menuFontSize = new JMenu("Font Size");
		menuFormat.add(menuFontSize); // Add to Menu

		iFontSize8 = new JMenuItem("8");
		iFontSize8.addActionListener(this);
		iFontSize8.setActionCommand("Size8");
		menuFontSize.add(iFontSize8); // Add option to Menu

		iFontSize16 = new JMenuItem("16");
		iFontSize16.addActionListener(this);
		iFontSize16.setActionCommand("Size16");
		menuFontSize.add(iFontSize16); // Add option to Menu

		iFontSize20 = new JMenuItem("20");
		iFontSize20.addActionListener(this);
		iFontSize20.setActionCommand("Size20");
		menuFontSize.add(iFontSize20); // Add option to Menu

		iFontSize24 = new JMenuItem("24");
		iFontSize24.addActionListener(this);
		iFontSize24.setActionCommand("Size24");
		menuFontSize.add(iFontSize24); // Add option to Menu

		iFontSize28 = new JMenuItem("28");
		iFontSize28.addActionListener(this);
		iFontSize28.setActionCommand("Size28");
		menuFontSize.add(iFontSize28); // Add option to Menu

	}

	/**
	 * Colour
	 */
	public void createColourMenu() {
		iColour1 = new JMenuItem("White"); // Default
		iColour1.addActionListener(this);
		iColour1.setActionCommand("White");
		menuColor.add(iColour1); 
		
		iColour2 = new JMenuItem("Black"); 
		iColour2.addActionListener(this);
		iColour2.setActionCommand("Black");
		menuColor.add(iColour2); 
		
		iColour3 = new JMenuItem("Blue");
		iColour3.addActionListener(this);
		iColour3.setActionCommand("Blue");
		menuColor.add(iColour3); 
	}

	/**
	 * Menu
	 * 
	 * @param e event
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		String command = e.getActionCommand(); // Get setActionCommand -> New

		switch (command) {
//		File Methods
		case "New" -> file.newFile(); // newFile Functionality
		case "Open" -> file.open(); // open Functionality
		case "Save" -> file.save(); // save Functionality
		case "SaveAs" -> file.saveAs(); // saveAs Functionality
		case "Exit" -> file.exit(); // Exit Application
		case "Undo" -> edit.undo(); // Undo Functionality
		case "Redo" -> edit.redo(); // Redo Functionality
//		Format Methods
		case "Word Wrap" -> format.wordWrap(); // Word Wrap
//		Font
		case "Arial" -> format.setFont(command);
		case "Comic Sans MS" -> format.setFont(command);
		case "Times New Roman" -> format.setFont(command);
//		Font Sizing
		case "Size8" -> format.createFont(8); // pass in integer size
		case "Size12" -> format.createFont(12); // pass in integer size
		case "Size16" -> format.createFont(16); // pass in integer size
		case "Size20" -> format.createFont(20); // pass in integer size
		case "Size24" -> format.createFont(24); // pass in integer size
		case "Size28" -> format.createFont(28); // pass in integer size
		case "White" -> colour.changeColour(command); // pass in colour
		case "Black" -> colour.changeColour(command); // pass in colour
		case "Blue" -> colour.changeColour(command); // pass in colour
		default -> throw new IllegalArgumentException("Unexpected value: " + command);
		}

	}
}
