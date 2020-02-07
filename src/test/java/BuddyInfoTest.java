import Application.BuddyInfo;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.*;

import java.util.List;

import static org.junit.Assert.*;

public class BuddyInfoTest {

    private BuddyInfo buddy;

    @Before
    public void setUp() throws Exception {
        buddy = new BuddyInfo("Weihong Shen", "Carleton", "613");
    }

    @Test
    public void getName() {
        assertEquals("Weihong Shen", buddy.getName());
    }

    @Test
    public void setName() {
        buddy.setName("weihong");
        assertEquals("weihong",buddy.getName());
    }

    @Test
    public void getAddress() {
        assertEquals("Carleton",buddy.getAddress());
    }

    @Test
    public void setAddress() {
        buddy.setAddress("cal");
        assertEquals("cal",buddy.getAddress());
    }

    @Test
    public void getPhoneNum() {
        assertEquals("613",buddy.getPhoneNum());
    }

    @Test
    public void setPhoneNum() {
        buddy.setPhoneNum("123");
        assertEquals("123",buddy.getPhoneNum());
    }

    @Test
    public void testJPA() {
        BuddyInfo buddy = new BuddyInfo();

        buddy.setName("Weihong Shen");
        buddy.setAddress("Carleton");
        buddy.setPhoneNum("613");
        buddy.setId(1);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-test");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        em.persist(buddy);

        tx.commit();

        Query q = em.createQuery("SELECT p FROM BuddyInfo p");

        @SuppressWarnings("unchecked")
        List<BuddyInfo> results = q.getResultList();

        System.out.println(results.get(0).getName()+ " " + results.get(0).getAddress()+ " " + results.get(0).getPhoneNum() + " " + results.get(0).getId());

        em.close();
        emf.close();

        assertEquals("Weihong Shen", results.get(0).getName());
        assertEquals("Carleton", results.get(0).getAddress());
        assertEquals("613", results.get(0).getPhoneNum());

    }

}