package com.zhilyuk.task4.dao.impl;

import com.zhilyuk.task4.dao.OrderDao;
import com.zhilyuk.task4.entity.Client;
import com.zhilyuk.task4.entity.Order;
import com.zhilyuk.task4.exception.DaoException;
import com.zhilyuk.task4.pool.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrderDaoImpl implements OrderDao {
    private static final String INSERT = "INSERT INTO orders(client, car) VALUES (?, ?)";
    private static final String DELETE = "DELETE FROM orders WHERE id = ?";

    public void save(Order order) throws DaoException {
        Connection conn = ConnectionPool.getInstance().getConnection();
        try (PreparedStatement prStmt = conn.prepareStatement(INSERT)) {
            prStmt.setString(1, order.getClient().getUsername());
            prStmt.setString(2, order.getCar().toString());
            prStmt.executeUpdate();
        } catch(SQLException e){
            throw new DaoException(e.getMessage());
        } finally {
            ConnectionPool.getInstance().releaseConnection(conn);
        }
    }

    public void deleteById(int id) throws DaoException {
        Connection conn = ConnectionPool.getInstance().getConnection();
        try (PreparedStatement prStmt = conn.prepareStatement(DELETE)) {
            prStmt.setInt(1, id);
            prStmt.executeUpdate();
        } catch(SQLException e){
            throw new DaoException(e.getMessage());
        } finally {
            ConnectionPool.getInstance().releaseConnection(conn);
        }
    }
}
