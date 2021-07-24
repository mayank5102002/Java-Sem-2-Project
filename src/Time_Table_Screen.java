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
import javax.swing.JOptionPane;
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
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class Time_Table_Screen {

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
	teacher teacher_1 = new teacher();
	teacher teacher_2 = new teacher();
	teacher teacher_3 = new teacher();
	teacher teacher_4 = new teacher();
	teacher teacher_5 = new teacher();
	private String selected = "teacher";
	static int[] def;
	String[][] table1 = new String[6][3];
	String[][] table2 = new String[6][3];
	int index;
	private JLabel background;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					def = new int[2];
					def[0] = 3;
					def[1] = 3;
					Time_Table_Screen window = new Time_Table_Screen(1,"SCIENCE","Default",def,def,def,def,def);
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
	public Time_Table_Screen(int n, String s,String na,int s1[],int[] s2,int[] s3,int[] s4,int[] s5) {
		
		numberOfSections = n;
		stream = s;
		name = na;
		getNames();
		try {
		teacher_1.teacherInput(numberOfSections, s1, teacher_2.t,teacher_3.t,teacher_4.t,teacher_5.t);}
		catch(ArrayIndexOutOfBoundsException e) {
			JOptionPane.showMessageDialog(null, "Time-Table can't be created!"
					+ "\nInvalid number of lectures added for " + subjects[0]
							+ "\nPlease change the number of lectures for " + subjects[0]);}
		try {
		teacher_2.teacherInput(numberOfSections, s2, teacher_1.t,teacher_3.t,teacher_4.t,teacher_5.t);}
		catch(ArrayIndexOutOfBoundsException e) {
			JOptionPane.showMessageDialog(null, "Time-Table can't be created!"
					+ "\nInvalid number of lectures added for " + subjects[1]
							+ "\nPlease change the number of lectures for " + subjects[1]);}
		try {
		teacher_3.teacherInput(numberOfSections, s3, teacher_1.t,teacher_2.t,teacher_4.t,teacher_5.t);}
		catch(ArrayIndexOutOfBoundsException e) {
			JOptionPane.showMessageDialog(null, "Time-Table can't be created!"
					+ "\nInvalid number of lectures added for " + subjects[2]
							+ "\nPlease change the number of lectures for " + subjects[2]);}
		try {
		teacher_4.teacherInput(numberOfSections, s4, teacher_1.t,teacher_2.t,teacher_3.t,teacher_5.t);}
		catch(ArrayIndexOutOfBoundsException e) {
			JOptionPane.showMessageDialog(null, "Time-Table can't be created!"
					+ "\nInvalid number of lectures added for " + subjects[3]
							+ "\nPlease change the number of lectures for " + subjects[3]);}
		try {
		teacher_5.teacherInput(numberOfSections, s5, teacher_1.t,teacher_2.t,teacher_3.t,teacher_4.t);}
		catch(ArrayIndexOutOfBoundsException e) {
			JOptionPane.showMessageDialog(null, "Time-Table can't be created!"
					+ "\nInvalid number of lectures added for " + subjects[4]
							+ "\nPlease change the number of lectures for " + subjects[4]);}
		
		section[] sections = new section[numberOfSections];
		for(int i=0 ; i<numberOfSections ; i++) {
			sections[i] = new section();
			sections[i].transfer(i+1, teacher_1.t, teacher_2.t,teacher_3.t, teacher_4.t, teacher_5.t);
		}
		frmTimetableGenerator = new JFrame();
		frmTimetableGenerator.setIconImage(Toolkit.getDefaultToolkit().getImage(Time_Table_Screen.class.getResource("/Images/saturday _icon.png")));
		frmTimetableGenerator.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frmTimetableGenerator.setTitle("Saturday: Timetable Planner");
		frmTimetableGenerator.setResizable(false);
		frmTimetableGenerator.getContentPane().setBackground(Color.WHITE);
		frmTimetableGenerator.getContentPane().setForeground(new Color(0, 0, 0));
		frmTimetableGenerator.setBounds(100, 100, 1097, 777);
		frmTimetableGenerator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTimetableGenerator.getContentPane().setLayout(null);
		
		teacherButton = new JButton("TEACHER");
		teacherButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selected = "teacher";
				comboBox.removeAllItems();
				for(int i=0;i<5;i++) {
					comboBox.addItem(teacherNames[i] + " - " + subjects[i]);
				}
			}
		});
		teacherButton.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		teacherButton.setBackground(Color.white);
		teacherButton.setForeground(Color.white);
		teacherButton.setOpaque(false);
		teacherButton.setContentAreaFilled(false);
		teacherButton.setBorderPainted(true);
		teacherButton.setBorder(new RoundedBorder(35));
		teacherButton.setBounds(582, 346, 150, 51);
		frmTimetableGenerator.getContentPane().add(teacherButton);
		
		classButton = new JButton("SECTION");
		classButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selected = "section";
				comboBox.removeAllItems();
	            for(i = 0; i<numberOfSections ; i++) {
	            	comboBox.addItem(i+1);
	            }
			}
		});
		classButton.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		classButton.setBackground(Color.white);
		classButton.setForeground(Color.white);
		classButton.setOpaque(false);
		classButton.setContentAreaFilled(false);
		classButton.setBorderPainted(true);
		classButton.setBorder(new RoundedBorder(35));
		classButton.setBounds(785, 346, 150, 51);
		frmTimetableGenerator.getContentPane().add(classButton);
		
		comboBox = new JComboBox();
		comboBox.setBounds(692, 468, 150, 30);
		frmTimetableGenerator.getContentPane().add(comboBox);
		for(int i=0;i<5;i++) {
			comboBox.addItem(teacherNames[i] + " - " + subjects[i]);
		}
		
		viewButton = new JButton("VIEW");
		viewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(selected.equals("teacher")) {
					index = comboBox.getSelectedIndex();
					if(index == 0) {
						int i,j,k,l;
						for(i=0 ; i<6 ; i++) {
							for(j=0 ; j<3 ; j++) {
								table1[i][j] = teacher_1.t[i][j];
							}
						}
						for(k=0,i=0 ; k<6 ; k++,i++) {
							for(l=0,j=3 ; l<3 ; l++,j++) {
								table2[k][l] = teacher_1.t[i][j];
							}
						}
					}
					if(index == 1) {
						int i,j,k,l;
						for(i=0 ; i<6 ; i++) {
							for(j=0 ; j<3 ; j++) {
								table1[i][j] = teacher_2.t[i][j];
							}
						}
						for(k=0,i=0 ; k<6 ; k++,i++) {
							for(l=0,j=3 ; l<3 ; l++,j++) {
								table2[k][l] = teacher_2.t[i][j];
							}
						}
					}
					if(index == 2) {
						int i,j,k,l;
						for(i=0 ; i<6 ; i++) {
							for(j=0 ; j<3 ; j++) {
								table1[i][j] = teacher_3.t[i][j];
							}
						}
						for(k=0,i=0 ; k<6 ; k++,i++) {
							for(l=0,j=3 ; l<3 ; l++,j++) {
								table2[k][l] = teacher_3.t[i][j];
							}
						}
					}
					if(index == 3) {
						int i,j,k,l;
						for(i=0 ; i<6 ; i++) {
							for(j=0 ; j<3 ; j++) {
								table1[i][j] = teacher_4.t[i][j];
							}
						}
						for(k=0,i=0 ; k<6 ; k++,i++) {
							for(l=0,j=3 ; l<3 ; l++,j++) {
								table2[k][l] = teacher_4.t[i][j];
							}
						}
					}
					if(index == 4) {
						int i,j,k,l;
						for(i=0 ; i<6 ; i++) {
							for(j=0 ; j<3 ; j++) {
								table1[i][j] = teacher_5.t[i][j];
							}
						}
						for(k=0,i=0 ; k<6 ; k++,i++) {
							for(l=0,j=3 ; l<3 ; l++,j++) {
								table2[k][l] = teacher_5.t[i][j];
							}
						}
					}
					for(int i=0 ; i<6 ; i++) {
						for(int j=0 ; j<3 ; j++) {
							if(table1[i][j].equals("0")) {
								table1[i][j] = "FREE";
							}
							else {
								table1[i][j] = "SECTION " + table1[i][j];
							}
							if(table2[i][j].equals("0")) {
								table2[i][j] = "FREE";
							}
							else {
								table2[i][j] = "SECTION " + table2[i][j];
							}
						}
					}
				}
				else if(selected.equals("section")) {
					index = comboBox.getSelectedIndex();
					int i,j,k,l;
					for(i=0 ; i<6 ; i++) {
						for(j=0 ; j<3 ; j++) {
							table1[i][j] = sections[index].s[i][j];
						}
					}
					for(k=0,i=0 ; k<6 ; k++,i++) {
						for(l=0,j=3 ; l<3 ; l++,j++) {
							table2[k][l] = sections[index].s[i][j];
						}
					}
					for(i=0 ; i<6 ; i++) {
						for(j=0 ; j<3 ; j++) {
							if(table1[i][j].equals("0")) {
								table1[i][j] = "FREE";
							}
							else if(table1[i][j].equals("1")) {
								table1[i][j] = subjects[0];
							}
							else if(table1[i][j].equals("2")) {
								table1[i][j] = subjects[1];
							}
							else if(table1[i][j].equals("3")) {
								table1[i][j] = subjects[2];
							}
							else if(table1[i][j].equals("4")) {
								table1[i][j] = subjects[3];
							}
							else if(table1[i][j].equals("5")) {
								table1[i][j] = subjects[4];
							}
							
							if(table2[i][j].equals("0")) {
								table2[i][j] = "FREE";
							}
							else if(table2[i][j].equals("1")) {
								table2[i][j] = subjects[0];
							}
							else if(table2[i][j].equals("2")) {
								table2[i][j] = subjects[1];
							}
							else if(table2[i][j].equals("3")) {
								table2[i][j] = subjects[2];
							}
							else if(table2[i][j].equals("4")) {
								table2[i][j] = subjects[3];
							}
							else if(table2[i][j].equals("5")) {
								table2[i][j] = subjects[4];
							}
						}
					}
				}
				timeTableView view = new timeTableView(numberOfSections,stream,name,s1,s2,s3,s4,s5,table1,table2);
				view.setVisible(true);
				JComponent comp = (JComponent) e.getSource();
				  Window win = SwingUtilities.getWindowAncestor(comp);
				  win.dispose();
			}
		});
		viewButton.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		viewButton.setBackground(Color.white);
		viewButton.setForeground(Color.white);
		viewButton.setOpaque(false);
		viewButton.setContentAreaFilled(false);
		viewButton.setBorderPainted(true);
		viewButton.setBorder(new RoundedBorder(35));
		viewButton.setBounds(692, 609, 145, 35);
		frmTimetableGenerator.getContentPane().add(viewButton);
		
		JButton backButton = new JButton("GO BACK");
		backButton.setBackground(Color.WHITE);
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComponent comp = (JComponent) e.getSource();
				  Window win = SwingUtilities.getWindowAncestor(comp);
				  win.dispose();
				  lectures frame = new lectures(numberOfSections, stream,name);
					frame.setVisible(true);
			}
		});

		backButton.setBounds(692, 673, 145, 35);
		backButton.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		backButton.setBackground(Color.white);
		backButton.setForeground(Color.white);
		backButton.setOpaque(false);
		backButton.setContentAreaFilled(false);
		backButton.setBorderPainted(true);
		backButton.setBorder(new RoundedBorder(35));
		frmTimetableGenerator.getContentPane().add(backButton);
		
		background = new JLabel("");
		background.setIcon(new ImageIcon(Time_Table_Screen.class.getResource("/Images/Copy of Enjoy fantastic deals and big discounts (3).png")));
		background.setBounds(-101, -13, 1667, 924);
		frmTimetableGenerator.getContentPane().add(background);
		
	}
}