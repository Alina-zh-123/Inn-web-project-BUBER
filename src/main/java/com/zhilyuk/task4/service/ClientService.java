package com.zhilyuk.task4.service;

import com.zhilyuk.task4.entity.Client;
import com.zhilyuk.task4.entity.Driver;
import com.zhilyuk.task4.entity.Order;

import java.util.List;

public interface ClientService {
    void signIn(String nameSurname, String password);
    void signOut();
    void signUp(String nameSurname, String email, String password);
    void makeRequestForOrder(Client client, double destinationLatitude, double destinationLongitude);
    void makeOrder(Client client);
    void declineOrder(Client client, Order order);
}
