import java.time.LocalDate;
import java.util.ArrayList;

public class Member {

    private String name;
    private String address;
    private String email;
    private String personalNumber;
    private LocalDate joinDate;
    private LocalDate latestPayment;
    private MemberType memberType;
    private int numberOfVisits;

    Visit visit = new Visit();
    ArrayList<Member> memberList = new ArrayList<>();
    FileOperations fileOperations = new FileOperations();

    public Member() {
    }

    public Member(String name, String address,
                  String email, String personalNumber,
                  LocalDate joinDate, LocalDate latestPayment, MemberType memberType) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.personalNumber = personalNumber;
        this.joinDate = joinDate;
        this.latestPayment = latestPayment;
        this.memberType = memberType;
        this.numberOfVisits = 0;
    }



    public String getSubscriptionStatus(Member member) {
        LocalDate expirationDateForSubscription = LocalDate.now().minusYears(1);
        if (member == null) {
            return Subscriber.NONEXISTING.getDescription();
        } else if (member.getLatestPayment().isBefore(expirationDateForSubscription)) {
            return Subscriber.EXPIRED.getDescription();
        } else {
            return Subscriber.ACTIVE.getDescription();
        }
    }


    public Member findMemberByName(String name) {
        for (Member member : memberList) {
            if (member.getName().equals(name)) {
                return member;
            }
        }
        return null;
    }

    public Member findMemberByPersonalNumber(String personalNumber) {
        IO.println(personalNumber);
        for (Member member : memberList) {
            if (member.getPersonalNumber().equals(personalNumber)) {
                return member;
            }
        }
        return null;
    }

    public ArrayList<Member> createMemberArrayListFromFile(ArrayList<String> memberListUnfiltered) {
        for (String member : memberListUnfiltered) {
            memberList.add(new Member(fileOperations.getNameFromStringArrayList(member),
                    fileOperations.getAdressFromStringArrayList(member),
                    fileOperations.getEmailFromStringArrayList(member),
                    fileOperations.getPersonalnumberFromStringArrayList(member),
                    fileOperations.getJoinDateFromStringArrayList(member),
                    fileOperations.getLastPaymentFromStringArrayList(member),
                    fileOperations.getMemberTypeFromStringArrayList(member)));
        }
        return memberList;
    }

    public void addVisit(){
        this.numberOfVisits++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public ArrayList<Member> getMemberList() {
        return memberList;
    }

    public void setMemberList(ArrayList<Member> memberList) {
        this.memberList = memberList;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPersonalNumber() {
        return personalNumber;
    }

    public int getNumberOfVisits() {
        return numberOfVisits;
    }

    public void setNumberOfVisits(int numberOfVisits) {
        this.numberOfVisits = numberOfVisits;
    }

    public void setPersonalNumber(String personalNumber) {
        this.personalNumber = personalNumber;
    }

    public LocalDate getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(LocalDate joinDate) {
        this.joinDate = joinDate;
    }

    public LocalDate getLatestPayment() {
        return latestPayment;
    }

    public void setLatestPayment(LocalDate latestPayment) {
        this.latestPayment = latestPayment;
    }

    public MemberType getMemberType() {
        return memberType;
    }

    public void setMemberType(MemberType memberType) {
        this.memberType = memberType;
    }

    public Member(String name) {
        this.name = name;
    }
}
