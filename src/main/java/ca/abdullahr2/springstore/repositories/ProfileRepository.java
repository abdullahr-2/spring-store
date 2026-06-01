package ca.abdullahr2.springstore.repositories;

import ca.abdullahr2.springstore.entities.Profile;
import org.springframework.data.repository.CrudRepository;

public interface ProfileRepository extends CrudRepository<Profile, Long> {
}