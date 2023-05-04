package jpa.app.shop.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import jpa.app.shop.domain.item.Album;
import jpa.app.shop.domain.item.Book;
import jpa.app.shop.domain.item.Item;
import jpa.app.shop.domain.item.Movie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class ItemRepositoryTest {

    @Autowired
    private ItemRepository itemRepository;

    Album album = new Album("YG Entertainment", 25_000L, 50_000L, "yg", "foo");
    Book book = new Book("해리포터", 15_000L, 30_000L, "joen roling", "abcd-1234-5678");
    Movie movie = new Movie("인셉션", 40_000L, 80_000L, "cristoper nolan", "liam nilson");

    Long savedAlbumId;
    Long savedBookId;
    Long savedMovieId;

    @BeforeEach
    void setUp() {
        itemRepository.clear();

        savedAlbumId = itemRepository.save(album);
        savedBookId = itemRepository.save(book);
        savedMovieId = itemRepository.save(movie);
    }

    @Test
    void findOne() {
        Item findItem = itemRepository.findById(savedAlbumId).get();
        assertThat(findItem).isEqualTo(album);
    }

    @Test
    void findAll() {
        List<Item> find = itemRepository.findAll();
        assertThat(find).containsExactlyInAnyOrder(album, book, movie);
    }

    @Test
    void findByName() {
    }
}