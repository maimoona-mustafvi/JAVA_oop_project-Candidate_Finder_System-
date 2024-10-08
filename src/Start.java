
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class Start extends JFrame{
    private JButton b2;
    private JButton b1;
    
    Start(){
        setTitle("Home");
        setSize(400,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(new GridLayout(2,1));
        
        b1 = new JButton("University");
        b2 = new JButton("Company");
        
        MyActionListener a = new MyActionListener();
        b1.addActionListener(a);
        b2.addActionListener(a);
        
        add(b1);
        add(b2);
    }
 
    public class MyActionListener implements ActionListener{
    public void actionPerformed(ActionEvent ae){
        if(ae.getActionCommand().equals("University")){
            UniOptions uo = new UniOptions();
        }
        
        if(ae.getActionCommand().equals("Company")){
            CompanyOptions co = new CompanyOptions();
        }

        
    }
   }
}

