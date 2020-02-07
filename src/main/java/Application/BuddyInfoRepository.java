package Application;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface BuddyInfoRepository extends CrudRepository<BuddyInfo, Long> {

    List<BuddyInfo> findByName(String name);

    List<BuddyInfo> findByPhoneNum(String phoneNum);

    List<BuddyInfo> findByAddress(String address);

    BuddyInfo findById(Integer id);

    void deleteById(Integer id);

}