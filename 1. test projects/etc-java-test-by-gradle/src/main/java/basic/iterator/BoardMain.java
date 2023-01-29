package basic.iterator;

import static java.lang.System.out;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class BoardMain {

    public static void main(final String... args) {
        List<Post> posts = new ArrayList<>();
        posts.add(new Post(1, "Alpha", LocalDate.of(2022, 1, 1)));
        posts.add(new Post(2, "Alpha", LocalDate.of(2021, 1, 1)));
        posts.add(new Post(3, "Alpha", LocalDate.of(2020, 1, 1)));
        posts.add(new Post(4, "Alpha", LocalDate.of(2019, 1, 1)));

        Board board = new Board(posts);
        Iterator<Post> iterator = board.getDefaultIterator();

/*
        while (iterator.hasNext()) {
            out.println(iterator.next());
        }
*/

        iterator.forEachRemaining(out::println);
    }
}
