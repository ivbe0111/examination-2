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

    @Override
    public String toString() {
       StringBuilder sb = new StringBuilder();
       sb.append("Visits to the gym\n").append("Name\t\t").append("PersonalNumber\t")
               .append("Visit Time:\n").append(memberName).append("\t\t")
               .append(memberPersonalNumber).append("\t\t")
               .append(formatVisitTime(visitTime)).append("\n");

        return sb.toString();
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

    public void clearVisitsArrayList(){
        this.visits.clear();
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