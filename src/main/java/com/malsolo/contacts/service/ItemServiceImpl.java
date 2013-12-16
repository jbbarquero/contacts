package com.malsolo.contacts.service;

import com.malsolo.contacts.domain.Item;
import com.malsolo.contacts.model.ItemDTO;

public class ItemServiceImpl implements ItemService {

    public void saveItem(ItemDTO itemDto) {
        Item item = dtoToEntity(itemDto);
        item.persist();
    	item.flush();
    	itemDto.setId(item.getId());
    }

    public void deleteItem(ItemDTO itemDto) {
        Item item = this.findItem(itemDto.getId());
        item.remove();
    	item.flush();
    }

    public ItemDTO updateItem(ItemDTO itemDto) {
        Item item = this.findItem(itemDto.getId());
        item.merge();
    	item.flush();
        return entityToDto(item);
    }
    
    public Item dtoToEntity(ItemDTO itemDto) {
        Item item = new Item();
        item.setId(itemDto.getId());
        item.setName(itemDto.getName());
        item.setDescription(itemDto.getDescription());
    	return item;
    }

    public ItemDTO entityToDto(Item item) {
        ItemDTO itemDto = new ItemDTO();
        itemDto.setId(item.getId());
        itemDto.setName(item.getName());
        itemDto.setDescription(item.getDescription());
    	return itemDto;
    	
    }
}
