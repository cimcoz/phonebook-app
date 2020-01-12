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
    private static final long serialVersionUID = 7568745478585432226L;

    private static int count = 0;

    private int id;
    private String name;
    private String occupation;
    private RelationCategory relationCategory;
    private EmploymentCategory empCategory;
    private String taxId;
    private Gender gender;

    public Person(String name, String occupation, RelationCategory relationCategory,
            EmploymentCategory employmentCategory, String taxId, Gender gender) {
        this.name = name;
        this.occupation = occupation;
        this.relationCategory = relationCategory;
        this.empCategory = employmentCategory;
        this.taxId = taxId;
        this.gender = gender;

        this.id = count;
        count++;
    }

    public Person(int id, String name, String occupation, RelationCategory relationCategory,
            EmploymentCategory empCat, String taxId, Gender gender) {

        this(name, occupation, relationCategory, empCat, taxId, gender);

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

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public RelationCategory getRelationCategory() {
        return relationCategory;
    }

    public void setAgeCategory(RelationCategory relationCategory) {
        this.relationCategory = relationCategory;
    }

    public EmploymentCategory getEmpCategory() {
        return empCategory;
    }

    public void setEmpCategory(EmploymentCategory empCategory) {
        this.empCategory = empCategory;
    }

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
