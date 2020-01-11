/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.ui.phonebook;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author muchlas
 */
public class Toolbar extends JPanel implements ActionListener {

    private JButton helloBtn;
    private JButton goodbyeBtn;
    private StringListener textListener;

    public Toolbar() {
        setBorder(BorderFactory.createEtchedBorder());

        helloBtn = new JButton("Hello");
        goodbyeBtn = new JButton("Exit");

        helloBtn.addActionListener(this);
        goodbyeBtn.addActionListener(this);

        setLayout(new FlowLayout(FlowLayout.LEFT));

        add(helloBtn);
        add(goodbyeBtn);

    }

    public void setStringListener(StringListener listener) {
        this.textListener = listener;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clicked = (JButton) e.getSource();

        if (clicked == helloBtn) {
            if (textListener != null) {
                textListener.textEmitted("Hello\n");
            }
        } else if (clicked == goodbyeBtn) {
            if (textListener != null) {
                textListener.textEmitted("GoodBye\n");
            }
        }
    }

}
