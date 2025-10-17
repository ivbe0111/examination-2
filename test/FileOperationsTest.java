import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class FileOperationsTest {

    Path readFromFilePath = Paths.get("src/Textfiles/gym_medlemmar.txt");
    FileOperations fileOperations = new FileOperations();

    @BeforeEach
    void setUp(){
        fileOperations.isTestMode = true;
    }

    @Test
    void readFromFileAddToStringArrayListTest() throws FileNotFoundException {
        ArrayList<String> memberListUnfiltered = fileOperations.readFromFileAddToStringArrayListTest(readFromFilePath);
        assertEquals(20, memberListUnfiltered.size());
        assertNotEquals(0, memberListUnfiltered.size());
        assertThrows(FileNotFoundException.class, () -> fileOperations.readFromFileAddToStringArrayListTest(Paths.get("src/.txt")));
    }



//    @Test
//    void getNameFromLineTest(){
//
//        assertEquals();
//    }

    @Test
    void writeToFileTest() {

    }


}