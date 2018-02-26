import java.awt.MenuBar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MainClass extends JFrame{

	public static Connection db_connection;
	private static String db_user_name = "fransua";
	private static String db_user_pwd = "root";
	private static String db_name = "citation_Management";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			MainClass mc = new MainClass();
			mc.setVisible(true);
	}
		
	public MainClass(){
		setTitle("Citation Management System");
		setSize(800, 600);
		ModelLayer model_layer = new ModelLayer();
		try {
			model_layer.connectDB(MainClass.db_user_name,MainClass.db_user_pwd, MainClass.db_name);
			db_connection = model_layer.getConnectionObj();
			
			if(db_connection==null) {
				System.out.println("Connection:Null");
			}else {
				System.out.println("Connection Successful: Not Null");
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
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
		setMenuItemAction(addMenuItem, new AddCitationWindow());
		
		JMenuItem editMenuItem = new JMenuItem("Edit a citation");
		setMenuItemAction(editMenuItem, new EditCitationWindow());
		
		JMenuItem listMenuItem = new JMenuItem("List all citations");
		setMenuItemAction(listMenuItem, new ListCitationWindow());
		
		JMenuItem searchMenuItem = new JMenuItem("Search a citation");
		setMenuItemAction(searchMenuItem, new SearchCitationWindow());
		
		toolsMenu.add(addMenuItem);
		toolsMenu.add(editMenuItem);
		toolsMenu.addSeparator();
		toolsMenu.add(listMenuItem);
		toolsMenu.add(searchMenuItem);
		
		setJMenuBar(menuBar);
		
	}
	
	void setMenuItemAction(JMenuItem mItem, JFrame itemFrame) {
		mItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				itemFrame.setVisible(true);
			}
		});
	}

}