/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.ui.phonebook;

import java.awt.BorderLayout;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import app.model.phonebook.Person;

/**
 *
 * @author muchlas
 */
public class TablePanel extends JPanel {
    
    private JTable table;
    private PersonTableModel tableModel;
    
    
    public TablePanel() {
        tableModel = new PersonTableModel();
        table = new JTable(tableModel);
        
        setLayout(new BorderLayout());
        
        add(new JScrollPane(table), BorderLayout.CENTER);
    }
    
    public void setData(List<Person> db) {
        tableModel.setData(db);
    }
    
    public void refreshData() {
        tableModel.fireTableDataChanged();
    }
}
