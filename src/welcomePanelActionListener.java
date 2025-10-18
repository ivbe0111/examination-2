import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class welcomePanelActionListener implements ActionListener {
    private JLabel memberNotFound;
    private JTextField inputFieldForNameOrPersonalNumber;
    private JPanel textPanel;
    Member member = new Member();
    private ArrayList<Member> memberList = member.getMemberList();

    public welcomePanelActionListener(JLabel memberNotFound, JTextField inputFieldForNameOrPersonalNumber
    , JPanel textPanel) {
        this.memberNotFound = memberNotFound;
        this.inputFieldForNameOrPersonalNumber = inputFieldForNameOrPersonalNumber;
        this.textPanel = textPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String input = inputFieldForNameOrPersonalNumber.getText();
        for(Member member : memberList){
            if(member.getName().equalsIgnoreCase(input.trim())
                    || member.getPersonalNumber().equalsIgnoreCase(input.trim())){
                memberNotFound.setVisible(false);
                textPanel.revalidate();
                textPanel.repaint();
                return;
            }else{
                memberNotFound.setVisible(true);
                textPanel.revalidate();
                textPanel.repaint();
            }
        }

    }
}
