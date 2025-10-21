package GUI;

import FileOperationsPackage.FileOperations;
import SerializePackage.SerializeClass;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WindowAdapterClass extends WindowAdapter {

    public void windowClosing(WindowEvent e) {
        FileOperations fileOperations = new FileOperations();
        Path filePath = Paths.get("src/Textfiles/PT-file.txt");
        SerializeClass serialize = new SerializeClass();
        try {
            fileOperations.writeToFile(filePath);
            serialize.serializeVisitArrayList();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }

    }
}
