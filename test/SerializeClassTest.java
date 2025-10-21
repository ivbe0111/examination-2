import FileOperationsPackage.FileOperations;
import MemberPackage.Member;
import SerializePackage.SerializeClass;
import Visit.Visit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SerializeClassTest {
    Visit visit = new Visit();
    Member member = new Member();
    Path readFromFilePath = Paths.get("src/Textfiles/gym_medlemmar.txt");
    ArrayList<Member> memberList;
    FileOperations fileOperations = new FileOperations();
    SerializeClass serialize = new SerializeClass();

    @BeforeEach
    void setUp() throws FileNotFoundException {
        member.clearMemberList();
        fileOperations.readFromFileAddToMemberList(readFromFilePath);
        memberList = member.getMemberList();
        serialize.isTestMode = true;
    }

    @Test
    void serializeAndDeserializeTest(){
        visit.clearVisitsArrayList();
        memberList.get(1).memberVisitsGym();
        memberList.get(6).memberVisitsGym();
        memberList.get(1).memberVisitsGym();

        //Serialiserar
        serialize.serializeVisitArrayList();

        //Rensar arrayListen
        visit.clearVisitsArrayList();
        ArrayList<Visit> visitsArrayList = visit.getVisits();
        assertEquals(0, visitsArrayList.size());

        //Desialiserar och lägger till i ArrayListen igen
        serialize.deSerializeToVisitArrayList();
        visitsArrayList = visit.getVisits();

        assertEquals(3, visitsArrayList.size());
        assertNotEquals(0, visitsArrayList.size());
        assertEquals(visitsArrayList.getFirst().getMemberName(), memberList.get(1).getName());
        assertEquals(visitsArrayList.getLast().getMemberPersonalNumber(), memberList.get(1).getPersonalNumber());

    }

}