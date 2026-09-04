package ca.abdullahr2.repositories;

import ca.abdullahr2.entities.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Long> {
}