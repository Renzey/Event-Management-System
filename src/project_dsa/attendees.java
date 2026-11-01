/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_dsa;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class attendees extends JFrame implements ActionListener{

    private JLabel  evt, regAttlbl, attdlbl, namelbl, emaillbl, priolbl, evtlbl, regislbl;
    private JTextField nametf, emailtf;
    private JComboBox priocbb, eventcbb;
    private JButton regbtn, checkinbtn, addfbbtn, cancelregbtn;
    private JPanel attdpnl;
    private JTable registeredtbl, waitingtbl;
    private JComboBox evtcbb;
    private JScrollPane regscpane;
    //add table
    
    attendees(){
        setSize(940, 660);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setTitle("Attendance Details");
        
        evt = new JLabel("Event: ");
        evt.setBounds(15, 15, 45, 30);
        add(evt);
        
        evtcbb = new JComboBox<>(new String []{"Event 1", "Event 2", "Event 3 "}); //connect this to the database to change wahat event after checking of GUI
        evtcbb.setBounds(60, 15, 150, 30);
        add(evtcbb);
        
        regAttlbl = new JLabel("Registered Attendees");
        regAttlbl.setBounds(20, 50, 150, 30);
        add(regAttlbl);
        
        //registed table
        String [] data = {"ID", "Name", "Email", "Priority", "Checked In", "Rating"};
        
        String [][] SampleData = {
            {"1", "admin1", "admin123@gmail.com", "VIp", "Yes", "5/5"},{"2", "admin2", "admin5678@gmai.com", "Member", "Yes", "3/5"}
        };
        
        registeredtbl = new JTable(SampleData, data);
        registeredtbl.setBounds(10, 75, 900, 180);
        add(registeredtbl);
        
        regscpane = new JScrollPane(registeredtbl);
        regscpane.setBounds(10, 75, 900, 180);
        regscpane.setSize(900, 180);
        add(regscpane);
        
        
        
        attdlbl = new JLabel("Attendace Details: ");
        attdlbl.setBounds(25, 465, 130, 30);
        add(attdlbl);
        
        namelbl = new JLabel("Name");
        namelbl.setBounds(35, 490, 80, 30);
        add(namelbl);
        
        nametf = new JTextField();
        nametf.setBounds(35, 520, 350, 30);
        add(nametf);
        
        emaillbl = new JLabel("Email");
        emaillbl.setBounds(405, 490, 80, 30);
        add(emaillbl);
        
        emailtf = new JTextField();
        emailtf.setBounds(405, 520, 300, 30);
        add(emailtf);
        
        priolbl = new JLabel("Priority");
        priolbl.setBounds(725, 490, 80, 30);
        add(priolbl);
        
        priocbb = new JComboBox<>(new String [] {"VIP","Member","Regular"});
        priocbb.setBounds(725, 520, 150, 30);
        add(priocbb);
        
        regbtn = new JButton("Register");
        regbtn.setBounds(35, 555, 80, 30);
        regbtn.addActionListener(this);
        add(regbtn);
        
        checkinbtn = new JButton("Check in Selected ");
        checkinbtn.setBounds(135, 555, 140, 30);
        checkinbtn.addActionListener(this);
        add(checkinbtn);
        
        addfbbtn = new JButton("Add Feedback");
        addfbbtn.setBounds(295, 555, 130, 30);
        addfbbtn.addActionListener(this);
        add(addfbbtn);
        
        cancelregbtn = new JButton("Cancel Register");
        cancelregbtn.setBounds(445, 555, 130, 30);
        cancelregbtn.addActionListener(this);
        add(cancelregbtn);
        
        attdpnl = new JPanel();
        attdpnl.setBounds(15, 465, 890, 130);
        attdpnl.setBorder(BorderFactory.createLineBorder(Color.gray));
        add(attdpnl);
        
       
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
