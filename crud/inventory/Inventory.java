package com.example.crud.inventory;


import jakarta.persistence.*;

@Entity
@Table
public class Inventory {
    @Id
    @SequenceGenerator(
            name = "inventory_sequence",
            sequenceName = "inventory_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "inventory_sequence"
    )
    private Long id;
    private String item;
    private String itemCode;
    private Integer quantity;

    public Inventory() {
    }

    public Inventory(Long id, String item, String itemCode, Integer quantity) {
        this.id = id;
        this.item = item;
        this.itemCode = itemCode;
        this.quantity = quantity;
    }

    public Inventory(String item, String itemCode, Integer quantity) {
        this.item = item;
        this.itemCode = itemCode;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "id=" + id +
                ", item='" + item + '\'' +
                ", itemCode='" + itemCode + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
