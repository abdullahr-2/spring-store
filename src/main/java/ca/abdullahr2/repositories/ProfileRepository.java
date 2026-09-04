package ca.abdullahr2.repositories;

import ca.abdullahr2.entities.Profile;
import org.springframework.data.repository.CrudRepository;

public interface ProfileRepository extends CrudRepository<Profile, Long> {
}