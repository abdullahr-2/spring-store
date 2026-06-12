package ca.abdullahr2.springstore.repositories;

import ca.abdullahr2.springstore.dtos.ProductSummary;
import ca.abdullahr2.springstore.dtos.ProductSummaryDTO;
import ca.abdullahr2.springstore.entities.Category;
import ca.abdullahr2.springstore.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    // Find products between prices and sort by name
    @Procedure("findProductsByPrice")
    List<Product> findProducts(BigDecimal min, BigDecimal max);

    // Cound products between prices
    @Query("select count(p) from Product p where p.price between :priceAfter and :priceBefore")
    long countProducts(@Param("priceAfter") BigDecimal priceAfter, @Param("priceBefore") BigDecimal priceBefore);

    @Modifying
    @Query("update Product p set p.price = :newPrice where p.category.id = :categoryId")
    void updatePriceByCategory(@Param("newPrice") BigDecimal newPrice, @Param("categoryId") Byte categoryId);

    @Query("select new ca.abdullahr2.springstore.dtos.ProductSummaryDTO(p.id, p.name) from Product p where p.category = :category")
    List<ProductSummaryDTO> findByCategory(@Param("category") Category category);
}