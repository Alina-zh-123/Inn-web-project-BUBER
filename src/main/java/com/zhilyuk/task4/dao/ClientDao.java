package com.zhilyuk.task4.dao;

import com.zhilyuk.task4.entity.Client;
import com.zhilyuk.task4.entity.Driver;
import com.zhilyuk.task4.exception.DaoException;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ClientDao {
    Client findByEmail(String email) throws DaoException;
    Client findByUsername(String username) throws DaoException;
    void save(Client client) throws DaoException;
    void deleteById(int id) throws DaoException;
}
