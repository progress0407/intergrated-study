package jpa.app.shop.domain.item;

import javax.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Book extends Item {

    private String author;
    private String isbn;

    public Book(String name, long count, long stockQuantity, String author, String isbn) {
        super(name, count, stockQuantity);
        this.author = author;
        this.isbn = isbn;
    }
}
