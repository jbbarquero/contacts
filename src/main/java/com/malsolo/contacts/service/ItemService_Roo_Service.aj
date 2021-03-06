// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.malsolo.contacts.service;

import com.malsolo.contacts.domain.Item;
import com.malsolo.contacts.service.ItemService;
import java.util.List;

privileged aspect ItemService_Roo_Service {
    
    public abstract long ItemService.countAllItems();    
    public abstract void ItemService.deleteItem(Item item);    
    public abstract Item ItemService.findItem(Long id);    
    public abstract List<Item> ItemService.findAllItems();    
    public abstract List<Item> ItemService.findItemEntries(int firstResult, int maxResults);    
    public abstract void ItemService.saveItem(Item item);    
    public abstract Item ItemService.updateItem(Item item);    
}
