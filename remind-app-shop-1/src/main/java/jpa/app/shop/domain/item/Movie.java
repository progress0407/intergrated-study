package jpa.app.shop.domain.item;

import javax.persistence.Entity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Movie extends Item {

    private String director;
    private String actor;

    public Movie(String name, Long stockQuantity, String director, String actor) {
        super(name, stockQuantity);
        this.director = director;
        this.actor = actor;
    }
}
