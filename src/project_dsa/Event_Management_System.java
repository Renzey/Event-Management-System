/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_dsa;

import com.mysql.jdbc.Connection;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class Event_Management_System extends JFrame implements ActionListener{
    
    private JLabel searchlbl, addeventlbl, namelbl, datelbl, categorylbl, capacitylbl;
    private JTextField search, addname, adddate, addcategory, addcapacity;
    private JButton searchbtn, showallbtn, attendeesbtn, reportbtn, addeventbtn, updatebtn, deletebtn, clearbtn;
    private JComboBox categorysearch;
    private JTable table;
    private JPanel panel;
    private JScrollPane sp;
    
    Event_Management_System(){
        setSize(940, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Event Management System");
        setLayout(null);
        
           
        searchlbl = new JLabel("Search By: ");
        searchlbl.setBounds(10, 20, 65, 30);
        add(searchlbl);
        
        categorysearch = new JComboBox<>(new String[]{"Date DD-MM-YY", "Category"});
        categorysearch.setBounds(90, 23, 120, 25);
        add(categorysearch);
        
        search = new JTextField();
        search.setBounds(230, 23, 200, 25);
        add(search);
        
        searchbtn = new JButton("Search");
        searchbtn.setBounds(450, 20, 80, 30);
        searchbtn.addActionListener(this);
        add(searchbtn);
        
        showallbtn = new JButton("Show All");
        showallbtn.setBounds(550, 20, 100, 30);
        showallbtn.addActionListener(this);
        add(showallbtn);

        //table
        
        attendeesbtn = new JButton("Attendees");
        attendeesbtn.setBounds(700, 20, 100, 30);
        attendeesbtn.addActionListener(this);
        add(attendeesbtn);
        
        ///tables?

        String[][] sampledata = {
            {"1", "SportFest", "Sport", "10", "5", "5"},
            {"2", "Lecture", "Seminar", "50", "10", "40"}
        };
        String[] data = {"ID", "Name", "Category", "Attendees", "Waiting", "Guest(s)"};
        
        table = new JTable(sampledata, data);
        table.setBounds(10, 65, 900, 400);
        table.setBorder(BorderFactory.createLineBorder(Color.black));
        add(table);
        
        sp = new JScrollPane(table);
        sp.setBounds(10, 65, 900, 400);
        sp.setSize(900, 400);
        add(sp);
        
        //add event
        
        addeventlbl = new JLabel("Add Event");
        addeventlbl.setBounds(50, 475, 100, 50);
        add(addeventlbl); 
        
        namelbl = new JLabel("Name:");
        namelbl.setBounds(50, 500, 100, 50);
        add(namelbl);
        
        datelbl = new JLabel("Date(DD-MM-YY):");
        datelbl.setBounds(320, 500, 100, 50);
        add(datelbl);
        
        categorylbl = new JLabel("Category :");
        categorylbl.setBounds(530, 500, 100, 50);
        add(categorylbl);
        
        capacitylbl = new JLabel("Capacity :");
        capacitylbl.setBounds(750, 500, 100, 50);
        add(capacitylbl);
        
        addname = new JTextField();
        addname.setBounds(50, 545, 250, 25);
        add(addname);
        
        adddate = new JTextField();
        adddate.setBounds(320, 545, 190, 25);
        add(adddate);
        
        addcategory = new JTextField();
        addcategory.setBounds(530, 545, 200, 25);
        add(addcategory);
        
        addcapacity = new JTextField();
        addcapacity.setBounds(750, 545, 120, 25);
        add(addcapacity);
        
        addeventbtn = new JButton("Add");
        addeventbtn.setBounds(50, 585, 100, 30);
        addeventbtn.addActionListener(this);
        add(addeventbtn);
        
        updatebtn = new JButton("Update Selected");
        updatebtn.setBounds(170, 585, 130, 30);
        updatebtn.addActionListener(this);
        add(updatebtn);
        
        deletebtn = new JButton("Delete Selected");
        deletebtn.setBounds(320, 585, 130, 30);
        deletebtn.addActionListener(this);
        add(deletebtn);
        
        clearbtn = new JButton("Clear Form");
        clearbtn.setBounds(470, 585, 130, 30);
        clearbtn.addActionListener(this);
        add(clearbtn);
        
        panel = new JPanel();
        panel.setBounds(25, 485, 870, 140);
        panel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        add(panel);
        
        
        //database??
        
        /** try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/event_management/evt", "root", "");
        }catch(){
        
        } **/
        
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getSource() == attendeesbtn){
            attendees app = new attendees();
            app.setVisible(true);
            dispose();
        }
    }
    
    
}
