/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school.management.model;

/**
 *
 * @author Migaliza
 */
public class SUBJECT {
    String subjectCode;
    String subjectName;
    String department;
    
    public String toString(){
        return subjectCode+"\t"+subjectName+"\t"+department;
    }
}
