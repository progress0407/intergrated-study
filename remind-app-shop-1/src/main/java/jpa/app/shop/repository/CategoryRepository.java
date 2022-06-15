package jpa.app.shop.repository;

import java.util.List;
import javax.persistence.EntityManager;
import jpa.app.shop.domain.item.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CategoryRepository {

    private final EntityManager em;

    public Long save(Item item) {
        em.persist(item);
        return item.getId();
    }

    public Item findOne(Long id) {
        return em.find(Item.class, id);
    }

    public List<Item> findAll() {
        return em.createQuery("select i from Item i", Item.class)
                .getResultList();
    }

    public List<Item> findByName(String name) {
        return em.createQuery("select i from Item i where i.name = :name", Item.class)
                .setParameter("name", name)
                .getResultList();
    }

    public void clear() {
        em.createQuery("delete from Item i")
                .executeUpdate();
    }
}
