/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.ui.phonebook;

import app.model.phonebook.Person;

/**
 *
 * @author muchlas
 */
public interface PersonTableListener {

    public void rowDeleted(int row);
    public void rowUpdated(int row, Person person);
}
