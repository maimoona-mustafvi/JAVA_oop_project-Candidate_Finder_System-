
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
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

public class SearchMasters extends JFrame{
   JButton b1;
   JButton b2;
   JLabel l1;
   JLabel l2;
   JTextField t1;
   JTextField t2;


    public SearchMasters() {
        setTitle("Masters Student Form");
        setSize(400, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(7, 2));

        l1= new JLabel("SuperVisor Name:");
        t1= new JTextField();
        add(l1);
        add(t1);
        
        l2= new JLabel("University Name:");
        t2= new JTextField();
        add(l2);
        add(t2);

        b1= new JButton("Search");
        b2= new JButton("Exit");
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
                String supervisorName = t1.getText();
                String uniName = t2.getText();
                CandidateFinder cf1 = new CandidateFinder();
                ArrayList<Student> candidateFinds = cf1.candidateFinder(uniName, "null", 0.0, 0.0, supervisorName);

                for (Student i : candidateFinds) {
                    if (i instanceof MastersStudent) {
                        MastersStudent ms3 = (MastersStudent) i;
                        JOptionPane.showMessageDialog(null, ms3.toString());
                    }
                }

                if (candidateFinds.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "No candidates found");
                }
            }
            
            else if(ae.getActionCommand().equals("Exit")){
                dispose();
            }
        }
    }
}
