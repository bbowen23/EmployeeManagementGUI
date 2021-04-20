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
 * Login page for GUI
 * @author Benjamin Bowen
 * 
 * This screen was done in class. 
 */
public class Login extends JFrame implements ActionListener, TextListener {
    
    // fields
    TextField tfMid1 = new TextField(20);
    TextField tfMid2 = new TextField(20);
    Button btnMid1 = new Button("Log in");
    
    JFrame f = new JFrame("Log in");
    Database db = new Database();
    
    // constructor
    public Login() {
        
        // CONTAINER
        f.setBounds(100, 100, 800, 500);
        
        // LAYOUT
        GridLayout gl = new GridLayout(3, 1); // 3 rows, 1 column
        f.setLayout(gl);
        
        // COMPONENTS
        Font font1 = new Font("Times New Roman", Font.BOLD, 24);
        Font font2 = new Font("Times New Roman", Font.BOLD, 12);
        
        // Top
        Label labTop1 = new Label("EMPLOYEE MANAGEMENT SYSTEM", Label.CENTER);
        labTop1.setFont(font1);
        labTop1.setForeground(Color.BLUE);
        f.add(labTop1);
        
        // Middle
        Label labMid1 = new Label("ID: ");
        labMid1.setFont(font2);
        tfMid1.addTextListener(this);
        
        Label labMid2 = new Label("PW: ");
        labMid2.setFont(font2);
        tfMid2.setEchoChar('*');
        tfMid2.addTextListener(this);
        
        btnMid1.addActionListener(this);
        
        Panel panMid = new Panel();
        panMid.add(labMid1); panMid.add(tfMid1); panMid.add(labMid2); panMid.add(tfMid2); panMid.add(btnMid1);
        f.add(panMid);
        
        // Bottom
        Label labBot = new Label("Sponsored by Oklahoma City University", Label.CENTER);
        labBot.setFont(font2);
        labBot.setForeground(Color.RED);
        f.add(labBot);
        
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        
    }
    
    // methods
    public void actionPerformed(ActionEvent ae) {
        
        if (tfMid1.getText().equals("admin") && tfMid2.getText().equals("1614")) {
            
            db.loadDatabase();
            new Menu();
            f.setVisible(false);
            
        } else {
            
            new Login();
            f.setVisible(false);
            
        }
        
    }
    
    public void textValueChanged(TextEvent te) { }
    
}
