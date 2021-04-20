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
 * Get count of all employees with GUI
 * @author Benjamin Bowen
 * 
 * This file took about 5 minutes to write and did not require debugging.
 * TOTAL TIME: 0H 05M
 */
public class Count extends JFrame implements ActionListener, TextListener {
    
    // fields
    JFrame f = new JFrame("Count");
    CRUD crud = new CRUD();
    
    Button btnMid = new Button("Get count");
    
    TextArea taBot = new TextArea(2, 40);
    Button btnBot = new Button("Go back");
    
    // constructor
    public Count() {
        
        // CONTAINER
        f.setBounds(100, 100, 800, 500);
        
        // LAYOUT
        GridLayout gl = new GridLayout(3, 1);
        f.setLayout(gl);
        
        // COMPONENTS
        Font font1 = new Font("Times New Roman", Font.BOLD, 24);
        Font font2 = new Font("Times New Roman", Font.BOLD, 12);
        
        // Top
        Label labTop = new Label("COUNT ALL EMPLOYEES", Label.CENTER);
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
            
            taBot.append("There are " + crud.count() + " employees registered.\n");
            
        } else if (ae.getSource() == btnBot) {
            
            new Menu();
            f.setVisible(false);
            
        }
        
    }
    
    public void textValueChanged(TextEvent te) {
        
        
        
    }
    
}
