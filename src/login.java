import java.awt.BorderLayout;
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
		setTitle("Time-Table Generator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setBounds(100, 100, 1097, 777);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(297, 191, 114, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPassword.setBounds(297, 312, 114, 30);
		contentPane.add(lblPassword);
		
		userTextField = new JTextField();
		userTextField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		userTextField.setBounds(610, 199, 256, 30);
		contentPane.add(userTextField);
		userTextField.setColumns(10);
		
		passTextField = new JPasswordField();
		passTextField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		passTextField.setColumns(10);
		passTextField.setBounds(610, 312, 256, 30);
		contentPane.add(passTextField);
		
		JButton loginButton = new JButton("LOGIN");
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
		loginButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		loginButton.setBounds(373, 490, 114, 30);
		contentPane.add(loginButton);
		
		JButton signupButton = new JButton("SignUp");
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
		signupButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		signupButton.setBounds(613, 490, 114, 30);
		contentPane.add(signupButton);
		
		JLabel lblNewLabel_1 = new JLabel("LOGIN");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel_1.setBounds(427, 82, 320, 45);
		contentPane.add(lblNewLabel_1);
	}
}
