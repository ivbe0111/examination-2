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
        fileOperations.readFromFileAddToStringArrayList(readFromFilePath);
        memberList = member.getMemberList();
    }

    @Test
    void readFromFileAddToStringArrayListTest() throws FileNotFoundException {
        assertEquals(20, memberList.size());
        assertNotEquals(0, memberList.size());
        assertThrows(FileNotFoundException.class, () -> fileOperations.readFromFileAddToStringArrayList(Paths.get("src/.txt")));
    }

    @Test
    void getNameFromStringArrayListTest() {
        assertEquals("Fredrik Berggren",fileOperations.getNameFromStringArrayList(testLine));
        assertEquals("Jakob Lundin",fileOperations.getNameFromStringArrayList(lastLine));
        assertNotEquals("Fredde Berggren",fileOperations.getNameFromStringArrayList(testLine));
    }

    @Test
    void getAdressFromStringArrayListTest() {
        assertEquals("Skolgränd 8, 16819 Norrköping", fileOperations.getAdressFromStringArrayList(testLine));
        assertEquals("Backgränd 19, 69618 Sandviken", fileOperations.getAdressFromStringArrayList(lastLine));
    }
    @Test
    void getEmailFromStringArrayListTest() {
        assertEquals("fredde@fakemail.se", fileOperations.getEmailFromStringArrayList(testLine));
        assertEquals("jacke@fakemail.com", fileOperations.getEmailFromStringArrayList(lastLine));
    }

    @Test
    void getPersonalnumberFromStringArrayListTest() {
        assertEquals("851020-6728", fileOperations.getPersonalnumberFromStringArrayList(testLine));
        assertEquals("000718-8949", fileOperations.getPersonalnumberFromStringArrayList(lastLine));
    }

    @Test
    void getJoinDateFromStringArrayListTest() {
        LocalDate expectedDateTestLine = LocalDate.of(2019,12,30);
        LocalDate expectedDateLastLine = LocalDate.of(2020,7,10);

        assertEquals(expectedDateTestLine, fileOperations.getJoinDateFromStringArrayList(testLine));
        assertEquals(expectedDateLastLine, fileOperations.getJoinDateFromStringArrayList(lastLine));
    }
    @Test
    void getLastPaymentFromStringArrayListTest() {
        LocalDate expectedDateTestLine = LocalDate.of(2021,12,30);
        LocalDate expectedDateLastLine = LocalDate.of(2022,7,10);

        assertEquals(expectedDateTestLine, fileOperations.getLastPaymentFromStringArrayList(testLine));
        assertEquals(expectedDateLastLine, fileOperations.getLastPaymentFromStringArrayList(lastLine));
    }
    @Test
    void getMemberTypeFromStringArrayListTest() {
        assertEquals(MemberType.PLATINA, fileOperations.getMemberTypeFromStringArrayList(testLine));
        assertEquals(MemberType.STANDARD, fileOperations.getMemberTypeFromStringArrayList(lastLine));
    }

    @Test
    void writeToFileTest() throws IOException {
        Path filePath = Paths.get("src/Textfiles/PT-file.txt");
        visit.clearVisitsArrayList();
        memberList.get(1).memberVisitsGym();
        memberList.get(6).memberVisitsGym();
        memberList.get(1).memberVisitsGym();

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