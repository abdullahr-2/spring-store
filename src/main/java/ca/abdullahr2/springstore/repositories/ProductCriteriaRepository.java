package ca.abdullahr2.springstore.repositories;

import ca.abdullahr2.springstore.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface ProductCriteriaRepository {
    List<Product> findProductsByCriteria(String name, BigDecimal minPrice, BigDecimal maxPrice);

    List<Product> findProductsByCategory(String category);
}
