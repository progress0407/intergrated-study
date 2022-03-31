package basic.iterable;

import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
class Board {

    private final List<Post> posts;

    public PostIterable getPostIterable() {
        return new PostIterable(posts);
    }
}
