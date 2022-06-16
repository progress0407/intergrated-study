package jpa.app.shop.controller;

import java.util.List;
import jpa.app.shop.controller.form.BookForm;
import jpa.app.shop.domain.item.Book;
import jpa.app.shop.domain.item.Item;
import jpa.app.shop.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/items")
public class ItemController {

    private final ItemService itemService;
    private final ModelMapper mapper;

    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("form", new BookForm());
        return "items/createItemForm";
    }

    @PostMapping("/new")
    public String create(BookForm form) {
        Book book = mapper.map(form, Book.class);

        itemService.save(book);

        return "redirect:/";
    }

    @GetMapping
    public String list(Model model) {
        List<Item> items = itemService.findItems();
        model.addAttribute("items", items);
        return "items/itemList";
    }

    @GetMapping("/{itemId}/edit")
    public String updateItemForm(@PathVariable Long itemId, Model model) {
        Book item = (Book) itemService.findOne(itemId);

        BookForm form = mapper.map(item, BookForm.class);

        model.addAttribute("form", form);
        return "items/updateItemForm_";
    }

    @PostMapping("/{itemId}/edit")
    public String updateItem(@ModelAttribute("form") BookForm form) {
        Book book = mapper.map(form, Book.class);

        itemService.save(book);
        return "redirect:/items";
    }
}
