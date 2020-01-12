/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.model.phonebook;

import java.io.Serializable;

/**
 *
 * @author muchlas
 */
public class Person implements Serializable {

    /**
     *
     */

    private static int count = 0;

    private int id;
    private String name;
    private String phoneNumber;
    private String address;
    private RelationCategory relationCategory;
    private Gender gender;

    public Person(String name, String phoneNumber, String address, RelationCategory relationCategory, 
            Gender gender) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.relationCategory = relationCategory;
        this.gender = gender;

        this.id = count;
        count++;
    }

    public Person(int id, String name, String phoneNumber, String address, RelationCategory relationCategory, 
            Gender gender) {

        this(name, phoneNumber, address, relationCategory, gender);

        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public RelationCategory getRelationCategory() {
        return relationCategory;
    }

    public void setAgeCategory(RelationCategory relationCategory) {
        this.relationCategory = relationCategory;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
