package ca.abdullahr2.springstore.repositories;

import ca.abdullahr2.springstore.entities.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}