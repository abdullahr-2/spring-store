package ca.abdullahr2.repositories;

import ca.abdullahr2.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
