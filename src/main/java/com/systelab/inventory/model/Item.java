package com.systelab.inventory.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item extends BaseEntity {

    @Id
    @GeneratedValue
    private Long id;

    private Long orderLineID;

    private Date realEntryDate;
    private Date expiryDate;
    private String label;
    private Integer labelsToPrint;
    private String location;
    private String invoiceOrDeliveryNote;
    private String comments;
    private Double finalPrice;
    private Integer purchaseUnits;
    private Integer initialConsumUnits;
    private Integer remainingUnits;
    private String lotNumber;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "warehouse_id")
    private Warehouse warehouse;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "product_id")
    private Product product;

    private boolean quarantine;
    private Date quarantineStartDate;
    private Date quarantineEndDate;

    
    /**
     * Fills the quarantine lot information for the item.
     * If the lot number is null, clears the quarantine information.
     * If the item is null, sets the quarantine information for a new item.
     * If the item is not null, sets the quarantine information for an existing item.
     *
     * @param ts   the current timestamp
     * @param item the existing item (can be null)
     */
    public void fillQuarantineLotInfo(Date ts, Item item) {
        if (this.getLotNumber() == null) {
            clearQuarantineInfo();
        } else {
            if (item == null) {
                setQuarantineInfoForNewItem();
            } else {
                setQuarantineInfoForExistingItem(ts, item);
            }
        }
    }

    /**
     * Clears the quarantine information for the item.
     * Sets the quarantine flag to false and sets the quarantine start and end dates to null.
     */
    private void clearQuarantineInfo() {
        this.setQuarantine(false);
        this.setQuarantineStartDate(null);
        this.setQuarantineEndDate(null);
    }

    /**
     * Sets the quarantine information for a new item.
     * Sets the quarantine start date to the creation date if the item is in quarantine, otherwise sets it to null.
     * Sets the quarantine end date to null.
     */
    private void setQuarantineInfoForNewItem() {
        this.setQuarantineStartDate(this.quarantine ? this.getCreatedAt() : null);
        this.setQuarantineEndDate(null);
    }

    /**
     * Sets the quarantine information for an existing item.
     * If the item is in quarantine, sets the quarantine start date to the minimum date between the existing item's creation date and the current item's creation date.
     * Sets the quarantine end date to null.
     * If the item is not in quarantine, checks if the existing item has a quarantine start date.
     * If it does, sets the quarantine start date to the minimum date between the existing item's creation date and the current item's creation date.
     * Sets the quarantine end date to the existing item's quarantine end date if it is not null, otherwise sets it to the current timestamp.
     * If the existing item does not have a quarantine start date, clears the quarantine information.
     *
     * @param ts   the current timestamp
     * @param item the existing item
     */
    private void setQuarantineInfoForExistingItem(Date ts, Item item) {
        if (this.quarantine) {
            this.setQuarantineStartDate(findMinimumDate(item.getCreatedAt(), this.getCreatedAt()));
            this.setQuarantineEndDate(null);
        } else {
            if (item.getQuarantineStartDate() != null) {
                this.setQuarantineStartDate(findMinimumDate(item.getCreatedAt(), this.getCreatedAt()));
                this.setQuarantineEndDate(item.getQuarantineEndDate() != null ? item.getQuarantineEndDate() : ts);
            } else {
                clearQuarantineInfo();
            }
        }
    }

    /**
     * Finds the minimum date between two given dates.
     *
     * @param aDate the first date
     * @param bDate the second date
     * @return the minimum date
     */
    private Date findMinimumDate(Date aDate, Date bDate) {
        return aDate.before(bDate) ? aDate : bDate;
    }
}
