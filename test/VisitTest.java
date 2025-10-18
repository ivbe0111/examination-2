import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class VisitTest {

    Visit visit = new Visit();
    @BeforeEach
    void setUp() {

    }

    @Test
    void formatVisitTimeTest() {
        Visit testVisit = new Visit("Ivan", "1231-2131",LocalDateTime.of
                (2025,10,17,14,27, 10, 100));
        String expectedTime = "2025-10-17 14:27";
        assertEquals(expectedTime, visit.formatVisitTime(testVisit.getVisitTime()));
        assertNotEquals(testVisit.getVisitTime().toString(), visit.formatVisitTime(testVisit.getVisitTime()));
        assertNotEquals("17-10-2025 14:27", visit.formatVisitTime(testVisit.getVisitTime()));
    }


    @Test
    void addVisitToVisitsArrayListTest(){

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
        ArrayList<Visit> testVisits = visit.getVisits();

        assertEquals(3, testVisits.size());
        assertNotEquals(0, testVisits.size());
        assertEquals("Astrid Larsson",testVisits.getLast().getMemberName());
        assertNotEquals("Ivan",testVisits.getLast().getMemberName());

    }

}