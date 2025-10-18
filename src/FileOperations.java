import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class FileOperations {

    public boolean isTestMode = false;

    public FileOperations(){}

    public ArrayList<String> readFromFileAddToStringArrayListTest(Path readFromFilePath) throws FileNotFoundException {
        ArrayList<String> memberListUnfiltered = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(readFromFilePath.toString()))) {
            String line;
            boolean firstLine = true;
            while((line = br.readLine()) != null){
                if(firstLine){
                    firstLine = false;
                    continue;
                }
                memberListUnfiltered.add(line.trim());
            }
        } catch (FileNotFoundException e) {
            if(isTestMode){
                throw new FileNotFoundException();
            } else{
                e.printStackTrace();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return memberListUnfiltered;
    }

    public String getNameFromStringArrayList(String line){
        return line.substring(0,line.indexOf(";"));
    }
    public String getAdressFromStringArrayList(String line){
        Scanner sc = new Scanner(line);
        sc.useDelimiter(";");
        sc.next(); //Skips name
        return sc.next();
    }
    public String getEmailFromStringArrayList(String line){
        Scanner sc = new Scanner(line);
        sc.useDelimiter(";");
        sc.next(); //Skips name
        sc.next(); //Skips adress
        return sc.next();
    }
    public String getPersonalnumberFromStringArrayList(String line){
        Scanner sc = new Scanner(line);
        sc.useDelimiter(";");
        //Skips name, adress & email
        for(int i = 0; i < 3; i++){
            sc.next();
        }
        return sc.next();
    }
    public LocalDate getJoinDateFromStringArrayList(String line){
        Scanner sc = new Scanner(line);
        sc.useDelimiter(";");
        //Skips name, adress, email, personaNumber
        for(int i = 0; i < 4; i++){
            sc.next();
        }
         return LocalDate.parse(sc.next());
    }
    public LocalDate getLastPaymentFromStringArrayList(String line){
        Scanner sc = new Scanner(line);
        sc.useDelimiter(";");
        //Skips name, adress, email, personaNumber, joindate
        for(int i = 0; i < 5; i++){
            sc.next();
        }
        return LocalDate.parse(sc.next());
    }
    public MemberType getMemberTypeFromStringArrayList(String line) {
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

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(writeToFilePath.toString()))) {
            for(Visit visit : visitList){
                bw.write(visit.toString());
                bw.newLine();
            }
        } catch (FileNotFoundException e) {
            if(isTestMode){
                throw new FileNotFoundException();
            }else{
                e.printStackTrace();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
