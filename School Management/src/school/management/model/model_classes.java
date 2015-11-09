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
public class model_classes {
    String classId;
    String className;

    //classId Accessor Methods
    //classId setter Method
    public void setClassId (String cI){
        classId = cI;
    }
    //classId getter Method
    public String getClassId () {
        return classId;
    }

    //className Accessor Methods
    //className setter Method
    public void setClassName (String cN){
        className = cN;
    }
    //className getter Method
    public String getClassName () {
        return className;
    }
}
