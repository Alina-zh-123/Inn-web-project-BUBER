package com.zhilyuk.task4.service;

import com.zhilyuk.task4.entity.Car;
import com.zhilyuk.task4.entity.Client;
import com.zhilyuk.task4.entity.Driver;
import com.zhilyuk.task4.entity.Order;
import com.zhilyuk.task4.exception.DaoException;

import java.util.ArrayList;
import java.util.List;

public interface ClientService {
    Client signIn(String email, String password) throws DaoException;
    Client signUp(String username, String email, String password) throws DaoException;
    ArrayList<Car> makeRequestForOrder() throws DaoException;
    Order makeOrder(Client client, Car car) throws DaoException;
    void declineOrder(int id) throws DaoException;
}
