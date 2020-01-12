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
    
    public void removePerson(int index) {
        db.removePerson(index);
    }

    public void addPerson(FormEvent ev) {
        String name = ev.getName();
        String phoneNumber = ev.getPhoneNumber();
        String address = ev.getAddress();
        String relationCat = ev.getRelationCategory();
        String gender = ev.getGender();

        RelationCategory relationCategory;
        if (relationCat.equals("family")) {
            relationCategory = RelationCategory.family;
        } else if (relationCat.equals("friends")) {
            relationCategory = RelationCategory.friends;
        } else {
            relationCategory = RelationCategory.office;
        }

        Gender genderCat;
        if (gender.equals("Male")) {
            genderCat = Gender.male;
        } else {
            genderCat = Gender.female;
        }

        Person person = new Person(name, phoneNumber, address, relationCategory, genderCat);

        db.addPerson(person);

    }

    public void saveToFile(File file) throws IOException {
        db.saveToFile(file);
    }

    public void openFromFile(File file) throws IOException {
        db.openFromFile(file);
    }
}
