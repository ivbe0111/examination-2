import FileOperationsPackage.FileOperations;
import MemberPackage.Member;
import MemberPackage.Subscriber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MemberTest {
    Path readFromFilePath = Paths.get("src/Textfiles/gym_medlemmar.txt");
    FileOperations fileOperations = new FileOperations();
    Member member = new Member();
    ArrayList<Member> memberList;

    @BeforeEach
    void setUp() throws FileNotFoundException {
        member.clearMemberList();
        fileOperations.readFromFileAddToMemberList(readFromFilePath);
        memberList = member.getMemberList();
    }

    @Test
    void memberVisitsGym(){
        memberList.get(1).memberVisitsGym();
        memberList.get(1).memberVisitsGym();
        memberList.get(6).memberVisitsGym();
        assertEquals(2, memberList.get(1).getNumberOfVisits());
        assertEquals(1, memberList.get(6).getNumberOfVisits());
    }

    @Test
    void printTotalVisitsMember(){
        memberList.get(1).memberVisitsGym();
        memberList.get(1).memberVisitsGym();
        memberList.get(6).memberVisitsGym();
        String expected = "Astrid Larsson 540815-4382 Total visits: 2\nHerbert Jansson 060201-4763 Total visits: 1\n";
        assertEquals(expected,member.printTotalVisitsMember());
        assertNotEquals("",member.printTotalVisitsMember());
    }

    @Test
    void getSubscriptionStatusTest(){
        assertEquals(Subscriber.EXPIRED, member.getSubscriptionStatus(memberList.getFirst()));
        assertEquals(Subscriber.ACTIVE, member.getSubscriptionStatus(memberList.get(2)));
        assertEquals(Subscriber.NONEXISTING, member.getSubscriptionStatus(null));
        assertNotEquals(Subscriber.NONEXISTING, member.getSubscriptionStatus(memberList.getFirst()));
        assertNotEquals(Subscriber.NONEXISTING, member.getSubscriptionStatus(memberList.get(3)));
        assertNotEquals(Subscriber.ACTIVE, member.getSubscriptionStatus(memberList.getFirst()));
    }

}