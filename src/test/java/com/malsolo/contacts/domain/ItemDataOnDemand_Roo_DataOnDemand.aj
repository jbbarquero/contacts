// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.malsolo.contacts.domain;

import com.malsolo.contacts.domain.Item;
import com.malsolo.contacts.domain.ItemDataOnDemand;
import com.malsolo.contacts.service.ItemService;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

privileged aspect ItemDataOnDemand_Roo_DataOnDemand {
    
    declare @type: ItemDataOnDemand: @Component;
    
    private Random ItemDataOnDemand.rnd = new SecureRandom();
    
    private List<Item> ItemDataOnDemand.data;
    
    @Autowired
    ItemService ItemDataOnDemand.itemService;
    
    public Item ItemDataOnDemand.getNewTransientItem(int index) {
        Item obj = new Item();
        setDescription(obj, index);
        setName(obj, index);
        return obj;
    }
    
    public void ItemDataOnDemand.setDescription(Item obj, int index) {
        String description = "description_" + index;
        obj.setDescription(description);
    }
    
    public void ItemDataOnDemand.setName(Item obj, int index) {
        String name = "name_" + index;
        obj.setName(name);
    }
    
    public Item ItemDataOnDemand.getSpecificItem(int index) {
        init();
        if (index < 0) {
            index = 0;
        }
        if (index > (data.size() - 1)) {
            index = data.size() - 1;
        }
        Item obj = data.get(index);
        Long id = obj.getId();
        return itemService.findItem(id);
    }
    
    public Item ItemDataOnDemand.getRandomItem() {
        init();
        Item obj = data.get(rnd.nextInt(data.size()));
        Long id = obj.getId();
        return itemService.findItem(id);
    }
    
    public boolean ItemDataOnDemand.modifyItem(Item obj) {
        return false;
    }
    
    public void ItemDataOnDemand.init() {
        int from = 0;
        int to = 10;
        data = itemService.findItemEntries(from, to);
        if (data == null) {
            throw new IllegalStateException("Find entries implementation for 'Item' illegally returned null");
        }
        if (!data.isEmpty()) {
            return;
        }
        
        data = new ArrayList<Item>();
        for (int i = 0; i < 10; i++) {
            Item obj = getNewTransientItem(i);
            try {
                itemService.saveItem(obj);
            } catch (final ConstraintViolationException e) {
                final StringBuilder msg = new StringBuilder();
                for (Iterator<ConstraintViolation<?>> iter = e.getConstraintViolations().iterator(); iter.hasNext();) {
                    final ConstraintViolation<?> cv = iter.next();
                    msg.append("[").append(cv.getRootBean().getClass().getName()).append(".").append(cv.getPropertyPath()).append(": ").append(cv.getMessage()).append(" (invalid value = ").append(cv.getInvalidValue()).append(")").append("]");
                }
                throw new IllegalStateException(msg.toString(), e);
            }
            obj.flush();
            data.add(obj);
        }
    }
    
}
