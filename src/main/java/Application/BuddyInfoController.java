package Application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;


@RestController
public class BuddyInfoController {
    @Autowired
    private BuddyInfoRepository repository;
    @Autowired
    private AddressBookRepository bookRep;

    private final AtomicLong Counter = new AtomicLong();

    public BuddyInfoController(AddressBookRepository bookRep, BuddyInfoRepository repository){
        this.bookRep = bookRep;
        this.repository = repository;
    }

    @PostMapping(value = "/addBuddy", produces = "application/json")
    public BuddyInfo addBuddy(@RequestParam(value = "name") String name,
                              @RequestParam(value = "address") String address,
                              @RequestParam(value = "phoneNum") String phoneNum,
                              @RequestParam(value = "bookId") Integer bookId) {

        AddressBook addressBook = this.bookRep.findById(bookId);
        BuddyInfo buddy = new BuddyInfo(name, address,phoneNum);
        this.repository.save(buddy);

        addressBook.addBuddy(buddy);
        this.bookRep.save(addressBook);


        return buddy;
    }


    @ResponseBody
    @PostMapping(value = "/removeBuddy", produces = "application/json")
    public void removeBuddy(@RequestParam(value = "buddyId") Integer buddyId) {
        BuddyInfo buddy = this.repository.findById(buddyId);
        AddressBook addressBook = buddy.getBook();
        addressBook.removeBBuddy(buddy);
        this.repository.deleteById(buddyId);
        this.bookRep.save(addressBook);
    }

}
