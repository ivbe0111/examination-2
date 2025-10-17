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
    ArrayList<String> memberListUnfiltered;
    Member member = new Member();

    @BeforeEach
    void setUp() throws FileNotFoundException {
        memberListUnfiltered = fileOperations.readFromFileAddToStringArrayListTest(readFromFilePath);
    }

    @Test
    void createMemberArrayListFromFileTest() {
        ArrayList<Member> memberList = member.createMemberArrayListFromFile(memberListUnfiltered);
        assertEquals(memberList.size(), memberListUnfiltered.size());
        assertEquals("Backgränd 19, 69618 Sandviken", memberList.getLast().getAddress());
        assertEquals("asta@fakemail.de", memberList.get(1).getEmail());
        assertEquals(MemberType.STANDARD, memberList.get(3).getMemberType());
        assertNotEquals(memberList.size()+1, memberListUnfiltered.size());
        assertNotEquals("Pelle", memberList.getFirst().getName());
    }

    @Test
    void findMemberByNameTest(){
        ArrayList<Member> memberList = member.createMemberArrayListFromFile(memberListUnfiltered);

        assertEquals(memberList.get(0), member.findMemberByName("Fredrik Berggren"));
        assertEquals(memberList.getLast(), member.findMemberByName("Jakob Lundin"));
        assertEquals(memberList.get(5), member.findMemberByName("Eva Johansson"));
        assertNotEquals(memberList.get(5), member.findMemberByName("Eva"));
        assertNotEquals(memberList.getLast(), member.findMemberByName("Lundin"));
        assertNotEquals(memberList.getLast(), member.findMemberByName(""));
    }
    @Test
    void findMemberByPersonalNumberTest(){
        ArrayList<Member> memberList = member.createMemberArrayListFromFile(memberListUnfiltered);

        assertEquals(memberList.get(0), member.findMemberByPersonalNumber("851020-6728"));
        assertEquals(memberList.getLast(), member.findMemberByPersonalNumber("000718-8949"));
        assertEquals(memberList.get(5), member.findMemberByPersonalNumber("940128-7025"));
        assertNotEquals(memberList.get(5), member.findMemberByPersonalNumber("940128-702"));
        assertNotEquals(memberList.getLast(), member.findMemberByPersonalNumber("Lundin"));
        assertNotEquals(memberList.getLast(), member.findMemberByPersonalNumber(""));
    }

}