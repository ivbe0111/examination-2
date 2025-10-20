package FileOperationsPackage;

import MemberPackage.Member;
import MemberPackage.MemberType;
import Visit.Visit;

import java.io.*;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class FileOperations {

    public boolean isTestMode = false;
    Member member = new Member();

    public FileOperations() {
    }

    public void readFromFileAddToMemberList(Path readFromFilePath) throws FileNotFoundException {
        try (BufferedReader br = new BufferedReader(new FileReader(readFromFilePath.toString()))) {
            String line;
            boolean firstLine = true;
            while ((line = br.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue;
                }
                new Member(getNameFromReadLine(line),
                        getAdressFromReadLine(line),
                        getEmailFromReadLine(line),
                        getPersonalnumberFromReadLine(line),
                        getJoinDateFromReadLine(line),
                        getLastPaymentFromReadLine(line),
                        getMemberTypeFromReadLine(line));
            }
        } catch (FileNotFoundException e) {
            if (isTestMode) {
                throw new FileNotFoundException("File Not Found exception");
            } else {
                e.printStackTrace();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getNameFromReadLine(String line) {
        return line.substring(0, line.indexOf(";"));
    }

    public String getAdressFromReadLine(String line) {
        Scanner sc = new Scanner(line);
        sc.useDelimiter(";");
        sc.next(); //Skips name
        return sc.next();
    }

    public String getEmailFromReadLine(String line) {
        Scanner sc = new Scanner(line);
        sc.useDelimiter(";");
        sc.next(); //Skips name
        sc.next(); //Skips adress
        return sc.next();
    }

    public String getPersonalnumberFromReadLine(String line) {
        Scanner sc = new Scanner(line);
        sc.useDelimiter(";");
        //Skips name, adress & email
        for (int i = 0; i < 3; i++) {
            sc.next();
        }
        return sc.next();
    }

    public LocalDate getJoinDateFromReadLine(String line) {
        Scanner sc = new Scanner(line);
        sc.useDelimiter(";");
        //Skips name, adress, email, personaNumber
        for (int i = 0; i < 4; i++) {
            sc.next();
        }
        return LocalDate.parse(sc.next());
    }

    public LocalDate getLastPaymentFromReadLine(String line) {
        Scanner sc = new Scanner(line);
        sc.useDelimiter(";");
        //Skips name, adress, email, personaNumber, joindate
        for (int i = 0; i < 5; i++) {
            sc.next();
        }
        return LocalDate.parse(sc.next());
    }

    public MemberType getMemberTypeFromReadLine(String line) {
        Scanner sc = new Scanner(line);
        sc.useDelimiter(";");
        //Skips name, adress, email, personaNumber, joindate
        for (int i = 0; i < 6; i++) {
            sc.next();
        }
        String memberType = sc.next();
        for (MemberType mType : MemberType.values()) {
            if (mType.getDescription().equals(memberType)) {
                return mType;
            }
        }
        return null;
    }

    public void writeToFile(Path writeToFilePath) throws FileNotFoundException {
        Visit visits = new Visit();
        ArrayList<Visit> visitList = visits.getVisits();

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(writeToFilePath.toString()))) {

            bw.write("Name\t\t\t\tPersonalNumber\tDate Visited\n");
            for (Visit visit : visitList) {
                bw.write(visit.toString());
                bw.newLine();
            }
            bw.newLine();
            bw.write(member.printTotalVisitsMember());

        } catch (FileNotFoundException e) {
            if (isTestMode) {
                throw new FileNotFoundException();
            } else {
                e.printStackTrace();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
