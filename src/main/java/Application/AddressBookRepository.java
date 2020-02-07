package Application;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(collectionResourceRel = "book", path = "book")
public interface AddressBookRepository extends PagingAndSortingRepository<AddressBook, Long> {
    AddressBook findById(@Param("id") Integer id);
}