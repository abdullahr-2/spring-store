package ca.abdullahr2.springstore.repositories;

import ca.abdullahr2.springstore.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
