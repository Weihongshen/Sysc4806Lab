package ui;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import Application.AddressBook;
import Application.BuddyInfo;

public class ItemTableModel extends AbstractTableModel{

    AddressBook book = new AddressBook();
    List itemList;

    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    public int getColumnCount() {
        return 1;
    }

    public String getColumnName(int column) {
        return "Address Book 1: Buddy List";
    }

    public void setItemList(List itemList) {
        this.itemList = itemList;
    }

    public int getRowCount() {
        return itemList.size();
    }

    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        itemList.set(rowIndex, value.toString());
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        return itemList.get(rowIndex);
    }
}
