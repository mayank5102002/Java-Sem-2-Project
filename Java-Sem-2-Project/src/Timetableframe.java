import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.color.*;
import java.awt.GridLayout;
Package Timetableframe


public class Timetableframe {

    public static void main(String[] args) {

        // creating the frame

        JFrame frame = new JFrame();
        frame.setSize(420, 420);
        frame.setTitle("Time Table");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // frame.setResizable(false); #disable comment if you do not want a resizable
        // window
        frame.getContentPane().setBackground(Color.GRAY); // changing bckgrnd
        frame.setLayout(new GridLayout(8, 7, 10, 10)); // creating grid of 8 rows and 7 columns

        // Adding labels to main frame
        frame.add(new JLabel("Days"));
        frame.add(new JLabel("Monday"));
        frame.add(new JLabel("Tuesday"));
        frame.add(new JLabel("Wednesday"));
        frame.add(new JLabel("Thursday"));
        frame.add(new JLabel("Friday"));
        frame.add(new JLabel("Saturday"));
        frame.add(new JLabel("Sunday"));

        

        frame.setVisible(true);
    }

}