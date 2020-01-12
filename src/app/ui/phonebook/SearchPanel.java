/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.ui.phonebook;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

/**
 *
 * @author muchlas
 */
public class SearchPanel extends JPanel {

    private JLabel searchLabel;
    private JTextField searchField;
    
    public SearchPanel() {
        setBorder(BorderFactory.createEtchedBorder());
        
        searchLabel = new JLabel("Search Contact: ");
        searchField = new JTextField(20);
        
        setLayout(new FlowLayout(FlowLayout.RIGHT));
        add(searchLabel);
        add(searchField);
        
        
        // Create Main Border
     
    }
}
