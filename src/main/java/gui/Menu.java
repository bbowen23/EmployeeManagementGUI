/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Menu screen for GUI
 * @author Benjamin Bowen
 * 
 * This file took about 30 minutes to write. I substituted the check boxes for radio buttons.
 * TOTAL TIME: 0H 30M
 */
public class Menu extends JFrame implements ItemListener, ActionListener {
    
    // fields
    JFrame f = new JFrame("Menu");
    CheckboxGroup cbg = new CheckboxGroup(); // This enables me to create radio buttons.
    Checkbox cb1 = new Checkbox("Register", cbg, false);
    Checkbox cb2 = new Checkbox("Search", cbg, false);
    Checkbox cb3 = new Checkbox("Count", cbg, false);
    Checkbox cb4 = new Checkbox("Print all", cbg, false);
    Checkbox cb5 = new Checkbox("Exit", cbg, false);
    Button btnMid = new Button("Continue");
    
    private String option;
    
    // constructor
    public Menu() {
        
        // CONTAINER
        f.setBounds(100, 100, 800, 500);
        
        // LAYOUT
        GridLayout gl = new GridLayout(3, 1);
        f.setLayout(gl);
        
        // COMPOMENTS
        Font font1 = new Font("Times New Roman", Font.BOLD, 24);
        Font font2 = new Font("Times New Roman", Font.BOLD, 12);
        
        // Top
        Label labTop1 = new Label("MAIN MENU", Label.CENTER);
        labTop1.setFont(font1);
        labTop1.setForeground(Color.BLUE);
        f.add(labTop1);
        
        // Middle
        Label labMid = new Label("Select an option:");
        
        cb1.addItemListener(this);
        cb2.addItemListener(this);
        cb3.addItemListener(this);
        cb4.addItemListener(this);
        cb5.addItemListener(this);
        btnMid.addActionListener(this);
        
        Panel panMid = new Panel();
        panMid.add(cb1); panMid.add(cb2); panMid.add(cb3); panMid.add(cb4); panMid.add(cb5); panMid.add(btnMid);
        f.add(panMid);
        
        // Bottom
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        
    }
    
    // methods
    public void itemStateChanged(ItemEvent ie) {
        
        option = (String) ie.getItem();
        
    }
    
    public void actionPerformed(ActionEvent ae) {
        
        if (option.equals("Register")) {
            new Register();
            f.setVisible(false);
        } else if (option.equals("Search")) {
            new Search();
            f.setVisible(false);
        } else if (option.equals("Count")) {
            new Count();
            f.setVisible(false);
        } else if (option.equals("Print all")) {
            new PrintAll();
            f.setVisible(false);
        } else if (option.equals("Exit")) {
            System.exit(0); // end program
        }
        
    }
    
}
