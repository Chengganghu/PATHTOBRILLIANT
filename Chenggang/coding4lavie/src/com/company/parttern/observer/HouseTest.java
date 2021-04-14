package com.company.parttern.observer;

import java.util.Date;

public class HouseTest {

    public static void main(String[] args) {
        House house = new House(4000000);

        HousePriceObserver h1 = new HousePriceObserver("buyer one");
        HousePriceObserver h2 = new HousePriceObserver("buyer two");
        HousePriceObserver h3 = new HousePriceObserver("buyer three");

        house.addObserver(h1);
        house.addObserver(h2);
        house.addObserver(h3);

        System.out.println(house);
        house.setPrice(3000000);
        System.out.println(house);

        System.out.println(new Date().toString());
    }
}
