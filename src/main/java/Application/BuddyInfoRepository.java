package Application;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface BuddyInfoRepository extends CrudRepository<BuddyInfo, Integer> {

    List<BuddyInfo> findByName(String name);

    List<BuddyInfo> findByPhoneNum(String phoneNum);

    List<BuddyInfo> findByAddress(String address);

    BuddyInfo findById(int id);

    void deleteById(int id);

}