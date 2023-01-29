package basic.whiteship.java8.generic.version.abstractt;

import static java.lang.System.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class GenericMain {

	public static void main(String[] args) {
		// test1();
		test2();
		// test3();
	}

	private static void test3() {

		Book<Long> book = new Book<>(101L);
		book.setIsbn("101-가-222");

		Book<Long> book2 = new Book<>(102L);
		book.setIsbn("102-나-333");

		Album<Long> album = new Album<Long>(201L);
		album.setArtist("IU");

		BookRepository bookRepository = new BookRepository();
		bookRepository.add(book);
		bookRepository.add(book2);

		AlbumRepository albumRepository = new AlbumRepository();
		albumRepository.add(album);

		out.println("-------------- print findBooks -----------------");
		List<Book<Long>> findBooks = bookRepository.findAll();
		findBooks.forEach(out::println);

		out.println("\n-------------- print findAlbums -----------------");
		List<Album<Long>> findAlbums = albumRepository.findAll();
		findAlbums.forEach(out::println);

	}

	private static void test2() {
		Book<Long> book = new Book<>(101L);
		book.setIsbn("101-가-222");

		Book<Long> book2 = new Book<>(102L);
		book.setIsbn("102-나-333");

		Album<Long> album = new Album<Long>(201L);
		album.setArtist("IU");

		ItemRepository<Item<Long>, Long> itemRepository = new ItemRepository<>();
		itemRepository.add(book);
		itemRepository.add(book2);
		itemRepository.add(album);

		out.println("-------------- print findBooks -----------------");
		List<Book> findBooks = itemRepository.findByClass(Book.class);
		findBooks.forEach(out::println);

		out.println("\n-------------- print findAlbums -----------------");
		List<Album> findAlbums = itemRepository.findByClass(Album.class);
		findAlbums.forEach(out::println);
	}

	private static void test1() {
		Book<Long> book = new Book<>(101L);
		book.setIsbn("101-가-222");

		Book<Long> book2 = new Book<>(102L);
		book.setIsbn("102-나-333");

		ItemRepository<Book<Long>, Long> bookRepository = new ItemRepository<>();
		bookRepository.add(book);
		bookRepository.add(book2);

		List<Book<Long>> findBooks = bookRepository.findAll();

		out.println("findBooks = " + findBooks);
	}

	static class BookRepository extends ItemRepository<Book<Long>, Long> {

	}

	static class AlbumRepository extends ItemRepository<Album<Long>, Long> {

	}


	static class ItemRepository <E extends Item<K>, K> {

		private final List<E> items = new ArrayList<>();

		public K add(E item) {
			items.add(item);
			return item.getId();
		}

		public K remove(E item) {
			items.remove(item);
			return item.getId();
		}

		public E find(E item) {
			return items.stream()
				.filter((E i) -> i.equals(item))
				.findAny()
				.orElseThrow(() -> new RuntimeException("값을 찾을 수 없습니다 " + item));
		}

		public List<E> findAll() {
			return items;
		}

		public <T extends Item<K>> List<T> findByClass(Class<T> clazz) {
			return items.stream()
				.filter((E item) -> item.getClass().equals(clazz))
				.map((E item) -> (T) item)
				.collect(Collectors.toList());
		}
	}

	@ToString
	static abstract class Item<K> {
		@Getter
		private final K id;

		public Item(K id) {
			this.id = id;
		}
	}

	@ToString(callSuper = true)
	static class Album<K> extends Item<K> {

		@Setter
		private String artist;

		public Album(K id) {
			super(id);
		}
	}

	@ToString(callSuper = true)
	static class Book<K> extends Item<K> {

		@Setter
		private String isbn;

		public Book(K id) {
			super(id);
		}
	}
}
