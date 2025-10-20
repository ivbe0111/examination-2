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
    JLabel memberStatus = new JLabel();

    FileOperations fileOperations = new FileOperations();

    public GUI() throws FileNotFoundException {
        Path path = Paths.get("src/Textfiles/gym_medlemmar.txt");
        fileOperations.readFromFileAddToMemberList(path);

        //Create Frame
        setSize(500, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        addWindowListener(new WindowAdapterClass());


        //Create textPanel
        add(textPanel);
        textPanel.setLayout(new GridLayout(5, 1));
        textPanel.setVisible(true);
        textPanel.setPreferredSize(new Dimension(500, 200));
        textPanel.add(welcomeLabel);
        welcomeLabel.setHorizontalAlignment(JLabel.CENTER);
        textPanel.add(welcomeLabel2);
        welcomeLabel2.setHorizontalAlignment(JLabel.CENTER);
        textPanel.add(inputFieldForNameOrPersonalNumber);
        textPanel.add(memberStatus);
        memberStatus.setHorizontalAlignment(JLabel.CENTER);
        memberStatus.setVisible(false);

        pack();

        welcomePanelActionListener welcomePanelActionListener = new welcomePanelActionListener(inputFieldForNameOrPersonalNumber, memberStatus);
        inputFieldForNameOrPersonalNumber.addActionListener(welcomePanelActionListener);
    }

}
