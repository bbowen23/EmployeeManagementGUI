/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import employeemgmt.*;

/**
 * Register a new employee with GUI
 * @author Benjamin Bowen
 * 
 * This file took about 20 minutes to write and debug.
 * TOTAL TIME: 0H 20M
 */
public class Register extends JFrame implements ActionListener, TextListener {
    
    // fields
    JFrame f = new JFrame("Register");
    CRUD crud = new CRUD();
    
    TextField tfMid1 = new TextField(5);
    TextField tfMid2 = new TextField(15);
    TextField tfMid3 = new TextField(10);
    Button btnMid = new Button("Confirm");
    
    TextArea taBot = new TextArea(2, 40);
    Button btnBot = new Button("Go back");
    
    private String result;
    
    // constructor
    public Register() {
        
        // CONTAINER
        f.setBounds(100, 100, 800, 500);
        
        // LAYOUT
        GridLayout gl = new GridLayout(3, 1);
        f.setLayout(gl);
        
        // COMPONENTS
        Font font1 = new Font("Times New Roman", Font.BOLD, 24); // Times New Roman, bold, size 24
        Font font2 = new Font("Times New Roman", Font.BOLD, 12);
        
        // Top
        Label labTop = new Label("REGISTER EMPLOYEE", Label.CENTER);
        labTop.setFont(font1);
        labTop.setForeground(Color.BLUE);
        f.add(labTop);
        
        // Middle
        Label labMid1 = new Label("ID: ");
        labMid1.setFont(font2);
        tfMid1.addTextListener(this);
        
        Label labMid2 = new Label("Name: ");
        labMid2.setFont(font2);
        tfMid2.addTextListener(this);
        
        Label labMid3 = new Label("DOB: ");
        labMid3.setFont(font2);
        tfMid3.addTextListener(this);
        
        btnMid.addActionListener(this);
        
        Panel panMid = new Panel();
        panMid.add(labMid1); panMid.add(tfMid1); panMid.add(labMid2); panMid.add(tfMid2); panMid.add(labMid3); panMid.add(tfMid3); panMid.add(btnMid);
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
            
            String idString = tfMid1.getText();
            String nameString = tfMid2.getText();
            String dobString = tfMid3.getText();
            
            try {
                
                int idInt = Integer.parseInt(idString.trim());
                
                if (crud.count() < 10) {
                
                    crud.register(new Employee(idInt, nameString, dobString));
                    taBot.append(idString + " " + nameString + " " + dobString + " successfully registered \n");
                    
                } else {
                    
                    taBot.append("The maximum number of employees (10) has been registered. Registration failed. \n");
                    
                }
                
            } catch (NumberFormatException nfe) {
                
                taBot.append("ID must be an integer. Registration failed. \n");
                
            }
            
        } else if (ae.getSource() == btnBot) {
            
            new Menu();
            f.setVisible(false);
            
        }
        
    }
    
    public void textValueChanged(TextEvent te) {
        
        
        
    }
    
}
