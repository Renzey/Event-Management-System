/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_dsa;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Reports extends JFrame implements ActionListener{
    
    private JLabel evtlbl;
    private JButton attrepbtn, fbrepbtn, evtmainbtn, attdsbtn;
    private JComboBox evtcbb;
    private JTextArea report;
    private JScrollPane reportspane;
    
    Reports(){
        setSize(940, 660);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setTitle("Reports");
        
        evtlbl = new JLabel("Event: ");
        evtlbl.setBounds(15, 10, 50, 30);
        add(evtlbl);
        
        evtcbb = new JComboBox<>(new String []{"Event 1", "Event 2", "Event 3"});//Change this after the checking ng GUI
        evtcbb.setBounds(65, 15, 160, 25);
        add(evtcbb);
        
        attrepbtn = new JButton("Attendance Report");
        attrepbtn.setBounds(235, 15, 150, 25);
        attrepbtn.addActionListener(this);
        add(attrepbtn);
        
        fbrepbtn = new JButton("Feedback Report");
        fbrepbtn.setBounds(400, 15, 150, 25);
        fbrepbtn.addActionListener(this);
        add(fbrepbtn);
        
        //report
        report = new JTextArea();
        report.setEditable(false);
        report.setText("No report yet.");
        report.setBounds(10, 65, 900, 520);
        add(report);
        
        reportspane = new JScrollPane(report);
        reportspane.setBounds(10, 65, 900, 520);
        reportspane.setSize(900,520);
        add(reportspane);
        
        //button para maka balik sa eventmngmntsys or attendees
        evtmainbtn = new JButton("Back to Event");
        evtmainbtn.setBounds(620, 10, 130, 30);
        evtmainbtn.addActionListener(this);
        add(evtmainbtn);
        
        attdsbtn = new JButton("Back to Attendees");
        attdsbtn.setBounds(760, 10, 140, 30);
        attdsbtn.addActionListener(this);
        add(attdsbtn);
        
            
        
}

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == evtmainbtn){
            Event_Management_System app = new Event_Management_System();
            app.setVisible(true);
            dispose();
        }else if(e.getSource() == attdsbtn){
            attendees app = new attendees();
            app.setVisible(true);
            dispose();
        }
                
    }
    
}

    
