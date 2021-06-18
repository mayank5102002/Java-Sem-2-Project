import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import database.connection;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
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

public class signUp extends JFrame {

	private JPanel contentPane;
	private JTextField userTextField;
	private JPasswordField passTextField;
	private JLabel lblFirstName;
	private JLabel lblLastName;
	private JTextField firstTextField;
	private JTextField lastTextField;
	private JLabel lblNewLabel_1;

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
		userTextField.setBounds(707, 387, 180, 30);
		contentPane.add(userTextField);
		userTextField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(320, 386, 121, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPassword.setBounds(320, 479, 121, 30);
		contentPane.add(lblPassword);
		
		passTextField = new JPasswordField();
		passTextField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		passTextField.setColumns(10);
		passTextField.setBounds(707, 480, 180, 30);
		contentPane.add(passTextField);
		
		JButton signupButton = new JButton("SignUp");
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
		signupButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		signupButton.setBounds(515, 609, 143, 30);
		contentPane.add(signupButton);
		
		lblFirstName = new JLabel("First Name");
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblFirstName.setBounds(320, 170, 121, 30);
		contentPane.add(lblFirstName);
		
		lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLastName.setBounds(320, 266, 121, 30);
		contentPane.add(lblLastName);
		
		firstTextField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		firstTextField.setColumns(10);
		firstTextField.setBounds(707, 170, 180, 30);
		contentPane.add(firstTextField);
		
		lastTextField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lastTextField.setColumns(10);
		lastTextField.setBounds(707, 266, 180, 30);
		contentPane.add(lastTextField);
		
		lblNewLabel_1 = new JLabel("SIGN UP");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel_1.setBounds(437, 60, 320, 45);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Go Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComponent comp = (JComponent) e.getSource();
				  Window win = SwingUtilities.getWindowAncestor(comp);
				  win.dispose();
				  login log = new login();
				  log.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(876, 641, 121, 30);
		contentPane.add(btnNewButton);
	}
}
