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
public class GradeTable {
    String yearGroup;
    String stream;
    String StudentId;
    String firstName;
    String lastName;
    double Math;
    double science;
    double english;
    double technology;
    double average;
    String Grade;
    
    public String toString(){
        return yearGroup+"\t"+stream+"\t"+firstName+"\t"+lastName+"\t"+Math+"\t"+science+"\t"+english+"\t"+technology+"\t"+average+"\t"+Grade;
    }
    
    
}
