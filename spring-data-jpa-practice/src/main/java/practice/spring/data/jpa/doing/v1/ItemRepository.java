package practice.spring.data.jpa.doing.v1;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {

    List<ItemView> findItemsBy();

    List<ItemView2> findItems2By();
}
