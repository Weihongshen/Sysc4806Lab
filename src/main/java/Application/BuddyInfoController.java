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

    @PostMapping("/addBuddy")
    public BuddyInfo addBuddy(@RequestParam(value = "name") String name,
                              @RequestParam(value = "address") String phoneNumber,
                              @RequestParam(value = "phoneNum") String address,
                              @RequestParam(value = "bookId") int bookId) {

        BuddyInfo newBuddy = null;
        Optional<AddressBook> checkBook = bookRep.findById(bookId);
        if (checkBook.isPresent()){
            AddressBook book = checkBook.get();
            System.out.println(book.toString());

            newBuddy = new BuddyInfo(name, phoneNumber, address);
            int newId = Math.toIntExact(Counter.incrementAndGet());
            System.out.println(newId);

            book.addBuddy(newBuddy);

            bookRep.save(book);
        } else {
            System.out.println(String.format("No AddressBook with id: %d", bookId));

            for (AddressBook tempBook : bookRep.findAll()){
                System.out.println(tempBook.toString());
            }
        }

        return newBuddy;
    }

    @PostMapping("/removeBuddy")
    public Boolean removeBuddy(@RequestParam(value = "buddyId") int buddyId,
                               @RequestParam(value = "bookId") int bookId) {
        Boolean retVal = false;

        BuddyInfo newBuddy = null;

        Optional<AddressBook> checkBook = bookRep.findById(bookId);
        if (checkBook.isPresent()){
            AddressBook book = checkBook.get();

            book.removeById(buddyId);

            bookRep.save(book);
            repository.deleteById(buddyId);

            retVal = true;
        } else {
            System.out.println(String.format("No AddressBook with id: %d", bookId));

            for (AddressBook tempBook : bookRep.findAll()){
                System.out.println(tempBook.toString());
            }
        }

        return retVal;
    }

}
