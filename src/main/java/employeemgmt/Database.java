/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeemgmt;
import java.io.*;

/**
 * Database for Employees
 * @author Benjamin Bowen
 * 
 * Debugging took about 30 minutes. Adding the getEmployee() method took under 1 minute.
 * loadDatabase() took 20 minutes to write and 5 minutes to debug.
 * 
 * TOTAL TIME: 56 minutes
 */
public class Database {
    
    // I WAS FRUSTRATED WHILE TRYING TO FIX A NULLPOINTEREXCEPTION, SO I COPY-PASTED THE CODE TO MAKE SURE IT WAS THE SAME.
    // THE SEARCH FUNCTION WAS CAUSING THE ERROR. IT TURNS OUT THAT I JUST NEEDED TO MAKE THE FIELDS STATIC.
    
    //field
    private static Employee DB[] = new Employee[10];
    private static int db1=0;
    
    public Employee[] loadDatabase() {
        
        try {
            
            BufferedReader br = new BufferedReader(new FileReader("C:/Users/benja/OneDrive/Desktop/CS Projects/Programming II/EmployeeProject2/data.txt"));
            
            while (true) {
                
                String idString, name, dob = "";
                int idInt = 0;
                String str = br.readLine();
                
                if (str == null) {
                    break;
                }
                
                String fields[] = str.split("\\t");
                
                // Convert fields[0] to int
                try {
                    
                    idInt = Integer.parseInt(fields[0].trim());
                    
                } catch (NumberFormatException nfe) {
                    
                }
                
                DB[db1] = new Employee(idInt, fields[1], fields[2]);
                db1++;
                
            }
            
        } catch (IOException ioe) {
            
            
            
        }
        
        return DB;
        
    }
    
    //method
    public Employee register(Employee emp){
        DB[db1] = emp;
        db1++;
        
        try {
            
            BufferedWriter bw = new BufferedWriter(new FileWriter("C:/Users/benja/OneDrive/Desktop/CS Projects/Programming II/EmployeeProject2/data.txt", true));
            String toWrite = "";
            
            toWrite += emp.getId() + "\t";
            toWrite += emp.getName() + "\t";
            toWrite += emp.getDob(); 
            
            bw.write(toWrite);
            bw.write("\n");
            toWrite = "";
            bw.flush();
            bw.close();
            
        } catch (IOException ioe) {
            
        }
        
        return DB[db1-1];
    }//reg
    
    public Employee search(int id){
        Employee result = null;
        for(int i=0; i<DB.length; i++){
            if(DB[i].getId()==id){
                result = DB[i];
                break;
            }//fi
        }//for(i)
        return result;
    }//reg
    
    public int count(){
        int result = db1;
        return result;
    }//reg
    
    public Employee[] print(){
        return DB;
    }//reg
    
    public Employee getEmployee(int index) {
        
        return DB[index];
        
    }
    
    //constr
 
}
