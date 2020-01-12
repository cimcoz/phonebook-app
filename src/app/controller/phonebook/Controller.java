/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controller.phonebook;

import java.io.File;
import java.io.IOException;
import java.util.List;
import app.model.phonebook.RelationCategory;
import app.model.phonebook.Database;
import app.model.phonebook.EmploymentCategory;
import app.model.phonebook.Gender;
import app.model.phonebook.Person;
import app.ui.phonebook.FormEvent;

/**
 *
 * @author muchlas
 */
public class Controller {

    Database db = new Database();
    
    public List<Person> getPeople() {
        return db.getPeople();
    }

    public void addPerson(FormEvent ev) {
        String name = ev.getName();
        String occupation = ev.getOccupation();
        int ageCatId = ev.getAgeCategory();
        String empCat = ev.getEmpCategory();
        String taxId = ev.getTaxId();
        String gender = ev.getGender();

        RelationCategory relationCategory = null;
        switch (ageCatId) {
            case 0:
                relationCategory = RelationCategory.family;
                break;
            case 1:
                relationCategory = RelationCategory.friends;
                break;
            case 2:
                relationCategory = RelationCategory.office;
                break;
            default:
        }

        EmploymentCategory empCategory;
        if (empCat.equals("employed")) {
            empCategory = EmploymentCategory.employed;
        } else if (empCat.equals("self-employed")) {
            empCategory = EmploymentCategory.selfEmployed;
        } else if (empCat.equals("unemployed")) {
            empCategory = EmploymentCategory.unEmployed;
        } else {
            empCategory = EmploymentCategory.other;
            System.err.println(empCat);
        }
        
        Gender genderCat;
        if (gender.equals("Male")) {
            genderCat = Gender.male;
        }
        else {
            genderCat = Gender.female;
        }
                
        Person person = new Person(name, occupation, relationCategory, empCategory, taxId, genderCat);

        db.addPerson(person);

    }
    
    public void saveToFile(File file) throws IOException {
        db.saveToFile(file);
    }
    
    public void openFromFile (File file) throws IOException {
        db.openFromFile(file);
    }
}
