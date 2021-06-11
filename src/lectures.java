import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Window;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					lectures frame = new lectures(1,"SCIENCE");
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
	public lectures(int n,String s) {
		setResizable(false);
		this.numberOfSections = n;
		this.stream = s;
		
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
		setBounds(100, 100, 1097, 777);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Subjects");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(128, 106, 92, 30);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Section");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(368, 106, 92, 30);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("No. of Lectures");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(656, 106, 181, 30);
		contentPane.add(lblNewLabel_5);
		
		subject_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		subject_1.setBounds(83, 174, 172, 30);
		contentPane.add(subject_1);
		
		subject_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		subject_2.setBounds(83, 231, 172, 30);
		contentPane.add(subject_2);
		
		subject_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		subject_3.setBounds(83, 298, 172, 30);
		contentPane.add(subject_3);
		
		subject_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		subject_4.setBounds(83, 362, 172, 30);
		contentPane.add(subject_4);
		
		subject_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		subject_5.setBounds(83, 420, 172, 30);
		contentPane.add(subject_5);
		
		subject_1comboBox = new JComboBox();
		subject_1comboBox.setBounds(380, 174, 40, 30);
		for(i = 0; i<numberOfSections ; i++) {
			subject_1comboBox.addItem(i+1);
		}
		contentPane.add(subject_1comboBox);
		
		subject_2comboBox = new JComboBox();
		subject_2comboBox.setBounds(380, 238, 40, 30);
		for(i = 0; i<numberOfSections ; i++) {
			subject_2comboBox.addItem(i+1);
		}
		contentPane.add(subject_2comboBox);
		
		subject_3comboBox = new JComboBox();
		subject_3comboBox.setBounds(380, 305, 40, 30);
		for(i = 0; i<numberOfSections ; i++) {
			subject_3comboBox.addItem(i+1);
		}
		contentPane.add(subject_3comboBox);
		
		subject_4comboBox = new JComboBox();
		subject_4comboBox.setBounds(380, 369, 40, 30);
		for(i = 0; i<numberOfSections ; i++) {
			subject_4comboBox.addItem(i+1);
		}
		contentPane.add(subject_4comboBox);
		
		subject_5comboBox = new JComboBox();
		subject_5comboBox.setBounds(380, 427, 40, 30);
		for(i = 0; i<numberOfSections ; i++) {
			subject_5comboBox.addItem(i+1);
		}
		contentPane.add(subject_5comboBox);
		
		slider_subject1 = new JSlider();
		slider_subject1.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				lectures_1.setText(Integer.toString(slider_subject1.getValue()));
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
		slider_subject1.setBounds(637, 174, 200, 30);
		contentPane.add(slider_subject1);
		
		slider_subject2 = new JSlider();
		slider_subject2.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				lectures_2.setText(Integer.toString(slider_subject2.getValue()));
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
		slider_subject2.setBounds(637, 231, 200, 30);
		contentPane.add(slider_subject2);
		
		slider_subject3 = new JSlider();
		slider_subject3.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				lectures_3.setText(Integer.toString(slider_subject3.getValue()));
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
		slider_subject3.setBounds(637, 298, 200, 30);
		contentPane.add(slider_subject3);
		
		slider_subject4 = new JSlider();
		slider_subject4.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				lectures_4.setText(Integer.toString(slider_subject4.getValue()));
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
		slider_subject4.setBounds(637, 362, 200, 30);
		contentPane.add(slider_subject4);
		
		slider_subject5 = new JSlider();
		slider_subject5.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				lectures_5.setText(Integer.toString(slider_subject5.getValue()));
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
		slider_subject5.setBounds(637, 441, 200, 30);
		contentPane.add(slider_subject5);
		
		lectures_1.setHorizontalTextPosition(SwingConstants.LEFT);
		lectures_1.setHorizontalAlignment(SwingConstants.LEFT);
		lectures_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lectures_1.setBounds(970, 174, 32, 30);
		contentPane.add(lectures_1);
		
		lectures_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lectures_2.setBounds(970, 231, 32, 30);
		contentPane.add(lectures_2);
		
		lectures_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lectures_3.setBounds(970, 298, 32, 30);
		contentPane.add(lectures_3);
		
		lectures_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lectures_4.setBounds(970, 352, 32, 30);
		contentPane.add(lectures_4);
		
		lectures_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lectures_5.setBounds(970, 431, 32, 30);
		contentPane.add(lectures_5);
		
		GenerateButton = new JButton("GENERATE");
		GenerateButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GenerateButton.setBounds(443, 568, 181, 30);
		contentPane.add(GenerateButton);
		
		backButton = new JButton("Go Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComponent comp = (JComponent) e.getSource();
				  Window win = SwingUtilities.getWindowAncestor(comp);
				  win.dispose();
			}
		});
		backButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		backButton.setBounds(905, 622, 112, 30);
		contentPane.add(backButton);
	}
}
