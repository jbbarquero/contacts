package com.malsolo.contacts.domain;
import java.util.Iterator;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.roo.addon.test.RooIntegrationTest;

import com.malsolo.contacts.model.ItemDTO;

@RooIntegrationTest(entity = Item.class)
public class ItemIntegrationTest {

    @Test
    public void testMarkerMethod() {
    }

    @Test
    public void testSaveItemDto() {
        Assert.assertNotNull("Data on demand for 'Item' failed to initialize correctly", dod.getRandomItem());
        Item obj = dod.getNewTransientItem(Integer.MAX_VALUE);
        Assert.assertNotNull("Data on demand for 'Item' failed to provide a new transient entity", obj);
        Assert.assertNull("Expected 'Item' identifier to be null", obj.getId());
        ItemDTO itemDto = new ItemDTO();
        itemDto.setName(obj.getName());
        itemDto.setDescription(obj.getDescription());
        try {
            itemService.saveItem(itemDto);
        } catch (final ConstraintViolationException e) {
            final StringBuilder msg = new StringBuilder();
            for (Iterator<ConstraintViolation<?>> iter = e.getConstraintViolations().iterator(); iter.hasNext();) {
                final ConstraintViolation<?> cv = iter.next();
                msg.append("[").append(cv.getRootBean().getClass().getName()).append(".").append(cv.getPropertyPath()).append(": ").append(cv.getMessage()).append(" (invalid value = ").append(cv.getInvalidValue()).append(")").append("]");
            }
            throw new IllegalStateException(msg.toString(), e);
        }
        Assert.assertNotNull("Expected 'Item' identifier to no longer be null", itemDto.getId());
    }

    @Test
    public void testUpdateItemDtoUpdate() {
        Item obj = dod.getRandomItem();
        Assert.assertNotNull("Data on demand for 'Item' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Item' failed to provide an identifier", id);
        obj = itemService.findItem(id);
        //Integer currentVersion = obj.getVersion();
        ItemDTO merged = itemService.updateItem(itemService.entityToDto(obj));
        Assert.assertEquals("Identifier of merged object not the same as identifier of original object", merged.getId(), id);
    }

    @Test
    public void testDeleteItemDto() {
        Item obj = dod.getRandomItem();
        Assert.assertNotNull("Data on demand for 'Item' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Item' failed to provide an identifier", id);
        ItemDTO itemDto = itemService.entityToDto(itemService.findItem(id));
        itemService.deleteItem(itemDto);
        Assert.assertNull("Failed to remove 'Item' with identifier '" + id + "'", itemService.findItem(id));
    }
}
