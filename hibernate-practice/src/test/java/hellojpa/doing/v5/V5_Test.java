package hellojpa.doing.v5;

import hellojpa.doing.GlobalTestConfig;
import lombok.Data;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.persistence.*;

import java.util.List;

import static java.lang.System.out;

public class V5_Test extends GlobalTestConfig {

    @DisplayName("item save")
    @Test
    void cvxdsaf_() {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Album album = new Album("JYP Entertainment", 25_000L, 50_000L, "JYP", "foo");
        Book book = new Book("해리포터", 15_000L, 30_000L, "joen roling", "abcd-1234-5678");
        Movie movie = new Movie("인셉션", 40_000L, 80_000L, "cristoper nolan", "liam nilson");

        em.persist(album);
        em.persist(book);
        em.persist(movie);

        em.flush();
        em.clear();

//        앨범_찾기(album);

//        아이템_찾기_JPQL_Entity(); // ALL JOIN : ITEM + ALBUM + MOVIE + BOOK

//        앨범_찾기_JPQL();

//        아이템_찾기_JPQL_DTO(); // ONLY ONE

        // 순수 Hibernate로는 동작할 수 없는 것 같다
//        아이템_찾기_JPQL_INTERFACE(); // ONLY ONE
    }

    private void 아이템_찾기_JPQL_INTERFACE() {
        String sql = "select new hellojpa.doing.v5.ItemView(i.id, i.name, i.price, i.stockQuantity) from Item i";

        List<ItemView> findItemViews = em.createQuery(sql, ItemView.class)
                .getResultList();

        for (ItemView findItemView : findItemViews) {
            out.println("findItemView = " + findItemView);
        }
    }

    /**
     * inner static class 도 가져올 수 있다 !
     */
    private void 아이템_찾기_JPQL_DTO() {

        String sql = "select new hellojpa.doing.v5.V5_Test$ItemDto(i.id, i.name, i.price, i.stockQuantity) from Item i";

        List<ItemDto> findItemDtos = em.createQuery(sql, ItemDto.class).getResultList();

        for (ItemDto findItemDto : findItemDtos) {
            out.println("findItemDto = " + findItemDto);
        }
    }

    @Data
    private static class ItemDto {
        private final Long id;
        private final String name;
        private final long price;
        private final long stockQuantity;
    }

    private void 앨범_찾기_JPQL() {
        List<Album> findAlbums = em.createQuery("select a from Album a", Album.class)
                .getResultList();
        for (Album findAlbum : findAlbums) {
            out.println("findAlbum = " + findAlbum);
        }
    }

    private void 아이템_찾기_JPQL_Entity() {
        List<Item> findItems = em.createQuery("select i from Item i", Item.class)
                .getResultList();
        for (Item findItem : findItems) {
            out.println("findItem = " + findItem);
        }
    }

    private void 앨범_찾기(Album album) {
        Album findAlbum = em.find(Album.class, album.getId());
    }
}
