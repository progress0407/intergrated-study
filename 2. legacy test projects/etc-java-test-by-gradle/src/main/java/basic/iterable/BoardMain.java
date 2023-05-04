package basic.iterable;

import static java.lang.System.out;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class BoardMain {

    public static void main(final String... args) {
        List<Post> posts = new ArrayList<>();
        posts.add(new Post(1, "Alpha", LocalDate.of(2022, 1, 1)));
        posts.add(new Post(2, "Alpha", LocalDate.of(2021, 1, 1)));
        posts.add(new Post(3, "Alpha", LocalDate.of(2020, 1, 1)));
        posts.add(new Post(4, "Alpha", LocalDate.of(2019, 1, 1)));

        Board board = new Board(posts);

        PostIterable postIterable = board.getPostIterable();

        for (Post post : postIterable) {
            out.println("post = " + post);
        }

        out.println(posts);
    }
}
