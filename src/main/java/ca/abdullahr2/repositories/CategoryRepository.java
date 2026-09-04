package ca.abdullahr2.repositories;

import ca.abdullahr2.entities.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Byte> {
}