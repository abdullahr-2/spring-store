package ca.abdullahr2.springstore.repositories;

import ca.abdullahr2.springstore.entities.Profile;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProfileRepository extends CrudRepository<Profile, Long> {
    List<Profile> findByLoyaltyPointsGreaterThan(String min);
}