import Application.AddressBook;
import Application.BuddyInfo;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.*;

import java.util.List;

import static org.junit.Assert.*;

public class AddressBookTest {

    AddressBook book;

    @Before
    public void setUp() throws Exception {
        book = new AddressBook();
    }

    @org.junit.Test
    public void addBuddy() {
        BuddyInfo buddy = new BuddyInfo("Weihong Shen", "Carleton", "613");
        book.addBuddy(buddy);
        assertEquals(1,book.getSize());
    }

    @org.junit.Test
    public void removeBuddy() {
        BuddyInfo buddy = new BuddyInfo("Weihong Shen", "Carleton", "613");
        book.addBuddy(buddy);
        assertEquals(1,book.getSize());
        book.removeBuddy(0);
        assertEquals(0,book.getSize());

    }

    @Test
    public void testJPA() {
        AddressBook book = new AddressBook();
        BuddyInfo buddy = new BuddyInfo("Weihong Shen","Carleton","613");
        BuddyInfo bud2 = new BuddyInfo("Weihong","Cal","123");
        buddy.setId(1);
        bud2.setId(2);
        book.addBuddy(buddy);
        book.addBuddy(bud2);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-test");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();

        tx.begin();
        em.persist(book);

        tx.commit();

        Query q = em.createQuery("SELECT p FROM BuddyInfo p");

        @SuppressWarnings("unchecked")
        List<BuddyInfo> results = q.getResultList();

        System.out.println("List of products\n----------------");



        for (BuddyInfo p : results) {
            System.out.println(p.getName() + " (id=" + p.getId() + ")");
        }


        em.close();
        emf.close();
    }


}