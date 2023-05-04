package practice.spring.data.jpa.doing.v1;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

//@Entity
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Movie extends Item {

    private String director;
    private String actor;

    public Movie(String name, long count, long stockQuantity, String director, String actor) {
        super(name, count, stockQuantity);
        this.director = director;
        this.actor = actor;
    }
}
