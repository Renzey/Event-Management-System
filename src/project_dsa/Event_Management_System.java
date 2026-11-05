/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_dsa;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    private DefaultTableModel model;
    
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    
    private void Connect(){
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/event_management","root","");
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    Event_Management_System(){
        Connect();
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
        searchbtn.setBounds(435, 25, 80, 20);
        searchbtn.addActionListener(this);
        add(searchbtn);
        
        showallbtn = new JButton("Show All");
        showallbtn.setBounds(520, 25, 100, 20);
        showallbtn.addActionListener(this);
        add(showallbtn);

        //go to attendees or reports page/file or what 
        
        attendeesbtn = new JButton("Go to Attendees");
        attendeesbtn.setBounds(630, 20, 130, 30);
        attendeesbtn.addActionListener(this);
        add(attendeesbtn);
        
        reportbtn = new JButton("Go to Reports");
        reportbtn.setBounds(770, 20, 140, 30);
        reportbtn.addActionListener(this);
        add(reportbtn);
        
        ///tables?

        model = new DefaultTableModel(new String[]{"ID", "Name", "Date", /**"Category",**/ "Attendees" /**, "Waiting","Guest(s)"**/}, 0);
        
        table = new JTable(model);
        table.setBorder(BorderFactory.createLineBorder(Color.black));
        
        sp = new JScrollPane(table);
        sp.setBounds(10, 65, 900, 400);
        sp.setSize(900, 400);
        add(sp);
        
        /**table.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()){
                
            }
        });**/
        
        loadEvents();
        
        
        
        
        //add event
        
        addeventlbl = new JLabel("Add Event");
        addeventlbl.setBounds(35, 475, 100, 50);
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
        
        
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == attendeesbtn){
            attendees app = new attendees();
            app.setVisible(true);
            dispose();
        }else if (e.getSource() == reportbtn){
            Reports app = new Reports();
            app.setVisible(true);
            dispose();
        }else if (e.getSource() == showallbtn){
            loadEvents();
        }else if(e.getSource() == addeventbtn){
            
        }else if(e.getSource() == updatebtn){
            
        }else if(e.getSource() == deletebtn){
            
        }else if(e.getSource() == clearbtn){
            addname.setText("");
            adddate.setText("");
            addcategory.setText("");
            addcapacity.setText("");
            table.clearSelection();
        }
    }
    private void loadEvents(){
            model.setRowCount(0);
            
            String sql = "SELECT eventid, name, date, category, attendees FROM evt";/**, waiting, capacity FROM evt";**/ 
            try{
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                
                while(rs.next()){
                    model.addRow(new Object[]{
                    rs.getInt("eventid"),
                    rs.getString("name"),
                    rs.getString("date"),
                    rs.getString("category"),
                    rs.getInt("attendees"),
                //    rs.getInt("waiting"),
                //    rs.getInt("capacity")
                    });
                }
            } catch (SQLException ex) {
            Logger.getLogger(Event_Management_System.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    
}
