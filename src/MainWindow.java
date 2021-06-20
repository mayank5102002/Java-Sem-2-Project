import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.ComponentOrientation;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.JScrollBar;
import javax.swing.JEditorPane;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainWindow {

	public JFrame frmTimetableGenerator;
	private JComboBox sectionsNumberComboBox;
	private int numberOfSections = 0;
	private String stream = "SCIENCE";
	private JButton btnNewButton;
	private JLabel nameLabel;
	private JButton btnNewButton_1;
	private JComboBox streamComboBox;

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
		frmTimetableGenerator.setResizable(false);
		frmTimetableGenerator.getContentPane().setBackground(Color.WHITE);
		frmTimetableGenerator.getContentPane().setForeground(Color.WHITE);
		frmTimetableGenerator.setTitle("Time-Table Generator");
		frmTimetableGenerator.setBounds(100, 100, 1514, 882);
		frmTimetableGenerator.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frmTimetableGenerator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTimetableGenerator.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Choose Course");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(155, 135, 144, 30);
		frmTimetableGenerator.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("TIME-TABLE GENERATOR");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(322, 23, 362, 43);
		frmTimetableGenerator.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("No. of Sections");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(155, 226, 125, 30);
		frmTimetableGenerator.getContentPane().add(lblNewLabel_2);
		
		sectionsNumberComboBox = new JComboBox();
		sectionsNumberComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numberOfSections = Integer.parseInt((String) sectionsNumberComboBox.getSelectedItem());
			}
		});
		sectionsNumberComboBox.addItem("1");
		sectionsNumberComboBox.addItem("2");
		sectionsNumberComboBox.addItem("3");
		sectionsNumberComboBox.setBounds(335, 228, 40, 30);
		frmTimetableGenerator.getContentPane().add(sectionsNumberComboBox);
		
		btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(numberOfSections == 0 || stream.equals("")) {
					JOptionPane.showMessageDialog(lblNewLabel_2, "Select a Stream");
				}else {
				lectures frame = new lectures(numberOfSections, stream,name);
				frame.setVisible(true);
				JComponent comp = (JComponent) e.getSource();
				  Window win = SwingUtilities.getWindowAncestor(comp);
				  win.dispose();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(492, 560, 164, 30);
		frmTimetableGenerator.getContentPane().add(btnNewButton);
		
		nameLabel = new JLabel("Welcome " + name);
		nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		nameLabel.setBounds(769, 42, 314, 30);
		frmTimetableGenerator.getContentPane().add(nameLabel);
		
		btnNewButton_1 = new JButton("Go Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComponent comp = (JComponent) e.getSource();
				  Window win = SwingUtilities.getWindowAncestor(comp);
				  win.dispose();
				  login log = new login();
				  log.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.setBounds(882, 613, 112, 30);
		frmTimetableGenerator.getContentPane().add(btnNewButton_1);
		
		streamComboBox = new JComboBox();
		streamComboBox.addItem("SCIENCE");
		streamComboBox.addItem("COMMERCE");
		streamComboBox.addItem("HUMANITIES");
		streamComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					stream = (String) streamComboBox.getSelectedItem();
			}
		});
		streamComboBox.setBounds(335, 142, 144, 21);
		frmTimetableGenerator.getContentPane().add(streamComboBox);
	}
}
