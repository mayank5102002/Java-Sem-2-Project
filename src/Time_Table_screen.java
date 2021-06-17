import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import java.awt.Font;
import java.awt.Window;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.border.CompoundBorder;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Time_Table_screen {

	public JFrame frmTimetableGenerator;
	private JButton teacherButton;
	private JButton classButton;
	private JComboBox comboBox;
	private JButton viewButton;
	private int numberOfSections;
	private String stream;
	private int i;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Time_Table_screen window = new Time_Table_screen(2,"SCIENCE");
					window.frmTimetableGenerator.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public Time_Table_screen(int n, String s) {
		
		numberOfSections = n;
		stream = s;
		
		frmTimetableGenerator = new JFrame();
		frmTimetableGenerator.setTitle("Time-Table Generator");
		frmTimetableGenerator.setResizable(false);
		frmTimetableGenerator.getContentPane().setBackground(Color.WHITE);
		frmTimetableGenerator.getContentPane().setForeground(new Color(0, 0, 0));
		frmTimetableGenerator.setBounds(100, 100, 1097, 777);
		frmTimetableGenerator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTimetableGenerator.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("TIMETABLE GENERATED SUCCESSFULLY");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel.setBounds(382, 39, 369, 63);
		frmTimetableGenerator.getContentPane().add(lblNewLabel);
		
		teacherButton = new JButton("TEACHER");
		teacherButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox.removeAllItems();
				if(stream.equals("SCIENCE")) {
					comboBox.addItem("Maths");
					comboBox.addItem("Physics");
					comboBox.addItem("Chemistry");
					comboBox.addItem("English");
					comboBox.addItem("Computer Sc.");
				}
				else if(stream.equals("COMMERCE")) {
					comboBox.addItem("Maths");
					comboBox.addItem("Accounts");
					comboBox.addItem("Business St.");
					comboBox.addItem("English");
					comboBox.addItem("Economics");
				}
				else if(stream.equals("HUMANITIES")) {
					comboBox.addItem("Maths");
					comboBox.addItem("Hindi");
					comboBox.addItem("Geography");
					comboBox.addItem("English");
					comboBox.addItem("Political Sc.");
				}
			
			}
		});
		teacherButton.setBackground(Color.WHITE);
		teacherButton.setForeground(Color.BLACK);
		teacherButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		teacherButton.setBounds(270, 196, 144, 51);
		frmTimetableGenerator.getContentPane().add(teacherButton);
		
		classButton = new JButton("SECTION");
		classButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox.removeAllItems();
	            for(i = 0; i<numberOfSections ; i++) {
	            	comboBox.addItem(i+1);
	            }
			}
		});
		classButton.setBackground(Color.WHITE);
		classButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		classButton.setForeground(Color.BLACK);
		classButton.setBounds(732, 196, 144, 51);
		frmTimetableGenerator.getContentPane().add(classButton);
		
		comboBox = new JComboBox();
		comboBox.setBounds(503, 350, 150, 30);
		frmTimetableGenerator.getContentPane().add(comboBox);
		
		viewButton = new JButton("View");
		viewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timeTableView view = new timeTableView();
				view.setVisible(true);
			}
		});
		viewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		viewButton.setBounds(520, 509, 133, 35);
		frmTimetableGenerator.getContentPane().add(viewButton);
		
		JButton backButton = new JButton("Go Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComponent comp = (JComponent) e.getSource();
				  Window win = SwingUtilities.getWindowAncestor(comp);
				  win.dispose();
			}
		});
		backButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		backButton.setBounds(836, 605, 121, 30);
		frmTimetableGenerator.getContentPane().add(backButton);
		
	}
}
