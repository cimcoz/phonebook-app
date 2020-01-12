/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.ui.phonebook;

import java.io.File;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author muchlas
 */
public class PersonFileFilter extends FileFilter {

    @Override
    public boolean accept(File f) {

        if (f.isDirectory()) {
            return true;
        }

        String name = f.getName();
        String extension = Utils.getFileExtension(name);

        if (extension == null) {
            return false;
        }

        if (extension.equals("txt")) {
            return true;
        }

        return false;
    }

    @Override
    public String getDescription() {
        return "Text File (*.txt)";
    }

}
