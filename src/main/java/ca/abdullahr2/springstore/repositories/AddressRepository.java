package ca.abdullahr2.springstore.repositories;

import ca.abdullahr2.springstore.entities.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Long> {
}
