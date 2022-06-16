package jpa.app.shop.repository;

import jpa.app.shop.domain.item.Category;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryRepository extends BasicCrudRepository<Category, Long> {
}
