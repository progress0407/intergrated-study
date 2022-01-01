package test.grammer.serializable;

import static java.lang.System.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Paths;

public class SerializableMain  {

	// static final long serialVersionUID = 1L;

	public static final String PATH_SEPARATOR = File.separator;

	public static void main(String[] args) {

		String rootPath = System.getProperty("user.dir");
		// out.println(PATH_SEPARATOR);

		String path = Paths.get(rootPath, "file_io_test").toString();
		String file = "serial.obj";
		String fullPath = Paths.get(path, file).toString();

		SerialDTO dto = new SerialDTO("GodOfJava", 1, true, 100);
		// saveObj(fullPath, dto);
		readObj(fullPath);
	}

	private static void readObj(String fullPath) {
		FileInputStream fis = null;
		ObjectInputStream ois = null;

		try {
			fis = new FileInputStream(fullPath);
			ois = new ObjectInputStream(fis);
			Object obj = ois.readObject();
			SerialDTO dto = (SerialDTO)obj;
			out.println("dto = " + dto);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (ois != null) {
				try {
					ois.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	static void saveObj(String fullPath, SerialDTO dto) {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;

		try {
			fos = new FileOutputStream(fullPath);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(dto);

			out.println("Write Success");

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (oos != null) {
				try {
					oos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	static class SerialDTO implements Serializable {

		static final long serialVersionUID = 1L;

		transient private String bookName;
		private int bookOrder;
		private boolean bestSeller;
		private long soldPerDay;
		private String bookType = "IT";

		public SerialDTO(String bookName, int bookOrder, boolean bestSeller, long soldPerDay) {
			super();
			this.bookName = bookName;
			this.bookOrder = bookOrder;
			this.bestSeller = bestSeller;
			this.soldPerDay = soldPerDay;
		}

		@Override
		public String toString() {
			return "SerialDTO{" +
				"bookName='" + bookName + '\'' +
				", bookOrder=" + bookOrder +
				", bestSeller=" + bestSeller +
				", soldPerDay=" + soldPerDay +
				// ", bookType='" + bookType + '\'' +
				'}';
		}
	}
}
