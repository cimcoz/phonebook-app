/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.ui.phonebook;

import java.awt.FlowLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author muchlas
 */
public class SearchPanel extends JPanel {

    private JLabel searchLabel;
    private JTextField searchField;
    
    public SearchPanel() {
        setBorder(BorderFactory.createEtchedBorder());

        searchLabel = new JLabel("Search by Name: ");
        searchField = new JTextField(10);

        setLayout(new FlowLayout(FlowLayout.RIGHT));
        add(searchLabel);
        add(searchField);

        // Create Main Border
    }
}
