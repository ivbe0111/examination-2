package Visit;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Visit implements Serializable {

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
        addVisitToVisitsArrayList();
    }

    public void addVisitToVisitsArrayList() {
        visits.add(this);
    }

    public String formatVisitTime(LocalDateTime visitTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        return visitTime.format(formatter);
    }

    public int getTotalVisitsPerMember(String memberPersonalNumberInput){
        int totalVisits = 0;
        for(Visit visit : visits){
            if(visit.getMemberPersonalNumber().equals(memberPersonalNumberInput)){
                totalVisits++;
            }
        }
        return totalVisits;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(memberName);
        for (int i = memberName.length(); i < 20; i++) {
            sb.append(" ");
        }
        sb.append(memberPersonalNumber);
        for (int i = memberPersonalNumber.length(); i < 16; i++) {
            sb.append(" ");
        }
        sb.append(formatVisitTime(visitTime));

        return sb.toString();
    }
    public String getMemberPersonalNumber() {
        return memberPersonalNumber;
    }

    public String getMemberName() {
        return memberName;
    }

    public ArrayList<Visit> getVisits() {
        return visits;
    }

    public void clearVisitsArrayList() {
        this.visits.clear();
    }

    public LocalDateTime getVisitTime() {
        return visitTime;
    }
}