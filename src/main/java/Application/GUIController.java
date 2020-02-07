package Application;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class GUIController {
    @Autowired
    private AddressBookRepository bookRep;

    @GetMapping("AddressBook")
    public String viewAddressBook(@RequestParam(value = "id") int bookId,
                                  Model model) {
        if (bookId == -1) {
            for (AddressBook book : bookRep.findAll()) {
                bookId = book.getId();
            }
        }

        Optional<AddressBook> checkBook = bookRep.findById(bookId);
        if (checkBook.isPresent()){
            model.addAttribute("book", checkBook.get());
        } else {
            System.out.println(String.format("No AddressBook with id: %d", bookId));
        }

        return "AddressBook";
    }
}