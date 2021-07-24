import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import database.connection;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Window;

import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
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


public class signUp extends JFrame {

	private JPanel contentPane;
	private JTextField userTextField;
	private JPasswordField passTextField;
	private JTextField firstTextField;
	private JTextField lastTextField;
	private JLabel lblNewLabel_1;
	private JLabel school_img;
	private JLabel background;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					signUp frame = new signUp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public boolean insertId(String user, String pass, String first, String last) {
		try {
			Connection con = connection.dbConnect();
			PreparedStatement pst = con.prepareStatement("INSERT INTO login(username,password,firstname,lastname) VALUES( ? , ?, ?, ?)");
			pst.setString(1, user);
			pst.setString(2, pass);
			pst.setString(3, first);
			pst.setString(4, last);
			pst.executeUpdate();
			return true;
		}catch(Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	
	
	/**
	 * Create the frame.
	 */
	public signUp() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(signUp.class.getResource("/Images/saturday _icon.png")));
		setTitle("Saturday: Timetable Planner");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1097, 777);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		userTextField = new JTextField();
		firstTextField = new JTextField();
		lastTextField = new JTextField();
		userTextField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		userTextField.setBounds(1074, 468, 180, 30);
		contentPane.add(userTextField);
		userTextField.setColumns(10);
		
		passTextField = new JPasswordField();
		passTextField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		passTextField.setColumns(10);
		passTextField.setBounds(1074, 565, 180, 30);
		contentPane.add(passTextField);
		
		JButton signupButton = new JButton("SIGN IN");
		signupButton.setBackground(Color.WHITE);
		signupButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = userTextField.getText();
				String password = String.valueOf(passTextField.getPassword());
				String firstName = firstTextField.getText();
				String lastName = lastTextField.getText();
				if(insertId(username,password,firstName,lastName)) {
					JOptionPane.showMessageDialog(null, "SignUp Successfull");
					JComponent comp = (JComponent) e.getSource();
					  Window win = SwingUtilities.getWindowAncestor(comp);
					  win.dispose();
					  login log = new login();
					  log.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, "ID couldn't be created");
				}
			}
		});
		signupButton.setBounds(1050, 660, 143, 30);
		signupButton.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		signupButton.setBackground(Color.white);
		signupButton.setForeground(Color.white);
		signupButton.setOpaque(false);
		signupButton.setContentAreaFilled(false);
		signupButton.setBorderPainted(true);
		signupButton.setBorder(new RoundedBorder(35));
		contentPane.add(signupButton);
		
		firstTextField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		firstTextField.setColumns(10);
		firstTextField.setBounds(1074, 325, 180, 30);
		contentPane.add(firstTextField);
		
		lastTextField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lastTextField.setColumns(10);
		lastTextField.setBounds(1074, 398, 180, 30);
		contentPane.add(lastTextField);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel_1.setBounds(905, 70, 320, 45);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("GO BACK");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComponent comp = (JComponent) e.getSource();
				  Window win = SwingUtilities.getWindowAncestor(comp);
				  win.dispose();
				  login log = new login();
				  log.setVisible(true);
			}
		});
		btnNewButton.setBounds(1050, 700, 143, 30);
		btnNewButton.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		btnNewButton.setBackground(Color.white);
		btnNewButton.setForeground(Color.white);
		btnNewButton.setOpaque(false);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorderPainted(true);
		btnNewButton.setBorder(new RoundedBorder(35));
		contentPane.add(btnNewButton);
		
		school_img = new JLabel("");
		school_img.setIcon(new ImageIcon(signUp.class.getResource("/Images/saturday.gif")));
		school_img.setBounds(0, 62, 727, 740);
		contentPane.add(school_img);
		
		background = new JLabel("New label");
		background.setIcon(new ImageIcon(signUp.class.getResource("/Images/login portal (2).png")));
		background.setBounds(730, 0, 761, 908);
		contentPane.add(background);
	}
}