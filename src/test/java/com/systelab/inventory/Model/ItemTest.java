package com.systelab.inventory.Model;

import com.systelab.inventory.model.Item;
import com.systelab.inventory.model.Warehouse;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class ItemTest {

    @Test
    public void testFillQuarantineLotInfo_NoLotNumber() {
    
        Item item = new Item();
        item.setLotNumber(null);

        item.fillQuarantineLotInfo(new Date(), null);

        assertFalse(item.isQuarantine());
        assertNull(item.getQuarantineStartDate());
        assertNull(item.getQuarantineEndDate());
    }

    @Test
    public void testFillQuarantineLotInfo_NoPreviousItem() {
        
        Item item = new Item();
        item.setLotNumber("ABC");
        item.setCreatedAt(new Date());

        item.fillQuarantineLotInfo(new Date(), null);

        assertFalse(item.isQuarantine());
        assertNull(item.getQuarantineEndDate());
    }

    @Test
    public void testFillQuarantineLotInfo_WithPreviousItem() {
     
        Item previousItem = new Item();
        previousItem.setCreatedAt(new Date());
        previousItem.setQuarantine(true);
        previousItem.setQuarantineStartDate(new Date());

        Item item = new Item();
        item.setLotNumber("ABC");
        item.setCreatedAt(new Date());
        item.fillQuarantineLotInfo(new Date(), previousItem);
        
        assertFalse(item.isQuarantine());
        assertNotNull(item.getQuarantineEndDate()); 
    }

}
