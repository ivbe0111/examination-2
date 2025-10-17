import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;

public class FileOperations {

    public boolean isTestMode = false;

    public FileOperations(){}

    public ArrayList<Member> readFromFileAddToMemberArrayListTest(Path readFromFilePath) throws FileNotFoundException {
        ArrayList<Member> memberList = new ArrayList<Member>();
        try(BufferedReader br = new BufferedReader(new FileReader(readFromFilePath.toString()))) {
            String line;
            boolean firstLine = true;
            while((line = br.readLine()) != null){
                if(firstLine){
                    firstLine = false;
                    continue;
                }
                memberList.add(new Member(line));
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
        return memberList;
    }

    public void writeToFile(Path writeToFilePath){

    }
}
