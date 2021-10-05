package com.company;

public class Item {

    private String itemName;
    private String itemDescription;
    public int itemWeight;

    public Item(String itemName, String itemDescription, int itemWeight){

        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.itemWeight = itemWeight;
    }

    public Item (String itemName){
        this.itemName = itemName;
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

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }
}
