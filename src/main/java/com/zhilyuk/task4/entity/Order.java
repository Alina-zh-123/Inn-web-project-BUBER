package com.zhilyuk.task4.entity;

public class Order extends AbstractEntity {
    private Client client;
    private Car car;
    private OrderStatus status;

    public Order(int id, Client client, Car car) {
        super(id);
        this.client = client;
        this.car = car;
        this.status = OrderStatus.REQUESTED;
    }

    public Client getClient() {
        return client;
    }

    public Car getCar() {
        return car;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}

