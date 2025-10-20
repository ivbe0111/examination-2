package GUI;
import MemberPackage.Member;
import MemberPackage.Subscriber;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class welcomePanelActionListener implements ActionListener {
    private JLabel memberNotFound;
    private JTextField inputFieldForNameOrPersonalNumber;
    private JPanel textPanel;
    private JLabel memberStatus;
    Member member = new Member();
    private ArrayList<Member> memberList = member.getMemberList();

    public welcomePanelActionListener(JLabel memberNotFound,
                                      JTextField inputFieldForNameOrPersonalNumber,
                                      JPanel textPanel,
                                      JLabel memberStatus) {
        this.memberNotFound = memberNotFound;
        this.inputFieldForNameOrPersonalNumber = inputFieldForNameOrPersonalNumber;
        this.textPanel = textPanel;
        this.memberStatus = memberStatus;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String input = inputFieldForNameOrPersonalNumber.getText();
        for (Member member : memberList) {
            if (member.getName().equalsIgnoreCase(input.trim())
                    || member.getPersonalNumber().equalsIgnoreCase(input.trim())) {
                Subscriber memberStatusEnum = member.getSubscriptionStatus(member);
                if (memberStatusEnum.equals(Subscriber.ACTIVE)) {
                    memberNotFound.setVisible(false);
                    memberStatus.setText(member.getName() + " is a " + member.getMemberType().getDescription() + " member");
                    memberStatus.setVisible(true);
                    member.memberVisitsGym();
                    return;
                } else if (memberStatusEnum.equals(Subscriber.EXPIRED)) {
                    memberNotFound.setVisible(false);
                    memberStatus.setText(Subscriber.EXPIRED.getDescription() + "for " + member.getName());
                    memberStatus.setVisible(true);
                    return;
                }
            } else {
                memberStatus.setVisible(false);
                memberNotFound.setVisible(true);
            }
        }

    }
}
