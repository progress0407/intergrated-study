package basic.iterable;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
class Post {
    private Integer id;
    private String name;
    private LocalDate createAt;
}
