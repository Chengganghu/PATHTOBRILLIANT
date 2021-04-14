package com.company.thread.atomic;

public class UnSafeCounter implements Runnable{

    private Integer number ;

    public UnSafeCounter(Integer number) {
        this.number = number;
    }


    @Override
    public void run() {
        number ++;
    }

    public Integer getNumber() {
        return number;
    }
}
