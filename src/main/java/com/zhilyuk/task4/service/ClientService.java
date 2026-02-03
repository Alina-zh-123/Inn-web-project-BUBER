package com.zhilyuk.task4.service;

import com.zhilyuk.task4.entity.Client;
import com.zhilyuk.task4.entity.Driver;
import com.zhilyuk.task4.entity.Order;
import com.zhilyuk.task4.exception.DaoException;

import java.util.List;

public interface ClientService {
    Client signIn(String email, String password) throws DaoException;
    Client signUp(String username, String email, String password) throws DaoException;
    //void makeRequestForOrder(Client client, double destinationLatitude, double destinationLongitude);
    //void makeOrder(Client client);
    //void declineOrder(Client client, Order order);
}
