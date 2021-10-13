package com.company;

public class Item {

    protected String itemName;
    protected String itemDescription;
    protected int itemWeight;

    public Item(String itemName, String itemDescription, int itemWeight){

        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.itemWeight = itemWeight;
    }

    public String getItemName(){
        return itemName;
    }

    public int getItemWeight(){
        return itemWeight;
    }

    public String getItemDescription() {
        return itemDescription;
    }
}
