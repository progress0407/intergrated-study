package jpa.app.shop;

import jpa.app.shop.domain.item.Album;
import jpa.app.shop.domain.item.Book;
import jpa.app.shop.domain.item.Movie;
import jpa.app.shop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Component
public class InitData implements ApplicationListener<ContextRefreshedEvent> {

    private final ItemRepository itemRepository;

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {
        Album album = new Album("YG Entertainment", 50_000L, "yg", "foo");
        Book book = new Book("해리포터", 30_000L, "joen roling", "abcd-1234-5678");
        Movie movie = new Movie("인셉션", 80_000L, "cristoper nolan", "liam nilson");

        itemRepository.save(album);
        this.itemRepository.save(book);
        this.itemRepository.save(movie);
    }
}
