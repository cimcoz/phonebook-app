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
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;

/**
 *
 * @author muchlas
 */
public class TablePanel extends JPanel {

    private JTable table;
    private JLabel searchLabel;
    private JTextField searchField;
    private JPanel form;
    private PersonTableModel tableModel;
    private JPopupMenu popup;
    private PersonTableListener personTableListener;

    public TablePanel() {
        tableModel = new PersonTableModel();
        table = new JTable(tableModel);
        form = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        popup = new JPopupMenu();
        searchLabel = new JLabel("Search Data: ");
        searchField = new JTextField(20);
        

        JMenuItem removeItem = new JMenuItem("Delete row...");
        JMenuItem updateItem = new JMenuItem("Update row...");
        popup.add(removeItem);
        popup.add(updateItem);

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int row = table.rowAtPoint(e.getPoint());
                table.getSelectionModel().setSelectionInterval(row, row);

                if (e.getButton() == MouseEvent.BUTTON3) {
                    popup.show(table, e.getX(), e.getY());
                }
            }

        });

        removeItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = table.getSelectedRow();

                if (personTableListener != null) {
                    personTableListener.rowDeleted(row);
                    tableModel.fireTableRowsDeleted(row, row);
                }
            }
        });

        form.add(searchLabel);
        form.add(searchField);
//        searchField.getDocument().addDocumentListener(new DocumentListener() {
//            @Override
//            public void insertUpdate(DocumentEvent e) {
//                filterData();
//            }
//
//            @Override
//            public void removeUpdate(DocumentEvent e) {
//                filterData();
//            }
//
//            @Override
//            public void changedUpdate(DocumentEvent e) {
//                filterData();
//            }
//        });

        setLayout(new BorderLayout());

        add(new JScrollPane(table), BorderLayout.CENTER);
        add(form, BorderLayout.SOUTH);
    }

    public void setData(List<Person> db) {
        tableModel.setData(db);
    }

    public void refreshData() {
        tableModel.fireTableDataChanged();
    }

    public void setPersonTableListener(PersonTableListener listener) {
        this.personTableListener = listener;
    }

//    public void filterData() {
//        RowFilter<PersonTableModel, Object> rf = null;
//        try {
//            rf = RowFilter.regexFilter(searchField.getText(), 0);
//        } catch (PatternSyntaxException e) {
//            return;
//        }
//        sorter.setRowFilter(rf);
//    }

}
