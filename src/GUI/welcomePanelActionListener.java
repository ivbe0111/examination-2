package GUI;
import MemberPackage.Member;
import MemberPackage.Subscriber;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class welcomePanelActionListener implements ActionListener {
    private final JTextField inputFieldForNameOrPersonalNumber;

    private final JLabel memberStatus;
    Member member = new Member();
    private ArrayList<Member> memberList = member.getMemberList();
    public welcomePanelActionListener(
                                      JTextField inputFieldForNameOrPersonalNumber,
                                      JLabel memberStatus) {
        this.inputFieldForNameOrPersonalNumber = inputFieldForNameOrPersonalNumber;
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
                    memberStatus.setForeground(Color.BLACK);
                    memberStatus.setText(member.getName() + " is an active " + member.getMemberType().getDescription() + " member");
                    memberStatus.setVisible(true);
                    inputFieldForNameOrPersonalNumber.setText("");
                    member.memberVisitsGym();
                    return;
                } else if (memberStatusEnum.equals(Subscriber.EXPIRED)) {
                    memberStatus.setForeground(Color.RED);
                    memberStatus.setText(Subscriber.EXPIRED.getDescription() + "for " + member.getName());
                    memberStatus.setVisible(true);
                    return;
                }
            } else {
                memberStatus.setText("Could not find member with such name or personalnumber.");
                memberStatus.setForeground(Color.RED);
                memberStatus.setVisible(true);
            }
        }

    }
}
