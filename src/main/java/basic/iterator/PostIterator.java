package basic.iterator;

import java.util.Iterator;
import java.util.List;
import lombok.Getter;

@Getter
class PostIterator implements Iterator<Post> {

    private final Iterator<Post> postIterator;

    public PostIterator(List<Post> posts) {
//        posts.sort(Comparator.comparing(Post::getCreateAt)); // 순방향
        posts.sort((p1, p2) -> p2.getCreateAt().compareTo(p1.getCreateAt()));
        this.postIterator = posts.iterator();
    }

    @Override
    public boolean hasNext() {
        return postIterator.hasNext();
    }

    @Override
    public Post next() {
        return postIterator.next();
    }


}
