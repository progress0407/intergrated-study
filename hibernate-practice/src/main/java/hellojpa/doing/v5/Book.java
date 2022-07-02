package hellojpa.doing.v5;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

//@Entity
@Data
@NoArgsConstructor
class Book extends Item {

    private String author;
    private String isbn;

    public Book(String name, long count, long stockQuantity, String author, String isbn) {
        super(name, count, stockQuantity);
        this.author = author;
        this.isbn = isbn;
    }
}

