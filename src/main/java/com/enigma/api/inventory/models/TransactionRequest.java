package com.enigma.api.inventory.models;


public class TransactionRequest {

    private Integer id;

    private Integer ItemId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getItemId() {
        return ItemId;
    }

    public void setItemId(Integer itemId) {
        ItemId = itemId;
    }
}
