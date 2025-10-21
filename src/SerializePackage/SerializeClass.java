package SerializePackage;

import Visit.Visit;

import java.io.*;
import java.nio.file.NoSuchFileException;
import java.util.ArrayList;

public class SerializeClass {

    Visit visit = new Visit();

    public void serializeVisitArrayList() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("VisitArray.ser"))) {
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
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("VisitArray.ser"))) {
            int count = in.readInt();
            for (int i = 0; i < count; i++) {
                Visit visit = (Visit) in.readObject();
                visit.addVisitToVisitsArrayList();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
