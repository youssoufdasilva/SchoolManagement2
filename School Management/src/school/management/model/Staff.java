/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school.management.model;
import java.util.*;

/**
 *
 * @author Youssouf
 */
public class Staff {
   public String staffId;
   public String firstName;
   public String lastName;
   public Date dateOfBirth;
   public Date  hiredDate;
   public String department;


   public String toString(){
        return staffId+"\t"+firstName+"\t"+lastName+"\t"+dateOfBirth+"\t"+hiredDate+"\t"+department;
    }

}
