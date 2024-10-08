
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
public class RemoveStudent extends JFrame {
    JButton b1;
    JButton b2;
    JLabel l1;
    JTextField t1;

    RemoveStudent() {
        setTitle("Student Details");
        setSize(400, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(3,2));

        l1 = new JLabel("Student ID:");
        t1 = new JTextField(15);
        add(l1);
        add(t1);

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
                String studentid = t1.getText();

                BachelorStudent student = new BachelorStudent(null, studentid,0.0 , new Course(null, null));
                BachelorStudent.deleteFromFile(studentid);

                System.out.println("After Deleting : \n");
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