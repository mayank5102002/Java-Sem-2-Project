import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sun.jdi.connect.spi.Connection;

import database.connection;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Window;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class login extends JFrame {

	private JPanel contentPane;
	private JTextField userTextField;
	private JPasswordField passTextField;
	private String name;

	/**
	 * Launch the application.s
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public boolean createTable() {
		try {
		java.sql.Connection con = connection.dbConnect();
		PreparedStatement pst = con.prepareStatement("CREATE TABLE IF NOT EXISTS  login(username varchar(255) NOT NULL, password varchar(255) NOT NULL"
				+ ",firstname TEXT NOT NULL,lastname TEXT NOT NULL)");
		pst.executeUpdate();
		return true;}
		catch(Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	public boolean enter(String user, String pass) {
		try{
			java.sql.Connection con = connection.dbConnect();
			PreparedStatement pst = con.prepareStatement("SELECT * FROM login WHERE username=? AND password=?");
			pst.setString(1, user);
			pst.setString(2, pass);
			ResultSet r = pst.executeQuery();
			if(r.next()) {
				name = r.getString("firstname") + " " + r.getString("lastname");
				return true;
			}else {
				return false;
			}
		}catch(Exception e) {
			System.out.println(e);
			return false;
		}
		
	}
	/**
	 * Create the frame.
	 */
	public login() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(login.class.getResource("/Images/saturday _icon.png")));
		setTitle("Saturday: Timetable Planner");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setBounds(100, 100, 1097, 777);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		userTextField = new JTextField();
		userTextField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		userTextField.setBounds(1058, 328, 256, 30);
		contentPane.add(userTextField);
		userTextField.setColumns(10);
		
		passTextField = new JPasswordField();
		passTextField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		passTextField.setColumns(10);
		passTextField.setBounds(1058, 470, 256, 30);
		contentPane.add(passTextField);
		
		JButton loginButton = new JButton("LOGIN");
		loginButton.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		loginButton.setBackground(Color.white);
		loginButton.setForeground(Color.white);
		loginButton.setOpaque(false);
		loginButton.setContentAreaFilled(false);
		loginButton.setBorderPainted(true);
		loginButton.setBorder(new RoundedBorder(35));
		
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user = userTextField.getText();
				String pass = String.valueOf(passTextField.getPassword());
				if(enter(user,pass)) {
					MainWindow main = new MainWindow(name);
					main.frmTimetableGenerator.setVisible(true);
					JComponent comp = (JComponent) e.getSource();
					  Window win = SwingUtilities.getWindowAncestor(comp);
					  win.dispose();
				}else {
					JOptionPane.showMessageDialog(null, "Invalid I'd or Password");
				}
			}
		});
		loginButton.setBounds(1042, 583, 130, 30);
		contentPane.add(loginButton);
		
		JButton signupButton = new JButton("SIGN-IN");
		signupButton.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		signupButton.setBackground(Color.white);
		signupButton.setForeground(Color.white);
		signupButton.setOpaque(false);
		signupButton.setContentAreaFilled(false);
		signupButton.setBorderPainted(true);
		signupButton.setBorder(new RoundedBorder(35));
		signupButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(createTable()) {
					signUp id = new signUp();
					id.setVisible(true);
					JComponent comp = (JComponent) e.getSource();
					  Window win = SwingUtilities.getWindowAncestor(comp);
					  win.dispose();
				}else {
					JOptionPane.showMessageDialog(null, "Can't open SignUp Window");
				}
			}
		});
		signupButton.setBounds(1042, 641, 130, 30);
		contentPane.add(signupButton);
		
		JLabel school_img = new JLabel("\r\n");
		school_img.setIcon(new ImageIcon(login.class.getResource("/Images/saturday.gif")));
		school_img.setBounds(0, 62, 727, 740);
		contentPane.add(school_img);
		
		JLabel background = new JLabel("New label");
		background.setIcon(new ImageIcon(login.class.getResource("/Images/login portal.png")));
		background.setBounds(730, 0, 761, 908);
		contentPane.add(background);
	}
}