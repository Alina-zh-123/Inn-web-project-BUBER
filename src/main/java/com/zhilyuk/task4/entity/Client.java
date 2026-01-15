package com.zhilyuk.task4.entity;

import java.util.Random;

public class Client extends AbstractEntity {
    static public int id = 1;
    private final String username;
    private final String password;
    private final String email;
    private double latitude;
    private double longitude;
    boolean banned;
    int bonusCount;

    public Client(int id, String username, String password, String email) {
        super(id);
        this.username = username;
        this.password = password;
        this.email = email;

        Random rand = new Random();
        this.latitude = 51.3 + (56.2 - 51.3) * rand.nextDouble();
        this.longitude = 23.2 + (32.8 - 23.2) * rand.nextDouble();
    }

    @Override
    public int getId() {
        return super.getId();
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
