
import java.awt.*;
import java.awt.event.*;
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
	JTextField tFieldEditor;
	JTextField tFieldPublisher;
	JTextField tFieldVolume;
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
		tFieldId.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tArea.append("\nYou have typed " + tFieldId.getText());
			}
		});

		// Regular text field (Row 1)
		tfPanel.add(new JLabel("  Author(s): "));
		tFieldAuthor = new JTextField(20);
		tfPanel.add(tFieldAuthor);
		tFieldAuthor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tArea.append("\nYou have typed " + tFieldAuthor.getText());
			}
		});

		// Regular text field (Row 1)
		tfPanel.add(new JLabel(" Title: "));
		tFieldTitle = new JTextField(20);
		tfPanel.add(tFieldTitle);
		tFieldTitle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tArea.append("\nYou have typed " + tFieldTitle.getText());
			}
		});

		tfPanel.add(new JLabel(" Location: "));
		tFieldLocation = new JTextField(20);
		tfPanel.add(tFieldLocation);
		tFieldLocation.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tArea.append("\nYou have typed " + tFieldLocation.getText());
			}
		});

		tfPanel.add(new JLabel(" Year: "));
		tFieldYear = new JTextField(20);
		tfPanel.add(tFieldYear);
		tFieldYear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tArea.append("\nYou have typed " + tFieldYear.getText());
			}
		});

		tfPanel.add(new JLabel(" Editor: "));
		tFieldEditor = new JTextField(20);
		tfPanel.add(tFieldEditor);
		tFieldEditor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tArea.append("\nYou have typed " + tFieldEditor.getText());
			}
		});

		tfPanel.add(new JLabel(" Pages: "));
		tFieldPages = new JTextField(20);
		tfPanel.add(tFieldPages);
		tFieldPages.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tArea.append("\nYou have typed " + tFieldPages.getText());
			}
		});

		tfPanel.add(new JLabel(" Month: "));
		tFieldMonth = new JTextField(20);
		tfPanel.add(tFieldMonth);
		tFieldMonth.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tArea.append("\nYou have typed " + tFieldMonth.getText());
			}
		});

		tfPanel.add(new JLabel(" Publisher: "));
		tFieldPublisher = new JTextField(20);
		tfPanel.add(tFieldPublisher);
		tFieldPublisher.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tArea.append("\nYou have typed " + tFieldPublisher.getText());
			}
		});

		tfPanel.add(new JLabel(" Issue: "));
		tFieldIssue = new JTextField(20);
		tfPanel.add(tFieldIssue);
		tFieldIssue.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tArea.append("\nYou have typed " + tFieldIssue.getText());
			}
		});

		tfPanel.add(new JLabel(" ISSN: "));
		tFieldISSN = new JTextField(20);
		tfPanel.add(tFieldISSN);
		tFieldISSN.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tArea.append("\nYou have typed " + tFieldISSN.getText());
			}
		});

		// Password field (Row 2)
		tfPanel.add(new JLabel("  JPasswordField: "));
		/*
		 * pwField = new JPasswordField(20); tfPanel.add(pwField);
		 * pwField.addActionListener(new ActionListener() {
		 * 
		 * @Override public void actionPerformed(ActionEvent e) {
		 * tArea.append("\nYou password is " + new
		 * String(pwField.getPassword())); } });
		 */

		// JPanel buttonPanel = new JPanel();
		// buttonPanel.setLayout(null);
		buttonPanel.setLocation(40, 200);
		buttonPanel.setSize(250, 100);
		// totalGUI.add(buttonPanel);

		// We create a button and manipulate it using the syntax we have
		// used before.
		JButton Save = new JButton("Save");
		// Save.setLocation(20, 20);
		// Save.setSize(100, 30);
		// buttonPanel.add(Save);

		JButton cancel = new JButton("Cancel");
		// cancel.setLocation(140, 20);
		// cancel.setSize(100, 30);
		// buttonPanel.add(cancel);

		JButton resetButton = new JButton("Reset/Clear Text");
		// resetButton.setLocation(20, 60);
		// resetButton.setSize(220, 30);
		buttonPanel.add(resetButton);

		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.LINE_AXIS));
		buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
		buttonPanel.add(Box.createHorizontalGlue());
		buttonPanel.add(cancel);
		buttonPanel.add(Box.createRigidArea(new Dimension(10, 0)));
		buttonPanel.add(Save);

		// buttonPanel.add(new JButton(" Cancle: "));
		// buttonPanel.add(new JButton(" Save: "));

		/*
		 * 
		 * // Formatted text field (Row 3) tfPanel.add(new
		 * JLabel("  JFormattedTextField ")); formattedField = new
		 * JFormattedTextField(java.util.Calendar .getInstance().getTime());
		 * tfPanel.add(formattedField);
		 */
		// Create a JTextArea
		tArea = new JTextArea("A JTextArea is a \"plain\" editable text component, "
				+ "which means that although it can display text "
				+ "in any font, all of the text is in the same font.");
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
		setTitle("JTextComponent Demo");
		setSize(1000, 1000);
		//setVisible(true);
	}

	/** The entry main() method */
	/*public static void main(String[] args) {
		// Run GUI codes in Event-Dispatching thread for thread safety
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new AddCitationWindow(); // Let the constructor do the job
			}
		});
	}*/
}