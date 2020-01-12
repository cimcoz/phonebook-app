/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.ui.phonebook;

import java.util.EventObject;

/**
 *
 * @author muchlas
 */
public class FormEvent extends EventObject {

    private String name;
    private String phoneNumber;
    private String address;
    private String relationCategory;
    private String gender;

    public FormEvent(Object source) {
        super(source);
    }

    public FormEvent(Object source, String name, String phoneNumber, String address, String relationCategory, 
            String gender) {
        
        super(source);

        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.relationCategory = relationCategory;
        this.gender = gender;

    }
    
    public String getGender() {
        return gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRelationCategory() {
        return relationCategory;
    }
  
}
