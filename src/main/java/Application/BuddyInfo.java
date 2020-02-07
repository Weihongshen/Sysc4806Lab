package Application;

import Application.AddressBook;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.concurrent.atomic.AtomicLong;

@Entity
public class BuddyInfo {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String address;
    private String phoneNum;


    @ManyToOne
    private AddressBook book;

    public static void main(String[] args) {
        // TODO Auto-generated method stub
    }

    public BuddyInfo(){
        this(null,null,null);
    }

    public BuddyInfo(String name, String address,String phoneNum) {
        super();
        this.name=name;
        this.address=address;
        this.phoneNum = phoneNum;
    }

    public Integer getId(){
        return this.id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public AddressBook getBook(){
        return this.book;
    }

    public String toString(){
        return "Name: " + this.name + " Address: " + this.address + " Phone Number: " + this.phoneNum;
    }
}

