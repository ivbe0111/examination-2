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
    void readFromFileAddToMemberArrayListTest() throws FileNotFoundException {
        ArrayList<Member> memberList = fileOperations.readFromFileAddToMemberArrayListTest(readFromFilePath);

        assertEquals(20, memberList.size());
        assertNotEquals(0, memberList.size());

    }

    @Test
    void writeToFileTest() {

    }


}