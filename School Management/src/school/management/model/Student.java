/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school.management.model;
import java.util.*;

/**
 *
 * @author Migaliza
 */
public class Student {
   public String studentId;
   public String firstName;
   public String lastName;
   public Date dateOfBirth;
   public Date  currentdate;
   public int age;
   public String nationality;
   public String yearGroup;
  
   
   public String toString(){
        return studentId+"\t"+firstName+"\t"+lastName+"\t"+dateOfBirth+"\t"+age+"\t"+nationality+"\t"+yearGroup;
    }
   
}

