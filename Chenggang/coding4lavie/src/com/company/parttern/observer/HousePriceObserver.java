package com.company.parttern.observer;

import java.util.Observable;
import java.util.Observer;

public class HousePriceObserver implements Observer {
    private String name;

    public HousePriceObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {
        if (arg instanceof Float) {
            System.out.println(this.name + " price change to :" + arg);
        }
    }
}
