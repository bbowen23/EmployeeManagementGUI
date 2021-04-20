/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeemgmt;

/**
 * Create, Read, Update, Delete
 * @author Benjamin Bowen
 * 
 * This file was copy-pasted. Adding the getEmployee() method took under 1 minute.
 * TOTAL TIME: 0H 01M
 */
public class CRUD {
    
    // fields
    private Database db = new Database();
    
    // constructor
    
    // methods
    public Employee register(Employee e) {
        
        Employee result = null;
        result = db.register(e);
        return result;
        
    }
    
    public Employee search(int id) {
        
        Employee result = null;
        result = db.search(id);
        return result;
        
    }
    
    public int count() {
        
        int result = 0;
        result = db.count();
        return result;
        
    }
    
    public Employee[] print() {
        
        Employee[] result = null;
        result = db.print();
        return result;
        
    }
    
    public Employee getEmployee(int index) {
        
        Employee result = null;
        result = db.getEmployee(index);
        return result;
        
    }
    
}
