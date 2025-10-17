import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Visit {

    private String memberName;
    private String memberPersonalNumber;
    private LocalDateTime visitTime;

    public Visit() {
    }

    public Visit(String memberName, String memberPersonalNumber, LocalDateTime visitTime) {
        this.memberName = memberName;
        this.memberPersonalNumber = memberPersonalNumber;
        this.visitTime = visitTime;
    }

    public String formatVisitTime(LocalDateTime visitTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        return visitTime.format(formatter);
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMemberPersonalNumber() {
        return memberPersonalNumber;
    }

    public void setMemberPersonalNumber(String memberPersonalNumber) {
        this.memberPersonalNumber = memberPersonalNumber;
    }

    public LocalDateTime getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(LocalDateTime visitTime) {
        this.visitTime = visitTime;
    }
}