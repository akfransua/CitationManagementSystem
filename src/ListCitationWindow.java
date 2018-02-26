import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ListCitationWindow extends JFrame {

	private ArrayList<Citation> citations;

	public ListCitationWindow() {

		citations = new ArrayList<Citation>();
		try {
			loadCitations();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		String[] column_names = { "ID", "Citation Title", "Edit", "Delete" };
		Object[][] row_data = new Object[citations.size()][column_names.length];

		DefaultTableModel model = new DefaultTableModel(getPreparedRowData(row_data), column_names);
		JTable table = new JTable(model);
		Action delete = new AbstractAction() {
			public void actionPerformed(ActionEvent e) {

				int selected_option = JOptionPane.showConfirmDialog(ListCitationWindow.this,
						"Are you sure to delete the citation?", "Delete confirmation", JOptionPane.YES_NO_OPTION);
				if (selected_option == JOptionPane.YES_OPTION) {
					JTable table = (JTable) e.getSource();
					int modelRow = Integer.valueOf(e.getActionCommand());
					DefaultTableModel table_model = (DefaultTableModel) table.getModel();
					int citation_id = (Integer) table_model.getValueAt(modelRow, 0);
					table_model.removeRow(modelRow);
					deleteCitationDB(citation_id);

				} else {
					return;
				}

			}
		};

		Action edit = new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				int modelRow = Integer.valueOf(e.getActionCommand());
				DefaultTableModel table_model = (DefaultTableModel) table.getModel();
				int citation_id = (Integer) table_model.getValueAt(modelRow, 0);

				JOptionPane.showMessageDialog(ListCitationWindow.this,
						"Edit option for citation#" + citation_id + " will be displayed");
			}
		};

		Action citation_Detail = new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				int modelRow = Integer.valueOf(e.getActionCommand());
				DefaultTableModel table_model = (DefaultTableModel) table.getModel();
				int citation_id = (Integer) table_model.getValueAt(modelRow, 0);

				JOptionPane.showMessageDialog(ListCitationWindow.this,
						"Edit option for citation#" + citation_id + " will be displayed");
			}
		};

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if (e.getClickCount() == 1) {
					JTable target = (JTable) e.getSource();

					int column = target.getSelectedColumn();
					if (column == 1) {
						int row = target.getSelectedRow();

						//System.out.println("clicekd on table" + row);
						Object citeTile = table.getValueAt(row, column);
						Object citeId = table.getValueAt(row, 0);
						//System.out.println("clicekd on table" + citeTile.toString() + citeId.toString());

						CitationDetail cd = new CitationDetail(citeId, citeTile, citations);
						cd.setVisible(true);
					}
					// do some stuff

				}
			}
		});

		ButtonColumn buttonColumn_edit = new ButtonColumn(table, edit, 2);
		ButtonColumn buttonColumn_delete = new ButtonColumn(table, delete, 3);

		JScrollPane scrollPane = new JScrollPane(table);
		table.setFillsViewportHeight(true);

		this.add(scrollPane);

		setSize(800, 600);
		setTitle("List of citations");
	}

	private void deleteCitationDB(int citationID) {
		try {
			// ModelLayer model_layer = new ModelLayer();

			Connection conn = ModelLayer.getConnectionObj();
			Statement statement = conn.createStatement();
			statement.executeUpdate("Delete from citations where ID=\'" + citationID + "\'");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private Object[][] getPreparedRowData(Object[][] row_data) {

		for (int i = 0; i < row_data.length; i++) {
			for (int j = 0; j < row_data[0].length; j++) {
				if (j == 0) {
					row_data[i][j] = citations.get(i).getID();
				} else if (j == 1) {
					row_data[i][j] = citations.get(i).getTitle();
				} else if (j == 2) {
					row_data[i][j] = "Edit";
				} else if (j == 3) {
					row_data[i][j] = "Delete";
				}
			}
		}

		return row_data;
	}

	private void loadCitations() throws Exception {

		Citation single_citation;
		Statement statement = MainClass.db_connection.createStatement();
		ResultSet result_set = statement.executeQuery("SELECT * FROM citation_Management.citations");

		while (result_set.next()) {
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

}
