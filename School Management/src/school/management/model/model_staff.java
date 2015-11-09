/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school.management.model;

/**
 *
 * @author youssouf.dasilva
 */
public class model_staff {
    String staffId;
    String firstName;
    String lastName;
    String department;
    String hiredDate;
    
    //staffId Accessor Methods
    //staffId setter Method
    public void setStaffId (String sI){
        staffId = sI;
    }
    //staffId getter Method
    public String getStaffId () {
        return staffId;
    }
    
    //firstName Accessor Methods
    //firstName setter Method
    public void setFirstName (String fN){
        firstName = fN;
    }
    //firstName getter Method
    public String getFirstName () {
        return firstName;
    }
    
    //lastName Accessor Methods
    //lastName setter Method
    public void setLastName (String lN){
        lastName = lN;
    }
    //lastName getter Method
    public String getLastName () {
        return lastName;
    }
    
    //department Accessor Methods
    //department setter Method
    public void setDepartment (String d){
        department = d;
    }
    //staffId getter Method
    public String getDepartment () {
        return department;
    }
    
    //hiredDate Accessor Methods
    //hiredDate setter Method
    public void setHiredDate (String hD){
        hiredDate = hD;
    }
    //hiredDate getter Method
    public String getHiredDate () {
        return hiredDate;
    }
    
}
