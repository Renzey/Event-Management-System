/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_dsa;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class attendees extends JFrame implements ActionListener{

    private JLabel attdlbl, namelbl, emaillbl, priolbl, evtlbl, regislbl;
    private JTextField nametf, emailtf;
    private JComboBox priocbb, eventcbb;
    private JButton addbtn, updatebtn, removebtn, clearbtn;
    //add table
    
    attendees(){
        setSize(940, 660);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setTitle("Attendance Details");
        
        
        
        attdlbl = new JLabel("Attendace Details: ");
        attdlbl.setBounds(25, 15, 130, 30);
        add(attdlbl);
        
        namelbl = new JLabel("Name");
        namelbl.setBounds(35, 40, 80, 30);
        add(namelbl);
        
        nametf = new JTextField();
        nametf.setBounds(35, 65, 350, 30);
        add(nametf);
        
        emaillbl = new JLabel("Email");
        emaillbl.setBounds(405, 40, 80, 30);
        add(emaillbl);
        
        emailtf = new JTextField();
        emailtf.setBounds(405, 65, 300, 30);
        add(emailtf);
        
        priolbl = new JLabel("Priority");
        priolbl.setBounds(725, 40, 80, 30);
        add(priolbl);
        
        priocbb = new JComboBox<>(new String [] {"VIP","Member","Regular"});
        priocbb.setBounds(725, 65, 150, 30);
        add(priocbb);
        
        addbtn = new JButton("Add");
        addbtn.setBounds(35, 100, 80, 30);
        addbtn.addActionListener(this);
        add(addbtn);
        
        updatebtn = new JButton("Update List");
        updatebtn.setBounds(135, 100, 100, 30);
        updatebtn.addActionListener(this);
        add(updatebtn);
        
        removebtn = new JButton("Remove List");
        removebtn.setBounds(255, 100, 130, 30);
        removebtn.addActionListener(this);
        add(removebtn);
        
        clearbtn = new JButton("Clear List");
        clearbtn.setBounds(405, 100, 130, 30);
        clearbtn.addActionListener(this);
        add(clearbtn);
        
       
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
