import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class FileOperationsTest {

    Path readFromFilePath = Paths.get("src/Textfiles/gym_medlemmar.txt");
    FileOperations fileOperations = new FileOperations();
    ArrayList<String> memberListUnfilteredForTest = new ArrayList<>();
    Visit visit = new Visit();

    @BeforeEach
    void setUp() throws FileNotFoundException {
        fileOperations.isTestMode = true;
        memberListUnfilteredForTest = fileOperations.readFromFileAddToStringArrayListTest(readFromFilePath);

    }

    @Test
    void readFromFileAddToStringArrayListTest() throws FileNotFoundException {
        ArrayList<String> memberListUnfiltered = fileOperations.readFromFileAddToStringArrayListTest(readFromFilePath);
        assertEquals(20, memberListUnfiltered.size());
        assertNotEquals(0, memberListUnfiltered.size());
        assertThrows(FileNotFoundException.class, () -> fileOperations.readFromFileAddToStringArrayListTest(Paths.get("src/.txt")));
    }

    @Test
    void getNameFromStringArrayListTest() {
        String testLine = memberListUnfilteredForTest.getFirst();
        String lastLine = memberListUnfilteredForTest.getLast();
        assertEquals("Fredrik Berggren",fileOperations.getNameFromStringArrayList(testLine));
        assertEquals("Jakob Lundin",fileOperations.getNameFromStringArrayList(lastLine));
        assertNotEquals("Fredde Berggren",fileOperations.getNameFromStringArrayList(testLine));
    }

    @Test
    void getAdressFromStringArrayListTest() {
        String testLine = memberListUnfilteredForTest.getFirst();
        String lastLine = memberListUnfilteredForTest.getLast();
        assertEquals("Skolgränd 8, 16819 Norrköping", fileOperations.getAdressFromStringArrayList(testLine));
        assertEquals("Backgränd 19, 69618 Sandviken", fileOperations.getAdressFromStringArrayList(lastLine));
    }
    @Test
    void getEmailFromStringArrayListTest() {
        String testLine = memberListUnfilteredForTest.getFirst();
        String lastLine = memberListUnfilteredForTest.getLast();
        assertEquals("fredde@fakemail.se", fileOperations.getEmailFromStringArrayList(testLine));
        assertEquals("jacke@fakemail.com", fileOperations.getEmailFromStringArrayList(lastLine));
    }

    @Test
    void getPersonalnumberFromStringArrayListTest() {
        String testLine = memberListUnfilteredForTest.getFirst();
        String lastLine = memberListUnfilteredForTest.getLast();
        assertEquals("851020-6728", fileOperations.getPersonalnumberFromStringArrayList(testLine));
        assertEquals("000718-8949", fileOperations.getPersonalnumberFromStringArrayList(lastLine));
    }

    @Test
    void getJoinDateFromStringArrayListTest() {
        String testLine = memberListUnfilteredForTest.getFirst();
        String lastLine = memberListUnfilteredForTest.getLast();
        LocalDate expectedDateTestLine = LocalDate.of(2019,12,30);
        LocalDate expectedDateLastLine = LocalDate.of(2020,7,10);

        assertEquals(expectedDateTestLine, fileOperations.getJoinDateFromStringArrayList(testLine));
        assertEquals(expectedDateLastLine, fileOperations.getJoinDateFromStringArrayList(lastLine));
    }
    @Test
    void getLastPaymentFromStringArrayListTest() {
        String testLine = memberListUnfilteredForTest.getFirst();
        String lastLine = memberListUnfilteredForTest.getLast();
        LocalDate expectedDateTestLine = LocalDate.of(2021,12,30);
        LocalDate expectedDateLastLine = LocalDate.of(2022,7,10);

        assertEquals(expectedDateTestLine, fileOperations.getLastPaymentFromStringArrayList(testLine));
        assertEquals(expectedDateLastLine, fileOperations.getLastPaymentFromStringArrayList(lastLine));
    }
    @Test
    void getMemberTypeFromStringArrayListTest() {
        String testLine = memberListUnfilteredForTest.getFirst();
        String lastLine = memberListUnfilteredForTest.getLast();

        assertEquals(MemberType.PLATINA, fileOperations.getMemberTypeFromStringArrayList(testLine));
        assertEquals(MemberType.STANDARD, fileOperations.getMemberTypeFromStringArrayList(lastLine));
    }

    @Test
    void writeToFileTest() throws IOException {
        Path filePath = Paths.get("src/Textfiles/PT-file.txt");
        Visit testVisit = new Visit("Astrid Larsson", "540815-4382",
                LocalDateTime.now());
        Visit testVisit2 = new Visit("Herbert Jansson", "060201-4763",
                LocalDateTime.now());
        Visit testVisit3 = new Visit("Astrid Larsson", "540815-4382",
                LocalDateTime.of(2025,10,17,14,27, 10, 100));

        visit.clearVisitsArrayList();
        testVisit.addVisitToVisitsArrayList();
        testVisit2.addVisitToVisitsArrayList();
        testVisit3.addVisitToVisitsArrayList();
        fileOperations.writeToFile(filePath);


        try(BufferedReader br = new BufferedReader(new FileReader(filePath.toString()))) {
            String line = br.readLine();
            assertTrue(line != null);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }


}