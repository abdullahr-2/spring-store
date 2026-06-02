package ca.abdullahr2.springstore.repositories;

import ca.abdullahr2.springstore.entities.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Byte> {
}