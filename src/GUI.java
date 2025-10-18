import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class GUI extends JFrame {

    JPanel textPanel = new JPanel(new GridLayout(4, 1));
    JLabel welcomeLabel = new JLabel("Welcome to the best gym ever.");
    JLabel welcomeLabel2 = new JLabel("Please enter name or personalnumber.");
    JTextField inputFieldForNameOrPersonalNumber = new JTextField(20);
    JLabel memberNotFound = new JLabel("Could not find member with such name or personalnumber.");

    //TODO move this to right spot after
    FileOperations fileOperations = new FileOperations();

    public GUI() throws FileNotFoundException {
        Path path = Paths.get("src/Textfiles/gym_medlemmar.txt");
        fileOperations.readFromFileAddToStringArrayList(path);

        //Create Frame
        setSize(500, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);


        //Create textPanel
        add(textPanel);
        textPanel.setVisible(true);
        textPanel.setPreferredSize(new Dimension(500, 200));
        textPanel.add(welcomeLabel);
        textPanel.add(welcomeLabel2);
        textPanel.add(inputFieldForNameOrPersonalNumber);
        textPanel.add(memberNotFound);
        memberNotFound.setVisible(false);

        pack();

        welcomePanelActionListener welcomePanelActionListener = new welcomePanelActionListener(memberNotFound, inputFieldForNameOrPersonalNumber, textPanel);
        inputFieldForNameOrPersonalNumber.addActionListener(welcomePanelActionListener);
    }

    static void main() throws FileNotFoundException {
        GUI gui = new GUI();
    }
}
