package GUI;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WindowAdapterClass extends WindowAdapter {

    public void windowClosing(WindowEvent e) {
        Path filePath = Paths.get("src/Textfiles/PT-file.txt");
//        fileOperations.writeToFile(filePath);

    }
}
