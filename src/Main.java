import FileOperationsPackage.FileOperations;
import GUI.GUI;
import SerializePackage.SerializeClass;

import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    SerializeClass serialize = new SerializeClass();
    FileOperations fileOperations = new FileOperations();

    Main() throws FileNotFoundException {

        Path path = Paths.get("src/Textfiles/gym_medlemmar.txt");
        Path serializeFile = Paths.get("VisitArray.ser");

        if(Files.exists(serializeFile)){
            serialize.deSerializeToVisitArrayList();
        }
        fileOperations.readFromFileAddToMemberList(path);
        GUI gui = new GUI();

    }


    static void main() throws FileNotFoundException {
        Main main = new Main();
    }
}
