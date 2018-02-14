import java.awt.MenuBar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MainClass extends JFrame{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			System.out.println("Project is on");
			MainClass mc = new MainClass();
			mc.setVisible(true);
	}
		
	MainClass(){
		setTitle("Citation Management System");
		setSize(800, 600);
		setMenu();
	}
	
	void setMenu() {
		JMenuBar menuBar = new JMenuBar();
		
		JMenu fileMenu = new JMenu("File");
		JMenu toolsMenu = new JMenu("Tools");
		menuBar.add(fileMenu);
		menuBar.add(toolsMenu);
		
		JMenuItem exitMenuItem = new JMenuItem("Exit");
		exitMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		fileMenu.add(exitMenuItem);
		
		JMenuItem addMenuItem = new JMenuItem("Add a citation");
		JMenuItem deleteMenuItem = new JMenuItem("Delete a citation");
		JMenuItem listMenuItem = new JMenuItem("List all citations");
		JMenuItem searchMenuItem = new JMenuItem("Search a citation");
		toolsMenu.add(addMenuItem);
		toolsMenu.add(deleteMenuItem);
		toolsMenu.addSeparator();
		toolsMenu.add(listMenuItem);
		toolsMenu.add(searchMenuItem);
		
		setJMenuBar(menuBar);
		
	}

}
