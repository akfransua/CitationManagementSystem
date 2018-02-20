
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.*;

/** Test JTextField, JPasswordField, JFormattedTextField, JTextArea */
@SuppressWarnings("serial")
public class AddCitationWindow extends JFrame {

	// Private variables of the GUI components
	JTextField tFieldId;
	JTextField tFieldAuthor;
	JTextField tFieldTitle;
	JTextField tFieldLocation;
	JTextField tFieldYear;
	JTextField tFieldVolume;
	JTextField tFieldPublisher;
	JTextField tFieldIssue;
	JTextField tFieldPages;
	JTextField tFieldISSN;

	JPasswordField pwField;
	JTextArea tArea;
	JFormattedTextField formattedField;
	private JTextField tFieldMonth;

	/** Constructor to set up all the GUI components */
	public AddCitationWindow() {
		// JPanel for the text fields
		JPanel tfPanel = new JPanel(new GridLayout(12, 2, 10, 2));
		JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
		tfPanel.setBorder(BorderFactory.createTitledBorder("Enter  Reference Details: "));

		// Regular text field (Row 1)
		tfPanel.add(new JLabel("  Unique Key: "));
		tFieldId = new JTextField(20);
		tfPanel.add(tFieldId);

		// Regular text field (Row 1)
		tfPanel.add(new JLabel("  Author(s): "));
		tFieldAuthor = new JTextField(20);
		tfPanel.add(tFieldAuthor);


		// Regular text field (Row 1)
		tfPanel.add(new JLabel(" Title: "));
		tFieldTitle = new JTextField(20);
		tfPanel.add(tFieldTitle);
		

		tfPanel.add(new JLabel(" Location: "));
		tFieldLocation = new JTextField(20);
		tfPanel.add(tFieldLocation);
	

		tfPanel.add(new JLabel(" Year: "));
		tFieldYear = new JTextField(20);
		tfPanel.add(tFieldYear);
		

		tfPanel.add(new JLabel(" Volume: "));
		tFieldVolume = new JTextField(20);
		tfPanel.add(tFieldVolume);
	

		tfPanel.add(new JLabel(" Pages: "));
		tFieldPages = new JTextField(20);
		tfPanel.add(tFieldPages);
	

		tfPanel.add(new JLabel(" Month: "));
		tFieldMonth = new JTextField(20);
		tfPanel.add(tFieldMonth);
		

		tfPanel.add(new JLabel(" Publisher: "));
		tFieldPublisher = new JTextField(20);
		tfPanel.add(tFieldPublisher);
		

		tfPanel.add(new JLabel(" Issue: "));
		tFieldIssue = new JTextField(20);
		tfPanel.add(tFieldIssue);
		

		tfPanel.add(new JLabel(" ISSN: "));
		tFieldISSN = new JTextField(20);
		tfPanel.add(tFieldISSN);

		
		//Buttons
		buttonPanel.setLocation(40, 200);
		buttonPanel.setSize(250, 100);
		JButton save = new JButton("Save");
		save.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				insert();
			}

		});

		JButton cancel = new JButton("Cancel");
		cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});



		JButton resetButton = new JButton("Reset/Clear Text");
		resetButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				tFieldTitle.setText("");

				tFieldId.setText("");
				tFieldLocation.setText("");
				tFieldAuthor.setText("");
				tFieldVolume.setText("");
				tFieldISSN.setText("");
				tFieldMonth.setText("");
				tFieldISSN.setText("");
				tFieldIssue.setText("");
				tFieldYear.setText("");
				tFieldTitle.setText("");
				tFieldPages.setText("");
				tFieldPublisher.setText("");
				/// tFieldVolume.setText("");

			}
		});

		buttonPanel.add(resetButton);
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.LINE_AXIS));
		buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
		buttonPanel.add(Box.createHorizontalGlue());
		buttonPanel.add(cancel);
		buttonPanel.add(Box.createRigidArea(new Dimension(10, 0)));
		buttonPanel.add(save);

		tArea = new JTextArea();
		tArea.setFont(new Font("Serif", Font.ITALIC, 13));
		tArea.setLineWrap(true); // wrap line
		tArea.setWrapStyleWord(true); // wrap line at word boundary
		tArea.setBackground(new Color(204, 238, 241)); // light blue
		// Wrap the JTextArea inside a JScrollPane
		tArea.setSize(20, 50);
		JScrollPane tAreaScrollPane = new JScrollPane(tArea);

		tAreaScrollPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		tAreaScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		tAreaScrollPane.setPreferredSize(new Dimension(1000, 300));
		tAreaScrollPane.setAlignmentX(LEFT_ALIGNMENT);
		// tAreaScrollPane.setSize(100,20);
		JPanel scrolpan = new JPanel();
		scrolpan.add(new JLabel("Abstract\'Summary"));
		scrolpan.add(tAreaScrollPane);
		// scrolpan.add(buttonPanel);
		// Setup the content-pane of JFrame in BorderLayout
		// tfPanel.add(buttonPanel);

		// Lay out the label and scroll pane from top to bottom.
		JPanel listPane = new JPanel();
		listPane.setLayout(new BoxLayout(listPane, BoxLayout.PAGE_AXIS));
		listPane.add(tfPanel);
		listPane.add(Box.createRigidArea(new Dimension(0, 5)));
		listPane.add(scrolpan);
		listPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		// Put everything together, using the content pane's BorderLayout.
		Container contentPane = getContentPane();
		contentPane.add(listPane, BorderLayout.CENTER);
		contentPane.add(buttonPanel, BorderLayout.PAGE_END);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Add Citation Window");
		setSize(1000, 1000);
		// setVisible(true);
	}

	//save to database
	public void insert() {
		try {
			// connection string
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			

			Statement st = MainClass.db_connection.createStatement();
			st.execute(
					"INSERT INTO  citations (ID, TITLE, AUTHORS, PUBLISHER, LOCATION, VOLUME, ISSUE, PAGES, YEAR, ISBN, SUMMARY) values('"
							+ Integer.parseInt(tFieldId.getText()) + "','" + tFieldTitle.getText() + "','" + tFieldAuthor.getText()
							+ "','" + tFieldPublisher.getText() + "','" + tFieldLocation.getText() + "','"
							+ tFieldVolume.getText() + "','" + tFieldIssue.getText() + "','" + tFieldPages.getText()
							+ "','" + tFieldYear.getText() + "','" + tFieldISSN.getText() + "','"
							+ tArea.getText() + " ')");

			JOptionPane.showConfirmDialog(null, "Your Data Has been Inserted", "Result", JOptionPane.DEFAULT_OPTION,
					JOptionPane.PLAIN_MESSAGE);

			st.close();
			//con.close();

		}

		catch (Exception e1)

		{
			System.out.println("Exception:" + e1);
		}

	}

	/**
	 * The entry main() method public static void main(String[] args) { // Run GUI
	 * codes in Event-Dispatching thread for thread safety
	 * SwingUtilities.invokeLater(new Runnable() {
	 * 
	 * @Override public void run() { new AddCitationWindow(); // Let the constructor
	 *           do the job } });
	 */
	// }

}