package jpa.app.shop.controller.form;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BookForm {

	private Long id;
	private String name;
	private long price;
	private long stockQuantity;
	private String author;
	private String isbn;
}
