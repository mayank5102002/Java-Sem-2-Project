import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.ComponentOrientation;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.JScrollBar;
import javax.swing.JEditorPane;
import javax.swing.JComboBox;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainWindow {

	private JFrame frmTimetableGenerator;
	private JButton scienceButton;
	private JButton commerceButton;
	private JButton humanitiesButton;
	private JComboBox sectionsNumberComboBox;
	private int numberOfSections = 0;
	private String stream = "";
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
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
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTimetableGenerator = new JFrame();
		frmTimetableGenerator.setResizable(false);
		frmTimetableGenerator.getContentPane().setBackground(Color.WHITE);
		frmTimetableGenerator.getContentPane().setForeground(Color.WHITE);
		frmTimetableGenerator.setTitle("Time-Table Generator");
		frmTimetableGenerator.setBounds(100, 100, 1097, 777);
		frmTimetableGenerator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTimetableGenerator.getContentPane().setLayout(null);
		
		scienceButton = new JButton("SCIENCE");
		scienceButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stream = "SCIENCE";
			}
		});
		commerceButton = new JButton("COMMERCE");
		commerceButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stream = "COMMERCE";
			}
		});
		humanitiesButton = new JButton("HUMANITIES");
		humanitiesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stream = "HUMANITIES";
			}
		});
		scienceButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		scienceButton.setBounds(165, 129, 102, 30);
		frmTimetableGenerator.getContentPane().add(scienceButton);
		
		commerceButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		commerceButton.setBounds(469, 129, 134, 30);
		frmTimetableGenerator.getContentPane().add(commerceButton);
		
		humanitiesButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		humanitiesButton.setBounds(807, 129, 134, 30);
		frmTimetableGenerator.getContentPane().add(humanitiesButton);
		
		JLabel lblNewLabel = new JLabel("Choose Course");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(155, 96, 144, 23);
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
				lectures frame = new lectures(numberOfSections, stream);
				frame.setVisible(true);
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(492, 560, 164, 30);
		frmTimetableGenerator.getContentPane().add(btnNewButton);
	}
}
