import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Window;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import javax.swing.event.ChangeListener;

import database.connection;

import javax.swing.event.ChangeEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.border.Border;
import java.awt.Toolkit;

class RoundedBorder implements Border {

    private int radius;
    RoundedBorder(int radius) {
        this.radius = radius;
    }
    public Insets getBorderInsets(Component c) {
        return new Insets(this.radius+1, this.radius+1, this.radius+2, this.radius);
    }
    public boolean isBorderOpaque() {
        return true;
    }
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        g.drawRoundRect(x, y, width-1, height-1, radius, radius);
    }
}

public class lectures extends JFrame {

	private JPanel contentPane;
	private int numberOfSections;
	private String stream;
	private JLabel subject_1;
	private JLabel subject_2;
	private JLabel subject_3;
	private JLabel subject_4;
	private JLabel subject_5;
	private JComboBox subject_1comboBox;
	private JComboBox subject_2comboBox;
	private JComboBox subject_3comboBox;
	private JComboBox subject_4comboBox;
	private JComboBox subject_5comboBox;
	private JSlider slider_subject1;
	private JSlider slider_subject2;
	private JSlider slider_subject3;
	private JSlider slider_subject4;
	private JSlider slider_subject5;
	private JLabel lectures_1;
	private JLabel lectures_2;
	private JLabel lectures_3;
	private JLabel lectures_4;
	private JLabel lectures_5;
	private JButton GenerateButton;
	private int i;
	private JButton backButton;
	private int[] subject1;
	private int[] subject2;
	private int[] subject3;
	private int[] subject4;
	private int[] subject5;
	private int current = 0;
	private String name;
	private JTextField teacher_1;
	private JTextField teacher_2;
	private JTextField teacher_3;
	private JTextField teacher_4;
	private JTextField teacher_5;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					lectures frame = new lectures(1,"SCIENCE","Default");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void delete() {
		try {
			Connection con = connection.teacherNamesConnect();
			PreparedStatement pst = con.prepareStatement("CREATE TABLE IF NOT EXISTS names(name TEXT NOT NULL,subject TEXT NOT NULL)");
			pst.executeUpdate();
			pst = con.prepareStatement("DELETE FROM names");
			pst.executeUpdate();
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	public void enterNames(String name,String subject) {
		try {
		Connection con = connection.teacherNamesConnect();
		PreparedStatement pst = con.prepareStatement("INSERT INTO names(name,subject) VALUES(?,?)");
		pst.setString(1, name);
		pst.setString(2, subject);
		pst.executeUpdate();
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	/**
	 * Create the frame.
	 */
	public lectures(int n,String s,String na) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(lectures.class.getResource("/Images/saturday _icon.png")));
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setTitle("Saturday: Timetable Planner");
		setResizable(false);
		this.numberOfSections = n;
		this.stream = s;
		this.name = na;
		
		subject1 = new int[numberOfSections];
		subject2 = new int[numberOfSections];
		subject3 = new int[numberOfSections];
		subject4 = new int[numberOfSections];
		subject5 = new int[numberOfSections];
		for(i=0 ; i<numberOfSections ; i++) {
			subject1[i] = 3;
		}
		for(i=0 ; i<numberOfSections ; i++) {
			subject2[i] = 3;
		}
		for(i=0 ; i<numberOfSections ; i++) {
			subject3[i] = 3;
		}
		for(i=0 ; i<numberOfSections ; i++) {
			subject4[i] = 3;
		}
		for(i=0 ; i<numberOfSections ; i++) {
			subject5[i] = 3;
		}
		
		lectures_1 = new JLabel("3");
		lectures_2 = new JLabel("3");
		lectures_3 = new JLabel("3");
		lectures_4 = new JLabel("3");
		lectures_5 = new JLabel("3");
		
		subject_1 = new JLabel();
		subject_2 = new JLabel();
		subject_3 = new JLabel();
		subject_4 = new JLabel();
		subject_5 = new JLabel();
		
		if(stream.equals("SCIENCE")) {
			subject_1.setText("Maths");
			subject_2.setText("Physics");
			subject_3.setText("Chemistry");
			subject_4.setText("English");
			subject_5.setText("Computer Sc.");
		}
		else if(stream.equals("COMMERCE")) {
			subject_1.setText("Maths");
			subject_2.setText("Accounts");
			subject_3.setText("Business St.");
			subject_4.setText("English");
			subject_5.setText("Economics");
		}
		else if(stream.equals("HUMANITIES")) {
			subject_1.setText("Maths");
			subject_2.setText("Hindi");
			subject_3.setText("Geography");
			subject_4.setText("English");
			subject_5.setText("Political Sc.");
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1435, 958);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		subject_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		subject_1.setBounds(178, 392, 172, 30);
		contentPane.add(subject_1);
		
		subject_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		subject_2.setBounds(178, 453, 172, 30);
		contentPane.add(subject_2);
		
		subject_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		subject_3.setBounds(178, 516, 172, 30);
		contentPane.add(subject_3);
		
		subject_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		subject_4.setBounds(178, 574, 172, 30);
		contentPane.add(subject_4);
		
		subject_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		subject_5.setBounds(178, 634, 172, 30);
		contentPane.add(subject_5);
		
		slider_subject1 = new JSlider();
		slider_subject2 = new JSlider();
		slider_subject3 = new JSlider();
		slider_subject4 = new JSlider();
		slider_subject5 = new JSlider();
		
		subject_1comboBox = new JComboBox();
		subject_1comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				current = (int) subject_1comboBox.getSelectedItem() - 1;
				slider_subject1.setValue(subject1[current]);
			}
		});
		subject_1comboBox.setBounds(475, 392, 40, 30);
		for(i = 0; i<numberOfSections ; i++) {
			subject_1comboBox.addItem(i+1);
		}
		contentPane.add(subject_1comboBox);
		
		subject_2comboBox = new JComboBox();
		subject_2comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				current = (int) subject_2comboBox.getSelectedItem() - 1;
				slider_subject2.setValue(subject2[current]);
			}
		});
		subject_2comboBox.setBounds(475, 453, 40, 30);
		for(i = 0; i<numberOfSections ; i++) {
			subject_2comboBox.addItem(i+1);
		}
		contentPane.add(subject_2comboBox);
		
		subject_3comboBox = new JComboBox();
		subject_3comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				current = (int) subject_3comboBox.getSelectedItem() - 1;
				slider_subject3.setValue(subject3[current]);
			}
		});
		subject_3comboBox.setBounds(475, 516, 40, 30);
		for(i = 0; i<numberOfSections ; i++) {
			subject_3comboBox.addItem(i+1);
		}
		contentPane.add(subject_3comboBox);
		
		subject_4comboBox = new JComboBox();
		subject_4comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				current = (int) subject_4comboBox.getSelectedItem() - 1;
				slider_subject4.setValue(subject4[current]);
			}
		});
		subject_4comboBox.setBounds(475, 574, 40, 30);
		for(i = 0; i<numberOfSections ; i++) {
			subject_4comboBox.addItem(i+1);
		}
		contentPane.add(subject_4comboBox);
		
		subject_5comboBox = new JComboBox();
		subject_5comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				current = (int) subject_5comboBox.getSelectedItem() - 1;
				slider_subject5.setValue(subject5[current]);
			}
		});
		subject_5comboBox.setBounds(475, 634, 40, 30);
		for(i = 0; i<numberOfSections ; i++) {
			subject_5comboBox.addItem(i+1);
		}
		contentPane.add(subject_5comboBox);
		
		slider_subject1.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				lectures_1.setText(Integer.toString(slider_subject1.getValue()));
				current = (int) subject_1comboBox.getSelectedItem() - 1;
				subject1[current] = slider_subject1.getValue();
			}
		});
		slider_subject1.setValueIsAdjusting(true);
		slider_subject1.setValue(3);
		slider_subject1.setSnapToTicks(true);
		slider_subject1.setPaintTicks(true);
		slider_subject1.setMinorTickSpacing(1);
		slider_subject1.setMinimum(3);
		slider_subject1.setMaximum(8);
		slider_subject1.setMajorTickSpacing(1);
		slider_subject1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		slider_subject1.setBounds(679, 392, 200, 30);
		contentPane.add(slider_subject1);
		
		slider_subject2.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				lectures_2.setText(Integer.toString(slider_subject2.getValue()));
				current = (int) subject_2comboBox.getSelectedItem() - 1;
				subject2[current] = slider_subject2.getValue();
			}
		});
		slider_subject2.setValueIsAdjusting(true);
		slider_subject2.setValue(3);
		slider_subject2.setSnapToTicks(true);
		slider_subject2.setPaintTicks(true);
		slider_subject2.setMinorTickSpacing(1);
		slider_subject2.setMinimum(3);
		slider_subject2.setMaximum(8);
		slider_subject2.setMajorTickSpacing(1);
		slider_subject2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		slider_subject2.setBounds(679, 453, 200, 30);
		contentPane.add(slider_subject2);
		
		slider_subject3.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				lectures_3.setText(Integer.toString(slider_subject3.getValue()));
				current = (int) subject_3comboBox.getSelectedItem() - 1;
				subject3[current] = slider_subject3.getValue();
			}
		});
		slider_subject3.setValueIsAdjusting(true);
		slider_subject3.setValue(3);
		slider_subject3.setSnapToTicks(true);
		slider_subject3.setPaintTicks(true);
		slider_subject3.setMinorTickSpacing(1);
		slider_subject3.setMinimum(3);
		slider_subject3.setMaximum(8);
		slider_subject3.setMajorTickSpacing(1);
		slider_subject3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		slider_subject3.setBounds(679, 516, 200, 30);
		contentPane.add(slider_subject3);
		
		slider_subject4.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				lectures_4.setText(Integer.toString(slider_subject4.getValue()));
				current = (int) subject_4comboBox.getSelectedItem() - 1;
				subject4[current] = slider_subject4.getValue();
			}
		});
		slider_subject4.setValueIsAdjusting(true);
		slider_subject4.setValue(3);
		slider_subject4.setSnapToTicks(true);
		slider_subject4.setPaintTicks(true);
		slider_subject4.setMinorTickSpacing(1);
		slider_subject4.setMinimum(3);
		slider_subject4.setMaximum(8);
		slider_subject4.setMajorTickSpacing(1);
		slider_subject4.setFont(new Font("Tahoma", Font.PLAIN, 10));
		slider_subject4.setBounds(679, 574, 200, 30);
		contentPane.add(slider_subject4);
		
		slider_subject5.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				lectures_5.setText(Integer.toString(slider_subject5.getValue()));
				current = (int) subject_5comboBox.getSelectedItem() - 1;
				subject5[current] = slider_subject5.getValue();
			}
		});
		slider_subject5.setValueIsAdjusting(true);
		slider_subject5.setValue(3);
		slider_subject5.setSnapToTicks(true);
		slider_subject5.setPaintTicks(true);
		slider_subject5.setMinorTickSpacing(1);
		slider_subject5.setMinimum(3);
		slider_subject5.setMaximum(8);
		slider_subject5.setMajorTickSpacing(1);
		slider_subject5.setFont(new Font("Tahoma", Font.PLAIN, 10));
		slider_subject5.setBounds(679, 634, 200, 30);
		contentPane.add(slider_subject5);
		
		lectures_1.setHorizontalTextPosition(SwingConstants.LEFT);
		lectures_1.setHorizontalAlignment(SwingConstants.LEFT);
		lectures_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lectures_1.setBounds(955, 390, 32, 30);
		contentPane.add(lectures_1);
		
		lectures_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lectures_2.setBounds(955, 451, 32, 30);
		contentPane.add(lectures_2);
		
		lectures_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lectures_3.setBounds(955, 508, 32, 30);
		contentPane.add(lectures_3);
		
		lectures_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lectures_4.setBounds(955, 571, 32, 30);
		contentPane.add(lectures_4);
		
		lectures_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lectures_5.setBounds(955, 634, 32, 30);
		contentPane.add(lectures_5);
		
		GenerateButton = new JButton("GENERATE");
		GenerateButton.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		GenerateButton.setBackground(Color.white);
		GenerateButton.setForeground(Color.white);
		GenerateButton.setOpaque(false);
		GenerateButton.setContentAreaFilled(false);
		GenerateButton.setBorderPainted(true);
		GenerateButton.setBorder(new RoundedBorder(35));
		teacher_1 = new JTextField();
		teacher_2 = new JTextField();
		teacher_3 = new JTextField();
		teacher_4 = new JTextField();
		teacher_5 = new JTextField();
		
		GenerateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String teacherName1 = teacher_1.getText();
				String teacherName2 = teacher_2.getText();
				String teacherName3 = teacher_3.getText();
				String teacherName4 = teacher_4.getText();
				String teacherName5 = teacher_5.getText();
				delete();
				enterNames(teacherName1,subject_1.getText());
				enterNames(teacherName2,subject_2.getText());
				enterNames(teacherName3,subject_3.getText());
				enterNames(teacherName4,subject_4.getText());
				enterNames(teacherName5,subject_5.getText());
				Time_Table_Screen screen = new Time_Table_Screen(numberOfSections,stream,name,subject1,subject2,subject3,subject4,subject5);
				screen.frmTimetableGenerator.setVisible(true);
				JComponent comp = (JComponent) e.getSource();
				  Window win = SwingUtilities.getWindowAncestor(comp);
				  win.dispose();
			}
		});
		GenerateButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GenerateButton.setBounds(565, 706, 181, 30);
		contentPane.add(GenerateButton);
		
		backButton = new JButton("GO BACK");
		backButton.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		backButton.setBackground(Color.white);
		backButton.setForeground(Color.white);
		backButton.setOpaque(false);
		backButton.setContentAreaFilled(false);
		backButton.setBorderPainted(true);
		backButton.setBorder(new RoundedBorder(35));
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComponent comp = (JComponent) e.getSource();
				  Window win = SwingUtilities.getWindowAncestor(comp);
				  win.dispose();
				  MainWindow main = new MainWindow(name);
					main.frmTimetableGenerator.setVisible(true);
			}
		});
		backButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		backButton.setBounds(815, 706, 172, 30);
		contentPane.add(backButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblNewLabel.setBounds(290, 50, 814, 30);
		contentPane.add(lblNewLabel);
		
		teacher_1.setToolTipText("Enter the name of the Teacher");
		teacher_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		teacher_1.setBounds(1121, 391, 229, 30);
		contentPane.add(teacher_1);
		teacher_1.setColumns(10);
		
		teacher_2.setToolTipText("Enter the name of the Teacher");
		teacher_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		teacher_2.setColumns(10);
		teacher_2.setBounds(1121, 452, 229, 30);
		contentPane.add(teacher_2);
		
		teacher_3.setToolTipText("Enter the name of the Teacher");
		teacher_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		teacher_3.setColumns(10);
		teacher_3.setBounds(1121, 509, 229, 30);
		contentPane.add(teacher_3);
		
		teacher_4.setToolTipText("Enter the name of the Teacher");
		teacher_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		teacher_4.setColumns(10);
		teacher_4.setBounds(1121, 572, 229, 30);
		contentPane.add(teacher_4);
		
		teacher_5.setToolTipText("Enter the name of the Teacher");
		teacher_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		teacher_5.setColumns(10);
		teacher_5.setBounds(1121, 635, 229, 30);
		contentPane.add(teacher_5);
		
		lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(lectures.class.getResource("/Images/MainWindow_bg.png")));
		lblNewLabel_1.setBounds(-59, -7, 2100, 1000);
		contentPane.add(lblNewLabel_1);
	}
}