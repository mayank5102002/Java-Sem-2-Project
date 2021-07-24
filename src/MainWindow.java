import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import java.awt.Toolkit;
import java.awt.SystemColor;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.UIManager;

import javax.swing.border.Border;

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

public class MainWindow {

	public JFrame frmTimetableGenerator;
	private JComboBox<String> Number_Sections_ComboBox;
	private int numberOfSections = 0;
	private String stream = "SCIENCE";
	private JButton save_btn;
	private JButton go_back_btn;
	private JComboBox<String> streamComboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow("Default");
					window.frmTimetableGenerator.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow(String name) {
		initialize(name);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String name) {
		frmTimetableGenerator = new JFrame();
		frmTimetableGenerator.setIconImage(Toolkit.getDefaultToolkit().getImage(MainWindow.class.getResource("/Images/saturday _icon.png")));
		frmTimetableGenerator.setResizable(false);
		frmTimetableGenerator.getContentPane().setBackground(SystemColor.window);
		frmTimetableGenerator.getContentPane().setForeground(Color.WHITE);
		frmTimetableGenerator.setTitle("Saturday: Timetable Planner");
		frmTimetableGenerator.setBounds(100, 100, 1514, 882);
		frmTimetableGenerator.setExtendedState(Frame.MAXIMIZED_BOTH);
		frmTimetableGenerator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTimetableGenerator.getContentPane().setLayout(null);
		
		JLabel Select_Stream_lbl = new JLabel("");
		Select_Stream_lbl.setEnabled(false);
		Select_Stream_lbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Select_Stream_lbl.setBounds(280, 334, 144, 30);
		frmTimetableGenerator.getContentPane().add(Select_Stream_lbl);
		
		JLabel Select_Section_lbl = new JLabel("");
		Select_Section_lbl.setEnabled(false);
		Select_Section_lbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Select_Section_lbl.setBounds(280, 465, 125, 30);
		frmTimetableGenerator.getContentPane().add(Select_Section_lbl);
		
		Number_Sections_ComboBox = new JComboBox<String>();
		Number_Sections_ComboBox.setBackground(Color.WHITE);
		Number_Sections_ComboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		Number_Sections_ComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numberOfSections = Integer.parseInt((String) Number_Sections_ComboBox.getSelectedItem());
			}
		});
		Number_Sections_ComboBox.addItem("1");
		Number_Sections_ComboBox.addItem("2");
		Number_Sections_ComboBox.addItem("3");
		Number_Sections_ComboBox.setBounds(772, 454, 40, 30);
		frmTimetableGenerator.getContentPane().add(Number_Sections_ComboBox);
		
		save_btn = new JButton("SAVE");
		save_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(numberOfSections == 0 || stream.equals("")) {
					JOptionPane.showMessageDialog(Select_Section_lbl, "Select a Stream");
				}else {
				lectures frame = new lectures(numberOfSections, stream,name);
				frame.setVisible(true);
				JComponent comp = (JComponent) e.getSource();
				  Window win = SwingUtilities.getWindowAncestor(comp);
				  win.dispose();
				}
			}
		});
	
		save_btn.setBounds(560, 561, 164, 30);
		save_btn.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		save_btn.setBackground(Color.white);
		save_btn.setForeground(Color.white);
		save_btn.setOpaque(false);
		save_btn.setContentAreaFilled(false);
		save_btn.setBorderPainted(true);
		save_btn.setBorder(new RoundedBorder(35));
		
		frmTimetableGenerator.getContentPane().add(save_btn);
		
		go_back_btn = new JButton("GO BACK");
		go_back_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComponent comp = (JComponent) e.getSource();
				  Window win = SwingUtilities.getWindowAncestor(comp);
				  win.dispose();
				  login log = new login();
				  log.setVisible(true);
			}
		});
	
		go_back_btn.setBounds(772, 560, 144, 32);
		go_back_btn.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		go_back_btn.setBackground(Color.white);
		go_back_btn.setForeground(Color.white);
		go_back_btn.setOpaque(false);
		go_back_btn.setContentAreaFilled(false);
		go_back_btn.setBorderPainted(true);
		go_back_btn.setBorder(new RoundedBorder(35));
		frmTimetableGenerator.getContentPane().add(go_back_btn);
		
		streamComboBox = new JComboBox<String>();
		streamComboBox.setBackground(Color.WHITE);
		streamComboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		streamComboBox.addItem("SCIENCE");
		streamComboBox.addItem("COMMERCE");
		streamComboBox.addItem("HUMANITIES");
		streamComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					stream = (String) streamComboBox.getSelectedItem();
			}
		});
		streamComboBox.setBounds(772, 341, 144, 21);
		frmTimetableGenerator.getContentPane().add(streamComboBox);
		
		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon(MainWindow.class.getResource("/Images/Main_Window_bg.png")));
		background.setBounds(-71, -69, 1622, 936);
		frmTimetableGenerator.getContentPane().add(background);
	}
}