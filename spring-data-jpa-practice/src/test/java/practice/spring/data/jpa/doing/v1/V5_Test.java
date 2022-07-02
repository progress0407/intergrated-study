package practice.spring.data.jpa.doing.v1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static java.lang.System.out;

@SpringBootTest
class V5_Test {

    @Autowired
    private ItemRepository itemRepository;

    @DisplayName("아이템 찾기 JPQL INTERFACE")
    @Test
    void 아이템_찾기_JPQL_INTERFACE() {

        Album album = new Album("JYP Entertainment", 25_000L, 50_000L, "JYP", "foo");
        Book book = new Book("해리포터", 15_000L, 30_000L, "joen roling", "abcd-1234-5678");
        Movie movie = new Movie("인셉션", 40_000L, 80_000L, "cristoper nolan", "liam nilson");

        itemRepository.save(album);
        itemRepository.save(book);
        itemRepository.save(movie);

        out.println("-------------- CLOSED PROJECTION --------------");
        CLOSED_PROJECTION(); // ITEM ONLY ONE

        out.println("-------------- OPEN PROJECTION --------------");
        OPEN_PROJECTION(); // ALL JOIN
    }

    private void CLOSED_PROJECTION() {
        List<ItemView> findItemViews = itemRepository.findItemsBy();

        for (ItemView findItemView : findItemViews) {
            out.println("-------------------------------------------------------");
//            out.println("findItemView = " + findItemView);
            out.println("findItemView.getId() = " + findItemView.getId());
            out.println("findItemView.getName() = " + findItemView.getName());
            out.println("findItemView.getPrice() = " + findItemView.getPrice());
            out.println("findItemView.getStockQuantity() = " + findItemView.getStockQuantity());
        }
    }

    private void OPEN_PROJECTION() {
        List<ItemView2> itemViews = itemRepository.findItems2By();

        for (ItemView2 itemView : itemViews) {
            out.println("-------------------------------------------------------");
            out.println("itemView.getId() = " + itemView.getId());
            out.println("itemView.getName() = " + itemView.getName());
            out.println("itemView.getPriceAndQuantity() = " + itemView.getPriceAndQuantity());
        }
    }
}