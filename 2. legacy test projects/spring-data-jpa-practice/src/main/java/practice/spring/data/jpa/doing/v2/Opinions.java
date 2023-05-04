package practice.spring.data.jpa.doing.v2;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Embeddable;
import javax.persistence.OneToMany;
import lombok.Data;

//@Embeddable
@Data
class Opinions {

    @OneToMany(mappedBy = "discussion")
    List<Opinion> opinions = new ArrayList<>();
}
