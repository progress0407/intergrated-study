package jpa.app.shop;

import jpa.app.shop.domain.item.Album;
import jpa.app.shop.domain.item.Book;
import jpa.app.shop.domain.item.Movie;
import jpa.app.shop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Component
public class InitData implements ApplicationListener<ContextRefreshedEvent> {

    private final ItemRepository itemRepository;

    private final ModelMapper modelMapper;

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {
        Album album = new Album("JYP Entertainment", 25_000L, 50_000L, "JYP", "foo");
        Book book = new Book("해리포터", 15_000L, 30_000L, "joen roling", "abcd-1234-5678");
        Movie movie = new Movie("인셉션", 40_000L, 80_000L, "cristoper nolan", "liam nilson");

        itemRepository.save(album);
        itemRepository.save(book);
        itemRepository.save(movie);
    }
}
