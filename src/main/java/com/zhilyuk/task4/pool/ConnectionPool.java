package com.zhilyuk.task4.pool;

public class ConnectionPool {
    private static ConnectionPool instance;

    private String url = null;

    public ConnectionPool() {
        this.url = "";
    }

    public static ConnectionPool getInstance() {
        if (instance == null) {
            instance = new ConnectionPool();
        }
        return instance;
    }
}
