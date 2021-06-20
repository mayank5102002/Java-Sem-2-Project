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

import database.connection;

import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
	private String name;
	private String[] teacherNames = new String[5];
	private String[] subjects = new String[5];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Time_Table_screen window = new Time_Table_screen(2,"SCIENCE","Default");
					window.frmTimetableGenerator.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void getNames() {
		try {
		Connection con = connection.teacherNamesConnect();
		PreparedStatement pst = con.prepareStatement("SELECT * FROM names");
		ResultSet r = pst.executeQuery();
		int i = 0;
		while(r.next()) {
			teacherNames[i] = r.getString("name");
			subjects[i] = r.getString("subject");
			i++;
		}
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	/**
	 * Initialize the contents of the frame.
	 */
	public Time_Table_screen(int n, String s,String na) {
		
		numberOfSections = n;
		stream = s;
		name = na;
		
		frmTimetableGenerator = new JFrame();
		frmTimetableGenerator.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frmTimetableGenerator.setTitle("Time-Table Generator");
		frmTimetableGenerator.setResizable(false);
		frmTimetableGenerator.getContentPane().setBackground(Color.WHITE);
		frmTimetableGenerator.getContentPane().setForeground(new Color(0, 0, 0));
		frmTimetableGenerator.setBounds(100, 100, 1097, 777);
		frmTimetableGenerator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTimetableGenerator.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("TIMETABLE GENERATED SUCCESSFULLY");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(282, 36, 594, 63);
		frmTimetableGenerator.getContentPane().add(lblNewLabel);
		
		teacherButton = new JButton("TEACHER");
		teacherButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox.removeAllItems();
				getNames();
				for(int i=0;i<5;i++) {
					comboBox.addItem(teacherNames[i] + " - " + subjects[i]);
				}
			}
		});
		teacherButton.setBackground(Color.WHITE);
		teacherButton.setForeground(Color.BLACK);
		teacherButton.setFont(new Font("Tahoma", Font.BOLD, 15));
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
		classButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		classButton.setForeground(Color.BLACK);
		classButton.setBounds(732, 196, 144, 51);
		frmTimetableGenerator.getContentPane().add(classButton);
		
		comboBox = new JComboBox();
		comboBox.setBounds(503, 350, 150, 30);
		frmTimetableGenerator.getContentPane().add(comboBox);
		
		viewButton = new JButton("View");
		viewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timeTableView view = new timeTableView(numberOfSections,stream,name);
				view.setVisible(true);
				JComponent comp = (JComponent) e.getSource();
				  Window win = SwingUtilities.getWindowAncestor(comp);
				  win.dispose();
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
				  lectures frame = new lectures(numberOfSections, stream,name);
					frame.setVisible(true);
			}
		});
		backButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		backButton.setBounds(836, 605, 121, 30);
		frmTimetableGenerator.getContentPane().add(backButton);
		
	}
}
