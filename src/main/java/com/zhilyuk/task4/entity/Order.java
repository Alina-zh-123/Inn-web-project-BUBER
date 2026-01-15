package com.zhilyuk.task4.entity;

public class Order extends AbstractEntity {
    private double price;
    private Driver Driver;
    private Car car;
    private OrderStatus status;

    public Order(int id, double price, Driver driver, Car car) {
        super(id);
        this.price = price;
        Driver = driver;
        this.car = car;
        this.status = OrderStatus.REQUESTED;
    }
}

