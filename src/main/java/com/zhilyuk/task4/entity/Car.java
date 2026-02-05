package com.zhilyuk.task4.entity;

public class Car extends AbstractEntity {
    private final String carNumber;
    private final String color;
    private final String model;
    private boolean available = true;

    public Car(int id, String carNumber, String color, String model) {
        super(id);
        this.carNumber = carNumber;
        this.color = color;
        this.model = model;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public boolean isAvailable() {
        return available;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.color)
                .append(" ")
                .append(this.model)
                .append(", ")
                .append(this.carNumber);
        return sb.toString();
    }
}
