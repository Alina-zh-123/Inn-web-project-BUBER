package com.zhilyuk.task4.dao.impl;

import com.zhilyuk.task4.dao.ClientDao;
import com.zhilyuk.task4.entity.Client;
import com.zhilyuk.task4.exception.DaoException;
import com.zhilyuk.task4.pool.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClientDaoImpl implements ClientDao {
    private static final String FIND_BY_EMAIL = "SELECT * FROM clients WHERE email = ?";
    private static final String INSERT = "INSERT INTO clients(name, email, passwordHash) VALUES (?, ?, ?)";
    private static final String DELETE = "DELETE FROM clients WHERE id = ?";

    public Client findByEmail(String email) throws DaoException {
        Connection conn = ConnectionPool.getInstance().getConnection();
        try (PreparedStatement prStmt = conn.prepareStatement(FIND_BY_EMAIL)) {
            prStmt.setString(1, email);
            ResultSet rs = prStmt.executeQuery();
            while (rs.next()) {
                String rsEmail = rs.getString("email");
                if (rsEmail.equals(email)) {
                    int rsId = rs.getInt("id");
                    String rsUsername = rs.getString("username");
                    String rsPasswordHash = rs.getString("passwordHash");
                    Client rsClient = new Client(rsId, rsUsername, rsPasswordHash, rsEmail);
                    return rsClient;
                }
            }
        } catch (SQLException e) {
            throw new DaoException(e.getMessage());
        } finally {
            ConnectionPool.getInstance().releaseConnection(conn);
        }
        return null;
    }

    public Client findByUsername(String username) throws DaoException {
        Connection conn = ConnectionPool.getInstance().getConnection();
        try (PreparedStatement prStmt = conn.prepareStatement(FIND_BY_EMAIL);) {
            prStmt.setString(1, username);
            ResultSet rs = prStmt.executeQuery();
            while (rs.next()) {
                String rsUsername = rs.getString("username");
                if (rsUsername.equals(username)) {
                    int rsId = rs.getInt("id");
                    String rsEmail = rs.getString("email");
                    String rsPasswordHash = rs.getString("passwordHash");                    Client rsClient = new Client(rsId, rsUsername, rsPasswordHash, rsEmail);
                    return rsClient;
                }
            }
        } catch (SQLException e) {
            throw new DaoException(e.getMessage());
        } finally {
            ConnectionPool.getInstance().releaseConnection(conn);
        }
        return null;
    }

    public void save(Client client) throws DaoException {
        Connection conn = ConnectionPool.getInstance().getConnection();
        try (PreparedStatement prStmt = conn.prepareStatement(INSERT)) {
            prStmt.setString(1, client.getUsername());
            prStmt.setString(2, client.getPasswordHash());
            prStmt.setString(3, client.getEmail());
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
