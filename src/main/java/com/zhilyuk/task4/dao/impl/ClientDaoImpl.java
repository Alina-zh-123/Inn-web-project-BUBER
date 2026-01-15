package com.zhilyuk.task4.dao.impl;

import com.zhilyuk.task4.dao.ClientDao;
import com.zhilyuk.task4.entity.Client;

import java.util.ArrayList;

public class ClientDaoImpl implements ClientDao {
    private static final String FIND_BY_EMAIL = "SELECT * FROM clients WHERE email = ?";
    private static final String INSERT = "INSERT INTO clients(name, email, password) VALUES (?, ?, ?)";
    private static final String DELETE = "DELETE FROM clients WHERE id = ?";

    public Client findByEmail(String email) {

    }

    public void save(Client client) {

    }

    public void deleteById(int id) {

    }
}
