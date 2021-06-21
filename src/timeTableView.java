import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import java.awt.GridLayout;
import java.awt.Window;
import java.awt.geom.Rectangle2D;

import javax.swing.JTable;
import java.awt.Dimension;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class timeTableView extends JFrame {

	private JPanel contentPane;
	private JLabel breakLabel;
	private int numberOfSections;
	private String stream;
	private String name;
	static String table1[][] = {{"SEC 1","SEC 2","SEC 3"},{"SEC 1","SEC 2","SEC 3"},
			{"SEC 1","SEC 2","SEC 3"},{"SEC 1","SEC 2","SEC 3"},
			{"SEC 1","SEC 2","SEC 3"},{"SEC 1","SEC 2","SEC 3"}};
	static String table2[][] = {{"SEC 1","SEC 2","SEC 3"},{"SEC 1","SEC 2","SEC 3"},
			{"SEC 1","SEC 2","SEC 3"},{"SEC 1","SEC 2","SEC 3"},
			{"SEC 1","SEC 2","SEC 3"},{"SEC 1","SEC 2","SEC 3"}};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					timeTableView frame = new timeTableView(0,"SCIENCE","Default",null,null,null,null,null,table1,table2);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public timeTableView(int n,String s, String na,int[] s1,int[] s2,int[] s3,int[] s4,int[] s5,String[][] t1,String[][] t2) {
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.numberOfSections = n;
		this.stream = s;
		this.name = na;
		
		setTitle("Time-Table Generator");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1097, 777);
		contentPane = new JPanel();
		contentPane.setName("table");
		contentPane.setDoubleBuffered(false);
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Time-Table");
		lblNewLabel.setBounds(277, 104, 517, 30);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		contentPane.add(lblNewLabel);
		
		String column1[] = {"8-9","9-10","10-11"};
		String column2[] = {"11:30-12:30","12:30-1:30","1:30-2:30"};
		
		JTable table_1 = new JTable(t1,column1);
		table_1.setShowVerticalLines(false);
		table_1.setShowGrid(false);
		table_1.setShowHorizontalLines(false);
		table_1.setRowSelectionAllowed(false);
		table_1.setAutoCreateRowSorter(true);
		table_1.setRowHeight(60);
		table_1.setRowMargin(3);
		table_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		table_1.setBounds(189, 229, 368, 369);
		contentPane.add(table_1);
		
		JTable table_2 = new JTable(t2,column2);
		table_2.setRowMargin(3);
		table_2.setRowHeight(60);
		table_2.setRowSelectionAllowed(false);
		table_2.setShowGrid(false);
		table_2.setShowVerticalLines(false);
		table_2.setShowHorizontalLines(false);
		table_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		table_2.setBounds(678, 229, 368, 369);
		contentPane.add(table_2);
		
		breakLabel = new JLabel("BREAK");
		breakLabel.setHorizontalAlignment(SwingConstants.CENTER);
		breakLabel.setFont(new Font("Dialog", Font.BOLD, 20));
		breakLabel.setAlignmentY(Component.TOP_ALIGNMENT);
		breakLabel.setBounds(478, 347, 231, 70);
		contentPane.add(breakLabel);
		
		JLabel lblNewLabel_1 = new JLabel("MONDAY");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(35, 243, 73, 30);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("TUESDAY");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(35, 306, 73, 30);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("WEDNESDAY");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_2.setBounds(35, 369, 114, 30);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("THURSDAY");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_3.setBounds(35, 424, 89, 30);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("FRIDAY");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_4.setBounds(35, 485, 73, 30);
		contentPane.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("SATURDAY");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_5.setBounds(35, 544, 99, 30);
		contentPane.add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_2 = new JLabel("8-9");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(183, 201, 55, 30);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("9-10");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_1.setBounds(305, 201, 55, 30);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("10-11");
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_2.setBounds(427, 201, 55, 30);
		contentPane.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("11:20-12:30");
		lblNewLabel_2_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_3.setBounds(650, 201, 99, 30);
		contentPane.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_4 = new JLabel("12:20-1:30");
		lblNewLabel_2_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_4.setBounds(779, 201, 86, 30);
		contentPane.add(lblNewLabel_2_4);
		
		JLabel lblNewLabel_2_5 = new JLabel("1:30-2:30");
		lblNewLabel_2_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_5.setBounds(906, 201, 79, 30);
		contentPane.add(lblNewLabel_2_5);
		
		JButton btnNewButton = new JButton("Go Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComponent comp = (JComponent) e.getSource();
				  Window win = SwingUtilities.getWindowAncestor(comp);
				  win.dispose();
				  Time_Table_screen screen = new Time_Table_screen(numberOfSections,stream,name,s1,s2,s3,s4,s5);
					screen.frmTimetableGenerator.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(947, 682, 99, 30);
		contentPane.add(btnNewButton);
	}
}
