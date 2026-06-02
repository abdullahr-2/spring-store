package ca.abdullahr2.springstore.repositories;

import ca.abdullahr2.springstore.entities.Category;
import ca.abdullahr2.springstore.entities.Product;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {
    // Find products between prices and sort by name
    @Query("select p from Product p where p.price between :min and :max order by p.name")
    List<Product> findProducts(@Param("min") BigDecimal min, @Param("max") BigDecimal max);

    // Cound products between prices
    @Query("select count(p) from Product p where p.price between :priceAfter and :priceBefore")
    long countProducts(@Param("priceAfter") BigDecimal priceAfter, @Param("priceBefore") BigDecimal priceBefore);

    @Modifying
    @Query("update Product p set p.price = :newPrice where p.category.id = :categoryId")
    void updatePriceByCategory(@Param("newPrice") BigDecimal newPrice, @Param("categoryId") Byte categoryId);
}