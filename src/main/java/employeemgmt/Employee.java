/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeemgmt;

/**
 * Employee class
 * @author Benjamin Bowen
 */
public class Employee {
    
    // fields
    private int id;
    private String name;
    private String dob;
    
    public int getId() { return id; }
    public String getName() { return name; }
    public String getDob() { return dob; }
    
    // constructor
    public Employee(int _id, String _name, String _dob) {
        
        id = _id;
        name = _name;
        dob = _dob;
        
    }
    
    // methods
    
}
