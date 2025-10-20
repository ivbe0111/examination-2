import FileOperationsPackage.FileOperations;
import MemberPackage.Member;
import MemberPackage.MemberType;
import Visit.Visit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class FileOperationsTest {

    Path readFromFilePath = Paths.get("src/Textfiles/gym_medlemmar.txt");
    FileOperations fileOperations = new FileOperations();
    Member member = new Member();
    ArrayList<Member> memberList;
    Visit visit = new Visit();
    String testLine = "Fredrik Berggren;Skolgränd 8, 16819 Norrköping;fredde@fakemail.se;851020-6728;2019-12-30;2021-12-30;Platina";
    String lastLine = "Jakob Lundin;Backgränd 19, 69618 Sandviken;jacke@fakemail.com;000718-8949;2020-07-10;2022-07-10;Standard";

    @BeforeEach
    void setUp() throws FileNotFoundException {
        fileOperations.isTestMode = true;
        member.clearMemberList();
        fileOperations.readFromFileAddToMemberList(readFromFilePath);
        memberList = member.getMemberList();
    }

    @Test
    void readFromFileAddToMemberListTest()  {
        //readFromFileAddToMemberList is ran in setUp higher up.
        assertEquals(20, memberList.size());
        assertNotEquals(0, memberList.size());
        Throwable exception = assertThrows(FileNotFoundException.class, () -> fileOperations.readFromFileAddToMemberList(Paths.get("src/.txt")));
        System.out.println(exception.getMessage());
    }

    @Test
    void getNameFromReadLineTest() {
        assertEquals("Fredrik Berggren",fileOperations.getNameFromReadLine(testLine));
        assertEquals("Jakob Lundin",fileOperations.getNameFromReadLine(lastLine));
        assertNotEquals("Fredde Berggren",fileOperations.getNameFromReadLine(testLine));
    }

    @Test
    void getAdressFromReadLineTest() {
        assertEquals("Skolgränd 8, 16819 Norrköping", fileOperations.getAdressFromReadLine(testLine));
        assertEquals("Backgränd 19, 69618 Sandviken", fileOperations.getAdressFromReadLine(lastLine));
    }
    @Test
    void getEmailFromReadLineTest() {
        assertEquals("fredde@fakemail.se", fileOperations.getEmailFromReadLine(testLine));
        assertEquals("jacke@fakemail.com", fileOperations.getEmailFromReadLine(lastLine));
    }

    @Test
    void getPersonalnumberFromReadLineTest() {
        assertEquals("851020-6728", fileOperations.getPersonalnumberFromReadLine(testLine));
        assertEquals("000718-8949", fileOperations.getPersonalnumberFromReadLine(lastLine));
    }

    @Test
    void getJoinDateFromReadLineTest() {
        LocalDate expectedDateTestLine = LocalDate.of(2019,12,30);
        LocalDate expectedDateLastLine = LocalDate.of(2020,7,10);

        assertEquals(expectedDateTestLine, fileOperations.getJoinDateFromReadLine(testLine));
        assertEquals(expectedDateLastLine, fileOperations.getJoinDateFromReadLine(lastLine));
    }
    @Test
    void getLastPaymentFromReadLineTest() {
        LocalDate expectedDateTestLine = LocalDate.of(2021,12,30);
        LocalDate expectedDateLastLine = LocalDate.of(2022,7,10);

        assertEquals(expectedDateTestLine, fileOperations.getLastPaymentFromReadLine(testLine));
        assertEquals(expectedDateLastLine, fileOperations.getLastPaymentFromReadLine(lastLine));
    }
    @Test
    void getMemberTypeFromReadLineTest() {
        assertEquals(MemberType.PLATINA, fileOperations.getMemberTypeFromReadLine(testLine));
        assertEquals(MemberType.STANDARD, fileOperations.getMemberTypeFromReadLine(lastLine));
    }

    @Test
    void writeToFileTest() throws IOException {
        Path filePath = Paths.get("src/Textfiles/PT-file.txt");
        visit.clearVisitsArrayList();
        memberList.get(1).memberVisitsGym();
        memberList.get(6).memberVisitsGym();
        memberList.get(1).memberVisitsGym();

        fileOperations.writeToFile(filePath);

        ArrayList<Visit> visitsTest = visit.getVisits();
        String expected = "Name\t\t\t\tPersonalNumber\tDate Visited";
        String line2expected = visitsTest.get(0).toString();
        String lastLineExpected = visitsTest.getLast().toString();
        try(BufferedReader br = new BufferedReader(new FileReader(filePath.toString()))) {
            String line = br.readLine();
            assertNotNull(line);
            assertEquals(expected, line);
            assertNotEquals("Felaktig input", line);
            String line2 = br.readLine();
            assertNotNull(line2);
            assertEquals(line2expected, line2);
            br.readLine();
            String lastLine = br.readLine();
            assertEquals(lastLineExpected, lastLine);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


}