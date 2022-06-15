package jpa.app.shop;

import jpa.app.shop.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ShopApplication {

	@Autowired
	private ItemRepository itemRepository;

	public static void main(String[] args) {
		SpringApplication.run(ShopApplication.class, args);
	}
}
