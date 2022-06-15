package jpa.app.shop.service;

import jpa.app.shop.repository.ItemRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class ItemService {

	private final ItemRepository itemRepository;

/*	@Transactional
	public Long save(Item item) {

	}

	*//**
	 * 이것은 마치 em.merge() 가 동작하는 방식과 같다
	 * Item mergedItem = em.merge(item);
	 * 이때 item은 준영속, mergedItem 은 영속상태이다
	 *//*
	@Transactional
	public Item updateItem(Long itemId, Book param) {

	}

	public List<Item> findItems() {

	}

	public Item findOne(Long id) {

	}*/
}
