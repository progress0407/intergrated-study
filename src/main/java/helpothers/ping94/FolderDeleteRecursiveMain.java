package helpothers.ping94;

import static java.lang.System.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.UUID;
import java.util.stream.Collectors;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class FolderDeleteRecursiveMain {

	private static List<File> files = new LinkedList<>();
	private static List<Folder> folders = new LinkedList<>();
	private static List<Bookmark> bookmarks = new LinkedList<>();

	@Getter
	@Setter
	@ToString
	private abstract static class File {
		private String id;
		private String parentId;
		private String name;
		private boolean isDeleted;
	}

	@Getter
	@Setter
	private static class Folder extends File {
		private String id;
		private String parentId;
		private String name;
		private boolean isDeleted;

		public Folder(String id, String parentId, String name) {
			this.id = id;
			this.parentId = parentId;
			this.name = name;
			this.isDeleted = false;
		}

		@Override
		public String toString() {
			return "Folder{" +
				"name='" + name + '\'' +
				", isDeleted=" + isDeleted +
				'}';
		}
	}

	@Getter
	@Setter
	private static class Bookmark extends File {
		private String id;
		private String parentId;
		private String name;
		private boolean isDeleted;

		public Bookmark(String id, String parentId, String name) {
			this.id = id;
			this.parentId = parentId;
			this.name = name;
			this.isDeleted = false;
		}

		@Override
		public String toString() {
			return "Bookmark{" +
				"name='" + name + '\'' +
				", isDeleted=" + isDeleted +
				'}';
		}
	}

	private static class FolderRepository /*extends DataRepository*/ {

		public static void add(Folder folder) {
			// DataRepository.add(folder);
			folders.add(folder);
		}

		public static List<Folder> findByParentId(String id) {
			return folders.stream()
				.filter(folder -> folder.getParentId().equals(id) && !folder.isDeleted())
				.collect(Collectors.toList());
		}

		private static void deleteFolders(List<Folder> folders) {
			if(folders.size() == 0) {
				return;
			}
			for (Folder folder : folders) {
				out.println("delete Folder = " + folder);
				folder.setDeleted(true);
			}
		}
	}

	private static class BookmarkRepository /*extends DataRepository*/ {

		public static void add(Bookmark bookmark) {
			// DataRepository.add(bookmark);
			bookmarks.add(bookmark);
		}

		public static List<Bookmark> findByParentId(String id) {
			return bookmarks.stream()
				.filter(bookmark -> bookmark.getParentId().equals(id) && !bookmark.isDeleted())
				.collect(Collectors.toList());
		}

		private static void deleteBookmarks(List<Bookmark> bookmarks) {

			if(bookmarks.size() == 0) {
				return;
			}

			for (Bookmark bookmark : bookmarks) {
				out.println("delete Bookmark = " + bookmark);
				bookmark.setDeleted(true);
			}
		}
	}

/*
	private static abstract class DataRepository {

		public static void add(File file) {
			files.add(file);
		}

		public static List<File> findByParentId(String id) {
			return files.stream()
				.filter(file -> file.getParentId().equals(id) && !file.isDeleted())
				.collect(Collectors.toList());
		}

	}
*/

	public static void main(String[] args) {
		initSampleData();

		Queue<String> queue = new LinkedList<>();
		queue.offer("/");

		List<Folder> tempFolders = new ArrayList<>();
		List<Bookmark> tempBookmarks = new ArrayList<>();

		while (!queue.isEmpty()) {
			String parentId = queue.poll();
			List<Folder> folders = FolderRepository.findByParentId(parentId);
			List<Bookmark> bookmarks = BookmarkRepository.findByParentId(parentId);

			// 폴더를 큐에 넣기
			for (Folder folder : folders) {
				queue.offer(folder.getId());
			}

			// list 에 먼저 담고...

			// 폴더 삭제
			if(folders.size() > 0) {
				out.println("-------------------- delete query :: folder :: start --------------------");
				FolderRepository.deleteFolders(folders);
				out.println("-------------------- delete query :: folder :: end --------------------\n\n");
			}

			// 북마크 삭제
			if (bookmarks.size() > 0) {
				out.println("-------------------- delete query :: bookmark :: start --------------------");
				BookmarkRepository.deleteBookmarks(bookmarks);
				out.println("-------------------- delete query :: bookmark :: end --------------------\n\n");
			}

			// tempFolders.addAll(folders);
			// tempBookmarks.addAll(bookmarks);
		}
		// list

		// out.println("-------------------- delete query :: folder :: start --------------------");
		// FolderRepository.deleteFolders(tempFolders);
		// out.println("-------------------- delete query :: folder :: end --------------------\n\n");
		//
		// out.println("-------------------- delete query :: bookmark :: start --------------------");
		// BookmarkRepository.deleteBookmarks(tempBookmarks);
		// out.println("-------------------- delete query :: bookmark :: end --------------------\n\n");
	}


	private static void initSampleData() {
		String uuid = getUuid();
		FolderRepository.add(new Folder(uuid, "/", "폴더 A"));

		String uuid2 = getUuid();
		FolderRepository.add(new Folder(uuid2, uuid, "폴더 B"));

		String uuid3 = getUuid();
		BookmarkRepository.add(new Bookmark(uuid3, uuid, "북마크 A"));

		String uuid4 = getUuid();
		FolderRepository.add(new Folder(uuid4, uuid2, "폴더 C"));

		String uuid5 = getUuid();
		FolderRepository.add(new Folder(uuid5, uuid2, "폴더 D"));

		String uuid6 = getUuid();
		BookmarkRepository.add(new Bookmark(uuid6, uuid4, "북마크 B"));

		String uuid7 = getUuid();
		BookmarkRepository.add(new Bookmark(uuid7, uuid4, "북마크 C"));

		String uuid8 = getUuid();
		BookmarkRepository.add(new Bookmark(uuid8, uuid5, "북마크 D"));
	}

	private static String getUuid() {
		return UUID.randomUUID().toString();
	}
}
