package com.zhilyuk.task4.pool;

import com.zhilyuk.task4.exception.PoolException;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ConnectionPool {
    private static ConnectionPool instance;

    private BlockingQueue<Connection> pool;

    private String url;
    private String user;
    private String password;
    private String driver;
    private int poolSize;

    public ConnectionPool() {
        loadProperties();
        initDriver();
        initPool();
    }

    public static ConnectionPool getInstance() {
        if (instance == null) {
            synchronized (ConnectionPool.class) {
                if (instance == null) {
                    instance = new ConnectionPool();
                }
            }
        }
        return instance;
    }

    public void loadProperties() {
        Properties properties = new Properties();

        try (InputStream inputStream = ConnectionPool.class.getClassLoader().getResourceAsStream("db.properties")) {
            if (inputStream == null) {
                throw new PoolException("File db.properties not found!");
            }

            properties.load(inputStream);
            url = properties.getProperty("db.url");
            user = properties.getProperty("db.user");
            password = properties.getProperty("db.password");
            driver = properties.getProperty("db.driver");
            poolSize = Integer.parseInt(properties.getProperty("db.pool.size"));
        } catch (Exception e) {
            throw new PoolException("Input stream error!", e);
        }
    }

    public void initDriver(){
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            throw new PoolException("Driver error!", e);
        }
    }

    public void initPool() {
        pool = new ArrayBlockingQueue<>(poolSize);

        try {
            for (int i = 0; i < poolSize; i++) {
                Connection conn = DriverManager.getConnection(url, user, password);
                pool.offer(conn);
            }
        } catch (SQLException e) {
            throw new PoolException("Connection build error!", e);
        }
    }

    public Connection getConnection() {
        try {
            return pool.take();
        } catch (InterruptedException e) {
            throw new PoolException("Connection error!", e);
        }
    }

    public void releaseConnection(Connection conn) {
        if (conn != null) {
            pool.offer(conn);
        }
    }
}

