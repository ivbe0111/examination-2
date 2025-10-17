import java.time.LocalDate;

public class Member {

    private String name;
    private String address;
    private String email;
    private String personalNumber;
    private LocalDate joinDate;
    private LocalDate latestSubsriptionPayedDate;
    private MemberType memberType;

    public Member(){}

    public Member(String name, String address, String email, String personalNumber, LocalDate joinDate, MemberType memberType) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.personalNumber = personalNumber;
        this.joinDate = joinDate;
        this.latestSubsriptionPayedDate = joinDate;
        this.memberType = memberType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Member(String name){
        this.name = name;
    }
}
