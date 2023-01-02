package hellojpa.doing.v5;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

//@Entity
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Album extends Item {

    String artist;
    String etc;

    public Album(String name, long price, long stockQuantity, String artist, String etc) {
        super(name, price, stockQuantity);
        this.artist = artist;
        this.etc = etc;
    }
}
