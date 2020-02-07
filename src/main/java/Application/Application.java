package Application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        System.setProperty("server.port","8081");
        SpringApplicationBuilder b = new SpringApplicationBuilder(Application.class);
        b.headless(false);
        ConfigurableApplicationContext c = b.run(args);
    }

//    @Bean
//    public CommandLineRunner demo(AddressBookRepository bookRep, BuddyInfoRepository repository) {
//        return (args) -> {
//            AddressBook book = new AddressBook();
//            book.addBuddy(new BuddyInfo("A","1","1"));
//            book.addBuddy(new BuddyInfo("B","2","2"));
//            book.addBuddy(new BuddyInfo("C","3","3"));
//            bookRep.save(book);
//
//            log.info("BuddyInfo found with findAll():");
//            log.info("-------------------------------");
//            for(BuddyInfo buddyinfo : repository.findAll()){
//                log.info(buddyinfo.toString());
//            }
//            log.info("");
//
//            BuddyInfo buddyinfo = repository.findById(1L);
//            log.info("BuddyInfo found with findById(1L):");
//            log.info("---------------------------------");
//            log.info(buddyinfo.toString());
//            log.info("");
//
//            log.info("BuddyInfo found with findByName('A'):");
//            log.info("-------------------------------------");
//            for (BuddyInfo A : repository.findByName("A")){
//                log.info(A.toString());
//            }
//            log.info("");
//        };
//    }
}
