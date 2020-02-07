package ui.button;

import Application.BuddyInfo;

import java.awt.event.ActionEvent;

public class AddNewButtonActionListener extends
        ListTableActionListener {
    public void actionPerformed(ActionEvent e) {
        BuddyInfo bud = new BuddyInfo();
        list.add(bud.toString());
        table.revalidate();
    }
}