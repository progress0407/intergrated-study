package jpa.app.shop.domain.item;

import javax.persistence.Entity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Album extends Item {

    String artist;
    String etc;

    public Album(String name, Long stockQuantity, String artist, String etc) {
        super(name, stockQuantity);
        this.artist = artist;
        this.etc = etc;
    }
}
