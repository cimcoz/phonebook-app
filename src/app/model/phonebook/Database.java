/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.model.phonebook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

/**
 *
 * @author muchlas
 */
public class Database {

    private List<Person> people;

    public Database() {
        people = new LinkedList<Person>();
    }

    public void addPerson(Person person) {
        people.add(person);
    }
    
    public void removePerson(int index) {
        people.remove(index);
    }

    public List<Person> getPeople() {
        return Collections.unmodifiableList(people);
    }

    public void saveToFile(File file) throws IOException {
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        Person[] personArr = people.toArray(new Person[people.size()]);

        oos.writeObject(personArr);

        oos.close();
    }

    public void openFromFile(File file) throws IOException {
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);

        try {
            Person[] personArr = (Person[]) ois.readObject();

            people.clear();
            people.addAll(Arrays.asList(personArr));

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        ois.close();
    }
}
