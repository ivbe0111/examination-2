package GUI;

import MemberPackage.*;
import FileOperationsPackage.*;
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
    JLabel memberStatus = new JLabel();

    //TODO move this to right spot after
    FileOperations fileOperations = new FileOperations();

    public GUI() throws FileNotFoundException {
        Path path = Paths.get("src/Textfiles/gym_medlemmar.txt");
        fileOperations.readFromFileAddToStringArrayList(path);

        //Create Frame
        setSize(500, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

//        addWindowListener(new WindowAdapterClass());


        //Create textPanel
        add(textPanel);
        textPanel.setLayout(new GridLayout(5, 1));
        textPanel.setVisible(true);
        textPanel.setPreferredSize(new Dimension(500, 200));
        textPanel.add(welcomeLabel);
        textPanel.add(welcomeLabel2);
        textPanel.add(inputFieldForNameOrPersonalNumber);
        textPanel.add(memberNotFound);
        textPanel.add(memberStatus);
        memberNotFound.setForeground(Color.RED);
        memberNotFound.setVisible(false);
        memberStatus.setVisible(false);

        pack();

        welcomePanelActionListener welcomePanelActionListener = new welcomePanelActionListener(memberNotFound, inputFieldForNameOrPersonalNumber, textPanel, memberStatus);
        inputFieldForNameOrPersonalNumber.addActionListener(welcomePanelActionListener);





    }

}
