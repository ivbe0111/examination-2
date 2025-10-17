import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;

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
        return line.substring(0,line.indexOf(";"));
    }


    public void writeToFile(Path writeToFilePath){

    }
}
