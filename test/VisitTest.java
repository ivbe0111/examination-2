import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class VisitTest {

    Visit visit = new Visit();
    Member member = new Member();
    Path readFromFilePath = Paths.get("src/Textfiles/gym_medlemmar.txt");
    ArrayList<Member> memberList = new ArrayList<>();
    FileOperations fileOperations = new FileOperations();

    @BeforeEach
    void setUp() throws FileNotFoundException {
    memberList = member.createMemberArrayListFromFile
            (fileOperations.readFromFileAddToStringArrayList(readFromFilePath));
    }

    @Test
    void formatVisitTimeTest() {
        Visit testVisit =new Visit("Astrid Larsson", "540815-4382",
                LocalDateTime.of(2025,10,17,14,27, 10, 100));
        String expectedTime = "2025-10-17 14:27";
        assertEquals(expectedTime, visit.formatVisitTime(testVisit.getVisitTime()));
        assertNotEquals(testVisit.getVisitTime().toString(), visit.formatVisitTime(testVisit.getVisitTime()));
        assertNotEquals("17-10-2025 14:27", visit.formatVisitTime(testVisit.getVisitTime()));
    }

    @Test
    void addVisitToVisitsArrayListTest(){
        visit.clearVisitsArrayList();
        memberList.get(1).memberVisitsGym();
        memberList.get(6).memberVisitsGym();
        memberList.get(1).memberVisitsGym();
        ArrayList<Visit> testVisits = visit.getVisits();

        assertEquals(3, testVisits.size());
        assertNotEquals(0, testVisits.size());
        assertEquals("Astrid Larsson",testVisits.getLast().getMemberName());
        assertNotEquals("Ivan",testVisits.getLast().getMemberName());
    }



}