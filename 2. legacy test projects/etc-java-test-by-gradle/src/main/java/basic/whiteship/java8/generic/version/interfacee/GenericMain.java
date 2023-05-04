package basic.whiteship.java8.generic.version.interfacee;

import static java.lang.System.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class GenericMain {

	public static void main(String[] args) {
		test1();
	}

	private static void test1() {
		Book<Long> book = new Book<>(101L);
		book.setIsbn("101-가-222");

		Book<Long> book2 = new Book<>(102L);
		book.setIsbn("102-나-333");

		BookRepository bookRepository = new BookRepositoryImpl();
		bookRepository.add(book);
		bookRepository.add(book2);

		out.println("-------------- print findBooks -----------------");
		List<Book<Long>> findBooks = bookRepository.findAll();
		findBooks.forEach(out::println);

	}

	interface BookRepository extends ItemRepository<Book<Long>, Long> {

	}

	interface AlbumRepository extends ItemRepository<Album<Long>, Long> {

	}

	interface ItemRepository<E extends Item<K>, K> {
		K add(E item);

		K remove(E item);

		E find(E item);

		List<E> findAll();

		<T extends Item<K>> List<T> findByClass(Class<T> clazz);
	}

	private static class ItemRepositoryImpl<E extends Item<K>, K> implements ItemRepository<E, K> {

		private final List<E> items = new ArrayList<>();

		@Override
		public K add(E item) {
			items.add(item);
			return item.getId();
		}

		@Override
		public K remove(E item) {
			items.remove(item);
			return item.getId();
		}

		@Override
		public E find(E item) {
			return items.stream()
				.filter((E i) -> i.equals(item))
				.findAny()
				.orElseThrow(() -> new RuntimeException("값을 찾을 수 없습니다 : " + item));
		}

		@Override
		public List<E> findAll() {
			return items;
		}

		public <T extends Item<K>> List<T> findByClass(Class<T> clazz) {
			return items.stream()
				.filter((E item) -> item.getClass().equals(clazz))
				.map((E item) -> (T)item)
				.collect(Collectors.toList());
		}
	}

	private static class BookRepositoryImpl implements BookRepository {

		private final List<Book<Long>> books = new ArrayList<>();

		@Override
		public Long add(Book<Long> book) {
			books.add(book);
			return book.getId();
		}

		@Override
		public Long remove(Book<Long> book) {
			books.remove(book);
			return book.getId();
		}

		@Override
		public Book<Long> find(Book<Long> book) {
			return books.stream()
				.filter((Book b) -> b.equals(book))
				.findAny()
				.orElseThrow(() -> new RuntimeException("값을 찾을 수 없습니다 : " + book));
		}

		@Override
		public List<Book<Long>> findAll() {
			return books;
		}

		@Override
		public <T extends Item<Long>> List<T> findByClass(Class<T> clazz) {
			return null;
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