package basic.iterator;

import java.util.Iterator;
import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
class Board {

    private final List<Post> posts;

    public Iterator<Post> getDefaultIterator() {
        PostIterator postIterator = new PostIterator(posts);
        return postIterator.getPostIterator();
    }
}
