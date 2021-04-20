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
 * Print the entire list of employees to GUI.
 * @author Benjamin Bowen
 * 
 * This file took about 10 minutes to write and about 5 minutes to debug.
 * TOTAL TIME: 0H 15M
 */
public class PrintAll extends JFrame implements ActionListener, TextListener {
    
    // fields
    JFrame f = new JFrame("Print all");
    CRUD crud = new CRUD();
    
    Button btnMid = new Button("Print list");
    
    TextArea taBot = new TextArea(4, 40);
    Button btnBot = new Button("Go back");
    
    // constructor
    public PrintAll() {
        
        // CONTAINER
        f.setBounds(100, 100, 800, 500);
        
        // LAYOUT
        GridLayout gl = new GridLayout(3, 1);
        f.setLayout(gl);
        
        // COMPONENTS
        Font font1 = new Font("Times New Roman", Font.BOLD, 24);
        Font font2 = new Font("Times New Roman", Font.BOLD, 12);
        
        // Top
        Label labTop = new Label("PRINT ALL EMPLOYEES", Label.CENTER);
        labTop.setFont(font1);
        labTop.setForeground(Color.BLUE);
        f.add(labTop);
        
        // Middle
        btnMid.addActionListener(this);
        
        Panel panMid = new Panel();
        panMid.add(btnMid);
        f.add(panMid);
        
        // Bottom
        taBot.addTextListener(this);
        btnBot.addActionListener(this);
        
        Panel panBot = new Panel();
        panBot.add(taBot); panBot.add(btnBot);
        f.add(panBot);
        
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        
    }
    
    // methods
    public void actionPerformed(ActionEvent ae) {
        
        if (ae.getSource() == btnMid) {
            
            String toAppend = "";
            
            // Turn each entry into a string and then append it to the text area.
            for (int i = 0; i < crud.count(); i++) {
                
                toAppend += crud.getEmployee(i).getId() + " ";
                toAppend += crud.getEmployee(i).getName() + " ";
                toAppend += crud.getEmployee(i).getDob() + " \n";
                
                taBot.append(toAppend);
                
                toAppend = "";
                
            }
            
            if (crud.count() == 0) {
                taBot.append("No employees are registered. \n");
            }
            
        } else if (ae.getSource() == btnBot) {
            
            new Menu();
            f.setVisible(false);
            
        }
        
    }
    
    public void textValueChanged(TextEvent te) {
        
        
        
    }
    
}
