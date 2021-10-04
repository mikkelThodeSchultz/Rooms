package com.company;

public class Item {

    private String itemName;
    private String itemDescription;

    public Item(String itemName, String itemDescription){

        this.itemName = itemName;
        this.itemDescription = itemDescription;
    }

    public Item (String itemName){

        this.itemName = itemName;
    }

    public String getItemName(){

        return itemName;
    }

}
