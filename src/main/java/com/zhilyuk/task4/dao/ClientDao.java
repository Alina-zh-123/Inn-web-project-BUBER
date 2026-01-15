package com.zhilyuk.task4.dao;

import com.zhilyuk.task4.entity.Client;
import com.zhilyuk.task4.entity.Driver;

import java.util.ArrayList;

public interface ClientDao {
    Client findByEmail(String email);
    void save(Client client);
    void deleteById(int id);
}
