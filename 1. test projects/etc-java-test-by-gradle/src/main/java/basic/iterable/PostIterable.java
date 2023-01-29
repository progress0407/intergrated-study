package basic.iterable;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class PostIterable implements Iterable<Post> {

    private Iterator<Post> postIterator;

    public PostIterable(List<Post> posts) {
        posts.sort((p1, p2) -> p2.getCreateAt().compareTo(p1.getCreateAt()));
        this.postIterator = posts.iterator();
    }

    @Override
    public Iterator<Post> iterator() {
        return postIterator;
    }
}
