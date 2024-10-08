
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author PMYLS
 */
public class AddStudent extends JFrame {
    JButton b1;
    JButton b2;
    JLabel l1;
    JLabel l2;
    JLabel l3;
    JLabel l4;
    JLabel l5;
    JTextField t1;
    JTextField t2;
    JTextField t3;
    JTextField t4;
    JTextField t5;

    public AddStudent() {
        setTitle("Student Details");
        setSize(400, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(7,2));

        l1 = new JLabel("Student Name:");
        t1 = new JTextField(15);
        add(l1);
        add(t1);

        l2 = new JLabel("Student ID:");
        t2 = new JTextField(15);
        add(l2);
        add(t2);

        l3 = new JLabel("Student CGPA:");
        t3 = new JTextField(15);
        add(l3);
        add(t3);

        l4 = new JLabel("Course Name:");
        t4 = new JTextField(15);
        add(l4);
        add(t4);

        l5 = new JLabel("Course Acronym:");
        t5 = new JTextField(15);
        add(l5);
        add(t5);

        b1 = new JButton("Enter");
        b2 = new JButton("Exit");
        MyActionListener a = new MyActionListener();
        b1.addActionListener(a);
        b2.addActionListener(a);
        add(b1);
        add(b2);

        setVisible(true);
    }

    private class MyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            if (ae.getActionCommand().equals("Enter")) {
                String studentName = t1.getText();
                String studentid = t2.getText();
                double cgpa = Double.parseDouble(t3.getText());
                String courseName = t4.getText();
                String courseAcronym = t5.getText();

                BachelorStudent student = new BachelorStudent(studentName, studentid, cgpa, new Course(courseName, courseAcronym));
                BachelorStudent.writeToFile(student);

                System.out.println("After entering new Student : \n");
                ArrayList<BachelorStudent> bach_students = BachelorStudent.readAllBachelorStudents();
                for (BachelorStudent bc : bach_students) {
                    System.out.println(bc.toString());
                }
            }

            if (ae.getActionCommand().equals("Exit")) {
                dispose();
            }
        }
    }
}