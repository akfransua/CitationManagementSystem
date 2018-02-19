import java.awt.Component;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;import java.util.Enumeration;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.event.TableColumnModelListener;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

public class ListCitationWindow extends JFrame {
	
	private ArrayList<Citation> citations; 
	
	
	class ButtonRenderer extends JButton implements TableCellRenderer {

		  public ButtonRenderer() {
		    setOpaque(true);
		  }

		  public Component getTableCellRendererComponent(JTable table, Object value,
		      boolean isSelected, boolean hasFocus, int row, int column) {
		    if (isSelected) {
		      setForeground(table.getSelectionForeground());
		      setBackground(table.getSelectionBackground());
		    } else {
		      setForeground(table.getForeground());
		      setBackground(UIManager.getColor("Button.background"));
		    }
		    setText((value == null) ? "" : value.toString());
		    return this;
		  }
		}
	
	
	public ListCitationWindow() {
		
		citations = new ArrayList<Citation>();
		try {
			loadCitations();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		
		String[] column_names = {"ID", "Citation Title", "Actions"};
		Object[][] row_data = new Object[citations.size()][column_names.length];
		
		JTable table = new JTable(getPreparedRowData(row_data),column_names);
		
		table.getColumn("Actions").setCellRenderer(new ButtonRenderer());
		JScrollPane scrollPane = new JScrollPane(table);
		table.setFillsViewportHeight(true);
		
		this.add(scrollPane);
		
		setSize(800, 600);
		setTitle("List of citations");
	}
	
	private Object[][] getPreparedRowData(Object[][] row_data){
		
		for(int i=0;i<row_data.length;i++) {
			for(int j=0;j<row_data[0].length;j++) {
				if(j==0) {
					row_data[i][j] = citations.get(i).getID();
				}else if(j==1) {
					row_data[i][j] = citations.get(i).getTitle();
				}else if(j==2) {
					row_data[i][j] = "Remove";
				}
			}
		}
		
		return row_data;
	}
	
	private void loadCitations() throws Exception {
		
		Citation single_citation;
		//MainClass mc = new MainClass();
		Statement statement = MainClass.db_connection.createStatement();
		ResultSet result_set = statement.executeQuery("SELECT * FROM citation_db.citations");
		
		while(result_set.next()) {
			single_citation = new Citation();
			single_citation.setID(Integer.parseInt(result_set.getString("ID")));
			single_citation.setAuthors(result_set.getString("AUTHORS"));
			single_citation.setIsbn(result_set.getString("ISBN"));
			single_citation.setIssue(result_set.getString("ISSUE"));
			single_citation.setLocation(result_set.getString("LOCATION"));
			single_citation.setPages(result_set.getString("PAGES"));
			single_citation.setPublisher(result_set.getString("PUBLISHER"));
			single_citation.setSummary(result_set.getString("SUMMARY"));
			single_citation.setTitle(result_set.getString("TITLE"));
			single_citation.setVolume(result_set.getString("VOLUME"));
			single_citation.setYear(result_set.getString("YEAR"));
			citations.add(single_citation);
		}
	}
	
	class ListCitationTableColumnModel implements TableColumnModel{

		@Override
		public void addColumn(TableColumn aColumn) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void removeColumn(TableColumn column) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void moveColumn(int columnIndex, int newIndex) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void setColumnMargin(int newMargin) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public int getColumnCount() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public Enumeration<TableColumn> getColumns() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int getColumnIndex(Object columnIdentifier) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public TableColumn getColumn(int columnIndex) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int getColumnMargin() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public int getColumnIndexAtX(int xPosition) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public int getTotalColumnWidth() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public void setColumnSelectionAllowed(boolean flag) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public boolean getColumnSelectionAllowed() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public int[] getSelectedColumns() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int getSelectedColumnCount() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public void setSelectionModel(ListSelectionModel newModel) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public ListSelectionModel getSelectionModel() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void addColumnModelListener(TableColumnModelListener x) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void removeColumnModelListener(TableColumnModelListener x) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	class ListCitationTableModel implements TableModel{

		
		@Override
		public int getRowCount() {
			// TODO Auto-generated method stub
			return citations.size();
		}

		@Override
		public int getColumnCount() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public String getColumnName(int columnIndex) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Class<?> getColumnClass(int columnIndex) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean isCellEditable(int rowIndex, int columnIndex) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void addTableModelListener(TableModelListener l) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void removeTableModelListener(TableModelListener l) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	
}
