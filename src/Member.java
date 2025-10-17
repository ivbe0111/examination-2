import java.time.LocalDate;

public class Member {

    private String name;
    private String address;
    private String email;
    private String personalNumber;
    private LocalDate joinDate;
    private LocalDate latestSubsriptionPayedDate;
    private MemberType memberType;

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
