import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Visit {

    private String memberName;
    private String memberPersonalNumber;
    private LocalDateTime visitTime;
    private static ArrayList<Visit> visits = new ArrayList<>();


    public Visit() {
    }

    public Visit(String memberName, String memberPersonalNumber, LocalDateTime visitTime) {
        this.memberName = memberName;
        this.memberPersonalNumber = memberPersonalNumber;
        this.visitTime = visitTime;
    }

    public void addVisitToVisitsArrayList(){
        visits.add(this);
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

    public ArrayList<Visit> getVisits() {
        return visits;
    }

    public void setVisits(ArrayList<Visit> visits) {
        this.visits = visits;
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