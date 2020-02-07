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

    @PostMapping("/addAddressbook")
    public @ResponseBody
    AddressBook addAddressBook() {
        AddressBook newBook = new AddressBook();
        bookRep.save(newBook);

        return newBook;
    }

}
