package com.zhilyuk.task4.dao.impl;

import com.zhilyuk.task4.dao.CarDao;
import com.zhilyuk.task4.entity.Car;
import com.zhilyuk.task4.entity.Driver;
import com.zhilyuk.task4.exception.DaoException;
import com.zhilyuk.task4.pool.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CarDaoImpl implements CarDao {
    private static final String FIND_ALL = "SELECT * FROM cars";

    public ArrayList<Car> findAll() throws DaoException {
        Connection conn = ConnectionPool.getInstance().getConnection();
        try {
            PreparedStatement prStmt = conn.prepareStatement(FIND_ALL);
            ResultSet rs = prStmt.executeQuery();

            ArrayList<Car> cars = new ArrayList<>();

            while (rs.next()) {
                Car car = new Car(rs.getInt("id"),
                        rs.getString("carNumber"),
                        rs.getString("color"),
                        rs.getString("model")
                );
                cars.add(car);
            }
            return cars;
        } catch (SQLException e) {
            throw new DaoException(e.getMessage());
        } finally {
            ConnectionPool.getInstance().releaseConnection(conn);
        }
    }
}
