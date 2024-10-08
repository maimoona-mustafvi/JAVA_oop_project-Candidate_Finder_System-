
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author PMYLS
 */
public class CompanyOptions extends JFrame{
   private JButton b2;
    private JButton b1;
    
    CompanyOptions(){
        setTitle("Company");
        setSize(400,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(new GridLayout(2,1));
        
        b1 = new JButton("Search Students");
        b2 = new JButton("View All Students");
        
        MyActionListener a = new MyActionListener();
        b1.addActionListener(a);
        b2.addActionListener(a);
        
        add(b1);
        add(b2);
    }
 
    public class MyActionListener implements ActionListener{
    public void actionPerformed(ActionEvent ae){
        if(ae.getActionCommand().equals("Search Students")){
            FindCand fc1 = new FindCand();
        }
        
        if(ae.getActionCommand().equals("View All Students")){
            ArrayList<University> temp = CandidateFinder.readAllCandidateFinders();
            for(int i =0; i< temp.size() ; i++){
            System.out.println(temp.get(i).getUniName());
            ArrayList<Student> stu = temp.get(i).getStudents();
            for(Student s:stu){
                System.out.println(s.toString());
            }
        }
        }

        
    }
   } 
}
