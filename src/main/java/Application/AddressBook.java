package Application;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Entity
public class AddressBook {

    @OneToMany(mappedBy = "book", cascade = CascadeType.PERSIST)
    private List<BuddyInfo> buddyinfo;
    @Id
    @GeneratedValue
    private Integer id;


//    public static void main(String[] args) {
//        // TODO Auto-generated method stub
//        BuddyInfo buddy = new BuddyInfo("Weihong Shen", "Carleton", "613");
//        BuddyInfo bud2 =  new BuddyInfo("123","456","789");
//        AddressBook address = new AddressBook();
//        address.addBuddy(buddy);
//        address.addBuddy(bud2);
//        System.out.println(address.toString());
//    }

    @Autowired
    public AddressBook() {
        this.buddyinfo = new ArrayList<BuddyInfo>();
    }

    public Integer getId(){
        return this.id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public int getSize(){
        return this.buddyinfo.size();
    }

    public void addBuddy(BuddyInfo a) {
        if(a != null) {
            this.buddyinfo.add(a);
        }
    }

    public BuddyInfo getBuddy(int i){
        BuddyInfo toRet = null;

        if (i < buddyinfo.size()) {
            toRet = buddyinfo.get(i);
        }

        return(toRet);
    }

    public String toString(){
        String result = "" +'\n';
        for(BuddyInfo buddy : this.buddyinfo){
            result += buddy.toString() + '\n';
        }
        return result;
    }

    public BuddyInfo removeBuddy(int index) {
        if(index >=0 && index < this.buddyinfo.size()) {
            return this.buddyinfo.remove(index);
        }
        return null;
    }

    public void removeBBuddy(BuddyInfo b) {
        this.buddyinfo.remove(b.getName());
    }

    public void removeById(int id) {
        int i = 0;
        while (i < buddyinfo.size()){
            if (buddyinfo.get(i).getId().equals(id)) {
                break;
            }
            i += 1;
        }
        this.removeBuddy(i);
    }

}
