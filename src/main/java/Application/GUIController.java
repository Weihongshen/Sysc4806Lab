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

    @GetMapping("/addressBook")
    public String getAddressBook(@RequestParam("id") Integer id, Model model) {
        Optional<AddressBook> addressBook = this.bookRep.findById(id);
        model.addAttribute("addressBook", addressBook);
        return "addressBook";
    }
}