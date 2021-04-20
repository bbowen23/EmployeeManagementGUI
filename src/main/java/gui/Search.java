/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;
import employeemgmt.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * Search an employee by ID with GUI
 * @author Benjamin Bowen
 */
public class Search extends JFrame implements ActionListener, TextListener {
    
    // fields
    JFrame f = new JFrame("Search");
    CRUD crud = new CRUD();
    
    TextField tfMid = new TextField(5);
    Button btnMid = new Button("Search ID");
    
    TextArea taBot = new TextArea(2, 40);
    Button btnBot = new Button("Go back");
    
    // constructor
    public Search() {
        
        // CONTAINER
        f.setBounds(100, 100, 800, 500);
        
        // LAYOUT
        GridLayout gl = new GridLayout(3, 1);
        f.setLayout(gl);
        
        // COMPONENTS
        Font font1 = new Font("Times New Roman", Font.BOLD, 24);
        Font font2 = new Font("Times New Roman", Font.BOLD, 12);
        
        // Top
        Label labTop = new Label("SEARCH FOR EMPLOYEE", Label.CENTER);
        labTop.setFont(font1);
        labTop.setForeground(Color.BLUE);
        f.add(labTop);
        
        // Middle
        Label labMid = new Label("ID: ");
        labMid.setFont(font2);
        tfMid.addTextListener(this);
        
        btnMid.addActionListener(this);
        
        Panel panMid = new Panel();
        panMid.add(labMid); panMid.add(tfMid); panMid.add(btnMid);
        f.add(panMid);
        
        // Bottom
        Label labBot = new Label("Output: ", Label.CENTER);
        taBot.addTextListener(this);
        btnBot.addActionListener(this);
        
        Panel panBot = new Panel();
        panBot.add(labBot); panBot.add(taBot); panBot.add(btnBot);
        f.add(panBot);
        
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        
    }
    
    // methods
    public void actionPerformed(ActionEvent ae) {
        
        if (ae.getSource() == btnMid) {
            
            // Check if the ID is an integer.
            String idString = tfMid.getText();
            
            try {
                
                int idInt = Integer.parseInt(idString.trim());
                
                // If the employee is found, put it here. If not, say that it was not found.
                try {
                    
                    Employee result = crud.search(idInt);
                    taBot.append(idString + " " + result.getName() + " " + result.getDob() + "\n");
                    
                } catch (NullPointerException npe) {
                    
                    taBot.append("Employee not found.\n");
                    
                }
                
            } catch (NumberFormatException nfe) {
                
                taBot.append("ID must be an integer. Search failed.\n");
                
            }
            
        } else if (ae.getSource() == btnBot) {
            
            new Menu();
            f.setVisible(false);
            
        }
        
    }
    
    public void textValueChanged(TextEvent te) {
        
        
        
    }
    
}
