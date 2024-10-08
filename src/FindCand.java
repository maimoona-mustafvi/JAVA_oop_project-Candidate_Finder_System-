/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author PMYLS
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FindCand extends JFrame{
    private JButton b2;
    private JButton b1;
    
    FindCand(){
        setTitle("Candidate Finder");
        setSize(400,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(new GridLayout(2,1));
        
        b1 = new JButton("Bachelor Student");
        b2 = new JButton("Master Student");
        
        MyActionListener a = new MyActionListener();
        b1.addActionListener(a);
        b2.addActionListener(a);
        
        add(b1);
        add(b2);
    }
 
    public class MyActionListener implements ActionListener{
    public void actionPerformed(ActionEvent ae){
        if(ae.getActionCommand().equals("Bachelor Student")){
            SearchBachelor sb1 = new SearchBachelor();
        }
        
        if(ae.getActionCommand().equals("Master Student")){
            SearchMasters sm = new SearchMasters();
        }
        
    }
   }
 }
 
    
