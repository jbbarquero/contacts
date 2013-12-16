package com.malsolo.contacts.service;
import org.springframework.roo.addon.layers.service.RooService;

import com.malsolo.contacts.domain.Item;
import com.malsolo.contacts.model.ItemDTO;

@RooService(domainTypes = { com.malsolo.contacts.domain.Item.class })
public interface ItemService {

    public abstract void deleteItem(ItemDTO itemDto);    
    public abstract void saveItem(ItemDTO itemDto);    
    public abstract ItemDTO updateItem(ItemDTO itemDto);    
    public Item dtoToEntity(ItemDTO itemDto);
    public ItemDTO entityToDto(Item item);

}
