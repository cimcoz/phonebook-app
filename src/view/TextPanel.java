/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author muchlas
 */
public class TextPanel extends JPanel {
    private JTextArea txtArea;
    
    public TextPanel() {
        txtArea = new JTextArea();
        
        setLayout(new BorderLayout());
        
        add(new JScrollPane(txtArea), BorderLayout.CENTER);
    }
    
    public void addText(String text) {
        txtArea.append(text);
    }
    
}
