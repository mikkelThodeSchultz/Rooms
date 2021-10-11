package com.company;

public class Item {

    protected String itemName;
    protected String itemDescription;
    protected int itemWeight;
    protected final FoodChecker foodChecker;

    public Item(String itemName, String itemDescription, int itemWeight, FoodChecker foodChecker){

        this.foodChecker = foodChecker;
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.itemWeight = itemWeight;
    }

    public FoodChecker getFoodChecker(){
        return foodChecker;
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
