package com.company.parttern.observer;

import java.util.Observable;

public class House extends Observable {

    private float price;

    public House(float price) {
        this.price = price;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {

        super.setChanged();
        super.notifyObservers(price);
        this.price = price;
    }

    public String toString() {
        return "Price of house is: " + this.price;
    }
}
