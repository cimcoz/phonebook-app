/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.ui.phonebook;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;

/**
 *
 * @author muchlas
 */
public class FormPanel extends JPanel {

    private JLabel nameLabel;
    private JLabel phoneLabel;
    private JLabel addressLabel;
    private JTextField nameField;
    private JTextField phoneField;
    private JTextField addressField;
    private JButton okBtn;
    private FormListener formListener;
    private JComboBox relationBox;
    private JRadioButton maleRadio;
    private JRadioButton femaleRadio;
    private ButtonGroup genderGroup;

    public FormPanel() {
        Dimension dim = getPreferredSize();
        dim.width = 250;
        setPreferredSize(dim);

        // Init Components
        nameLabel = new JLabel("Name: ");
        phoneLabel = new JLabel("Phone: ");
        addressLabel = new JLabel("Address: ");
        nameField = new JTextField(10);
        phoneField = new JTextField(10);
        addressField = new JTextField(10);
        relationBox = new JComboBox();
        okBtn = new JButton("OK");

        // Set up mnemonics
        okBtn.setMnemonic(KeyEvent.VK_O);

        nameLabel.setDisplayedMnemonic(KeyEvent.VK_N);
        nameLabel.setLabelFor(nameField);

        maleRadio = new JRadioButton("Male");
        femaleRadio = new JRadioButton("Female");

        maleRadio.setActionCommand("Male");
        femaleRadio.setActionCommand("Female");

        genderGroup = new ButtonGroup();

        maleRadio.setSelected(true);

        // Set up gender radios
        genderGroup.add(maleRadio);
        genderGroup.add(femaleRadio);

        // Set up ComboBox
        DefaultComboBoxModel relationModel = new DefaultComboBoxModel();
        relationModel.addElement("family");
        relationModel.addElement("friends");
        relationModel.addElement("office-work");
        relationBox.setModel(relationModel);
        relationBox.setSelectedIndex(0);

        okBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String phoneNumber = phoneField.getText();
                String address = addressField.getText();
                String relationCategory = (String) relationBox.getSelectedItem();
                String gender = genderGroup.getSelection().getActionCommand();

                FormEvent ev = new FormEvent(this, name, phoneNumber, address, relationCategory, gender);

                if (formListener != null) {
                    formListener.formEventOccured(ev);
                }
            }

        });

        // Create Main Border
        Border innerBorder = BorderFactory.createTitledBorder("Add Person's Contact");
        Border outerBorder = BorderFactory.createEmptyBorder(3, 3, 3, 3);
        setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

        layoutComponent();
    }

    public void layoutComponent() {
        setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();

        //////// First Row ////////
        gc.gridy = 0;

        gc.weightx = 1;
        gc.weighty = 0.1;

        gc.gridx = 0;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0, 0, 0, 5);
        add(nameLabel, gc);

        gc.gridx = 1;
        gc.gridy = 0;
        gc.insets = new Insets(0, 0, 0, 0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(nameField, gc);

        //////// Second Row ////////
        gc.gridy++;

        gc.weightx = 1;
        gc.weighty = 0.1;

        gc.gridx = 0;
        gc.insets = new Insets(0, 0, 0, 5);
        gc.anchor = GridBagConstraints.LINE_END;
        add(phoneLabel, gc);

        gc.gridx = 1;
        gc.insets = new Insets(0, 0, 0, 0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(phoneField, gc);

        //////// Next Row ////////
        gc.gridy++;

        gc.weightx = 1;
        gc.weighty = 0.1;

        gc.gridx = 0;
        gc.insets = new Insets(0, 0, 0, 5);
        gc.anchor = GridBagConstraints.LINE_END;
        add(addressLabel, gc);

        gc.gridx = 1;
        gc.insets = new Insets(0, 0, 0, 0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(addressField, gc);


        //////// Next Row ////////
        gc.gridy++;

        gc.weightx = 1;
        gc.weighty = 0.1;

        gc.gridx = 0;
        gc.insets = new Insets(0, 0, 0, 5);
        gc.anchor = GridBagConstraints.FIRST_LINE_END;
        add(new JLabel("Relation: "), gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);
        add(relationBox, gc);

        //////// Next Row ////////
        gc.gridy++;

        gc.weightx = 1;
        gc.weighty = 0.05;

        gc.gridx = 0;
        gc.insets = new Insets(0, 0, 0, 5);
        gc.anchor = GridBagConstraints.LINE_END;
        add(new JLabel("Gender: "), gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);
        add(maleRadio, gc);

        //////// Next Row ////////
        gc.gridy++;

        gc.weightx = 1;
        gc.weighty = 0.2;

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);
        add(femaleRadio, gc);

        //////// Next Row ////////
        gc.gridy++;

        gc.weightx = 1;
        gc.weighty = 2.0;

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);
        add(okBtn, gc);
    }

    public void setFormListener(FormListener listener) {
        this.formListener = listener;
    }
}

//class RelationCategory {
//
//    private int id;
//    private String text;
//
//    public RelationCategory(int id, String text) {
//        this.id = id;
//        this.text = text;
//    }
//
//    public String toString() {
//        return text;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//}
