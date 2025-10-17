import java.time.LocalDateTime;

public class Visit {

    private String name;
    private String personalNumber;
    private LocalDateTime visitTime;

    public Visit(){}

    public Visit(String name, String personalNumber, LocalDateTime visitTime) {
        this.name = name;
        this.personalNumber = personalNumber;
        this.visitTime = LocalDateTime.now();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPersonalNumber() {
        return personalNumber;
    }

    public void setPersonalNumber(String personalNumber) {
        this.personalNumber = personalNumber;
    }

    public LocalDateTime getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(LocalDateTime visitTime) {
        this.visitTime = visitTime;
    }
}
