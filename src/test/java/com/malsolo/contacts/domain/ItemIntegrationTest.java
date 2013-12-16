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
}
