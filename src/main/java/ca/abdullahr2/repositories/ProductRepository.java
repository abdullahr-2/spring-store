package ca.abdullahr2.repositories;

import ca.abdullahr2.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}