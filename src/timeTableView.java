import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import java.awt.Window;
import javax.swing.JTable;
import java.awt.Component;
import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Rectangle;
import java.awt.Dimension;

import javax.swing.border.Border;
import java.awt.Toolkit;

public class timeTableView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
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
	private static class RoundedBorder implements Border {

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
	
	public timeTableView(int n,String s, String na,int[] s1,int[] s2,int[] s3,int[] s4,int[] s5,String[][] t1,String[][] t2) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(timeTableView.class.getResource("/Images/saturday _icon.png")));
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.numberOfSections = n;
		this.stream = s;
		this.name = na;
		
		setTitle("Saturday: Timetable Planner");
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
		
		String column1[] = {"8-9","9-10","10-11"};
		String column2[] = {"11:30-12:30","12:30-1:30","1:30-2:30"};
		
		JTable table_1 = new JTable(t1,column1);
		table_1.setIntercellSpacing(new Dimension(50, 50));
		table_1.setShowVerticalLines(false);
		table_1.setShowHorizontalLines(false);
		table_1.setShowGrid(false);
		table_1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table_1.setRowSelectionAllowed(false);
		table_1.setAutoCreateRowSorter(true);
		table_1.setRowHeight(60);
		table_1.setRowMargin(3);
		table_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		table_1.setBounds(350, 229, 368, 369);
		table_1.setBackground(Color.gray);
		table_1.setForeground(Color.white);
		contentPane.add(table_1);
		
		JTable table_2 = new JTable(t2,column2);
		table_2.setIntercellSpacing(new Dimension(50, 50));
		table_2.setRowMargin(3);
		table_2.setRowHeight(60);
		table_2.setRowSelectionAllowed(false);
		table_2.setShowGrid(false);
		table_2.setShowVerticalLines(false);
		table_2.setShowHorizontalLines(false);
		table_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		table_2.setBounds(900, 229, 368, 369);
		table_2.setBackground(Color.GRAY);
		table_2.setForeground(Color.WHITE);
		contentPane.add(table_2);
					
		JLabel lblNewLabel_2 = new JLabel("8-9");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(370, 201, 55, 30);
		lblNewLabel_2.setForeground(Color.white);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("9-10");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_1.setBounds(495, 201, 55, 30);
		lblNewLabel_2_1.setForeground(Color.white);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("10-11");
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_2.setBounds(610, 201, 55, 30);
		lblNewLabel_2_2.setForeground(Color.white);
		contentPane.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("11:20-12:30");
		lblNewLabel_2_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_3.setBounds(910, 201, 99, 30);
		lblNewLabel_2_3.setForeground(Color.white);
		contentPane.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_4 = new JLabel("12:20-1:30");
		lblNewLabel_2_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_4.setBounds(1038, 201, 86, 30);
		lblNewLabel_2_4.setForeground(Color.white);
		contentPane.add(lblNewLabel_2_4);
		
		JLabel lblNewLabel_2_5 = new JLabel("1:30-2:30");
		lblNewLabel_2_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_5.setBounds(1150, 201, 79, 30);
		lblNewLabel_2_5.setForeground(Color.white);
		contentPane.add(lblNewLabel_2_5);
		
		JButton btnNewButton = new JButton("GO BACK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComponent comp = (JComponent) e.getSource();
				  Window win = SwingUtilities.getWindowAncestor(comp);
				  win.dispose();
				  Time_Table_Screen screen = new Time_Table_Screen(numberOfSections,stream,name,s1,s2,s3,s4,s5);
					screen.frmTimetableGenerator.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		btnNewButton.setBounds(740, 630, 150, 30);
		btnNewButton.setBackground(Color.white);
		btnNewButton.setForeground(Color.white);
		btnNewButton.setOpaque(false);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorderPainted(true);
		btnNewButton.setBorder(new RoundedBorder(35));
		contentPane.add(btnNewButton);
		
		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon(timeTableView.class.getResource("/Images/Copy of Enjoy fantastic deals and big discounts (8) (1).png")));
		background.setBounds(-71, -69, 1622, 936);
		contentPane.add(background);
	}
}