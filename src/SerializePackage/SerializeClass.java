package SerializePackage;

import Visit.Visit;

import java.io.*;
import java.nio.file.NoSuchFileException;
import java.util.ArrayList;

public class SerializeClass {

    Visit visit = new Visit();
    String fileName = "VisitArray.ser";
    public boolean isTestMode = false;

    public void serializeVisitArrayList() {
        if(isTestMode){
            fileName = "VisitArrayListTest.ser";
        }
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            ArrayList<Visit> visits = visit.getVisits();
            out.writeInt(visits.size());
            for (Visit visit : visits) {
                out.writeObject(visit);
            }
            out.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void deSerializeToVisitArrayList() {
        if(isTestMode){
            fileName = "VisitArrayListTest.ser";
        }
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
            int count = in.readInt();
            for (int i = 0; i < count; i++) {
                Visit visit = (Visit) in.readObject();
                visit.addVisitToVisitsArrayList();
            }
        } catch (FileNotFoundException e) {
            IO.println("File Not Found yet");
            e.printStackTrace();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
