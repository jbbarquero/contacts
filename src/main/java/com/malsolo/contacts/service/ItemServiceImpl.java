package com.malsolo.contacts.service;

import com.malsolo.contacts.domain.Item;
import com.malsolo.contacts.model.ItemDTO;

public class ItemServiceImpl implements ItemService {

    public void saveItem(ItemDTO itemDto) {
        Item item = new Item();
        item.setName(itemDto.getName());
        item.setDescription(itemDto.getDescription());
    	item.persist();
    	item.flush();
    	itemDto.setId(item.getId());
    }
}
