package Application;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressBookController {

    @Autowired
    private BuddyInfoRepository repository;
    @Autowired
    private AddressBookRepository bookRep;

    @ResponseBody
    @PostMapping("/addAddressbook")
    public AddressBook addAddressBook() {
        AddressBook newBook = new AddressBook();
        this.bookRep.save(newBook);

        return newBook;
    }

}
