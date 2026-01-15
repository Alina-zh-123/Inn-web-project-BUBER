package com.zhilyuk.task4.service.impl;

import com.zhilyuk.task4.dao.impl.ClientDaoImpl;
import com.zhilyuk.task4.entity.Client;
import com.zhilyuk.task4.entity.Driver;
import com.zhilyuk.task4.entity.Order;
import com.zhilyuk.task4.service.ClientService;

import java.util.List;
import java.util.Random;

public class ClientServiceImpl implements ClientService {
    private final ClientDaoImpl clientDao = new ClientDaoImpl();

    public void signIn(String nameSurname, String password) {

    }

    public void signOut() {

    }

    public void signUp(String username, String email, String password) {
        Client existingClient = clientDao.findByEmail(email);
        if (existingClient == null) {
            Client newClient = new Client(Client.id++, username, email, password);
            clientDao.save(newClient);
        } else {

        }
    }

    public void makeRequestForOrder(Client client, double destinationLatitude, double destinationLongitude) {
        Random rand = new Random();
        client.setLatitude(51.3 + (56.2 - 51.3) * rand.nextDouble());
        client.setLongitude(23.2 + (32.8 - 23.2) * rand.nextDouble());

        Order order = new Order();
    }

    public void makeOrder(List<Driver> Driver) {

    }

    public void declineOrder() {

    }
}
