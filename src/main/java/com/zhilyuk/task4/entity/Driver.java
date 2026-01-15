package com.zhilyuk.task4.entity;

public class Driver extends AbstractEntity {
    private Car car;
    private final String driverName;
    private boolean banned;

    public Driver(int id, String driverName) {
        super(id);
        this.driverName = driverName;
    }

    public Car getCar() {
        return car;
    }

    public boolean isBanned() {
        return banned;
    }

    public String getDriverName() {
        return driverName;
    }


}
