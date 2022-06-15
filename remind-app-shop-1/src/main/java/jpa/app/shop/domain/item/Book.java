package jpa.app.shop.domain.item;

import javax.persistence.Entity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Book extends Item {

    private String author;
    private String isbn;

    public Book(String name, Long stockQuantity, String author, String isbn) {
        super(name, stockQuantity);
        this.author = author;
        this.isbn = isbn;
    }
}
