/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.ui.phonebook;

import app.controller.phonebook.Controller;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

/**
 *
 * @author muchlas
 */
public class MainFrame extends JFrame {

    private FormPanel formPanel;
    private SearchPanel searchPanel;
    private JFileChooser fileChooser;
    private Controller controller;
    private TablePanel tablePanel;

    public MainFrame() {
        super("Phonebook Application");

        // Set Layout of Main Frame
        setLayout(new BorderLayout());

        // Init Component
        formPanel = new FormPanel();
        searchPanel = new SearchPanel();
        tablePanel = new TablePanel();

        controller = new Controller();

        tablePanel.setData(controller.getPeople());
        tablePanel.setPersonTableListener(new PersonTableListener() {
            public void rowDeleted(int row) {
                controller.removePerson(row);
            }
        });

        fileChooser = new JFileChooser();
        fileChooser.addChoosableFileFilter(new PersonFileFilter());

        setJMenuBar(createMenuBar());

        // Component Properties
        formPanel.setFormListener(new FormListener() {
            @Override
            public void formEventOccured(FormEvent e) {
                controller.addPerson(e);
                tablePanel.refreshData();
            }
        });

        // Adding Components
        add(formPanel, BorderLayout.WEST);
//        add(searchPanel, BorderLayout.NORTH);
        add(tablePanel, BorderLayout.CENTER);

        // Layout Properties
        setMinimumSize(new Dimension(500, 400));
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenuItem saveDataItem = new JMenuItem("Save to File...");
        JMenuItem openDataItem = new JMenuItem("Open from File...");
        JMenuItem exitItem = new JMenuItem("Exit");

        fileMenu.add(saveDataItem);
        fileMenu.add(openDataItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);

        JMenu windowsMenu = new JMenu("Window");
        JMenu showMenu = new JMenu("Show");
        JMenuItem showFormItem = new JMenuItem("Person Form");
        showMenu.add(showFormItem);
        windowsMenu.add(showMenu);

        menuBar.add(fileMenu);
        menuBar.add(windowsMenu);

        fileMenu.setMnemonic(KeyEvent.VK_F);
        exitItem.setMnemonic(KeyEvent.VK_X);

        saveDataItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        openDataItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));

        openDataItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (fileChooser.showOpenDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION) {
                    try {
                        controller.openFromFile(fileChooser.getSelectedFile());
                        tablePanel.refreshData();
                    } catch (IOException ex1) {
                        JOptionPane.showMessageDialog(MainFrame.this,
                                "Tidak dapat membuka data dari file!", "Error",
                                JOptionPane.ERROR_MESSAGE);
                    }
                    System.out.println();
                }
            }
        });

        saveDataItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (fileChooser.showSaveDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION) {
                    try {
                        controller.saveToFile(fileChooser.getSelectedFile());
                    } catch (IOException ex1) {
                        JOptionPane.showMessageDialog(MainFrame.this,
                                "Tidak dapat menyimpan data ke file!", "Error",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int action = JOptionPane.showConfirmDialog(MainFrame.this,
                        "Apakah anda yakin ingin keluar?",
                        "Confirm Exit", JOptionPane.OK_CANCEL_OPTION);

                if (action == JOptionPane.OK_OPTION) {
                    System.exit(0);
                }

            }
        });

        return menuBar;
    }
}
