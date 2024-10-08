
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author PMYLS
 */
public class SearchBachelor extends JFrame{
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

    public SearchBachelor() {
        setTitle("Bachelor Student Form");
        setSize(400, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(7, 2));

        // University Name
        l1 = new JLabel("University Name:");
        t1= new JTextField();
        add(l1);
        add(t1);


        l2= new JLabel("University Location:");
        t2= new JTextField();
        add(l2);
        add(t2);


        l3= new JLabel("Course:");
        t3= new JTextField();
        add(l3);
        add(t3);


        l4= new JLabel("CGPA Min:");
        t4= new JTextField();
        add(l4);
        add(t4);


        l5= new JLabel("CGPA Max:");
        t5= new JTextField();
        add(l5);
        add(t5);


        b1= new JButton("Search");
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
            if (ae.getActionCommand().equals("Search")) {
                String uniName = t1.getText();
                String uniLocation = t2.getText();
                String course = t3.getText();
                double cgpaMin = Double.parseDouble(t4.getText());
                double cgpaMax = Double.parseDouble(t5.getText());
                

                CandidateFinder cf1 = new CandidateFinder();
                ArrayList<Student> candidateFinds = cf1.candidateFinder(uniName, course, cgpaMax, cgpaMin, null);

                for (Student i : candidateFinds) {
                    if (i instanceof BachelorStudent) {
                        BachelorStudent bs3 = (BachelorStudent) i;
                        JOptionPane.showMessageDialog(null, bs3.toString());
                    }
                }

                if (candidateFinds.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "No candidates found");
                }
            }
            if (ae.getActionCommand().equals("Exit")) {
                dispose();
            }
        }
    }
}
