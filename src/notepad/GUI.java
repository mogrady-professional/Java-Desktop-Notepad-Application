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
//	Text Area
	JTextArea textArea;
	boolean wordWrapOn = false; // Word Wrap Disabled by Default
//	Top Menu Bar
	JScrollPane scrollPane; // Scroll Pane
	JMenuBar menuBar; // Menu Bar
// 	File Menu
	JMenu menuFile, menuEdit, menuFormat, menuColor; // File Menu [JMenu] -> Menu Option
	JMenuItem iNew, iOpen, iSave, iSaveAs, iExit; // Options [JMenuItem] -> Dropdown Items
//	Format Menu
	JMenuItem iWrap, iFontArial, iFontCSMS, iFontTNR, iFontSize8, iFontSize16, iFontSize20, iFontSize24, iFontSize28;
	JMenu menuFont, menuFontSize;
	
	
	
	File file = new File(this); // File Menu
	Format format = new Format(this); // Format Menu

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
		createFormatMenu(); // Format Menu
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
	 * Format Menu
	 * No need to add actionlistener as this is just JMenu
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
		case "Exit" -> file.exit(); // Exit Application
		case "Word Wrap" -> format.wordWrap(); // Word Wrap
		default -> throw new IllegalArgumentException("Unexpected value: " + command);
		}

	}
}
