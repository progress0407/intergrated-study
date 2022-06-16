package jpa.app.shop.repository;

import static java.lang.System.out;

import java.util.List;
import jpa.app.shop.domain.item.Category;
import jpa.app.shop.domain.item.Item;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ItemRepository itemRepository;

    @DisplayName("category test")
    @Test
    void test_1() {
        List<Item> items = itemRepository.findAll();
        Category category = new Category("category-1", items, null, null);
        categoryRepository.save(category);

        List<Category> categories = categoryRepository.findAll();

        out.println("categories = " + categories);
    }
}
