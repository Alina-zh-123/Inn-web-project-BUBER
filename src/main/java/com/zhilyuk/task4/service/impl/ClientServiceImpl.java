package com.zhilyuk.task4.service.impl;

import com.zhilyuk.task4.dao.ClientDao;
import com.zhilyuk.task4.dao.impl.ClientDaoImpl;
import com.zhilyuk.task4.entity.Client;
import com.zhilyuk.task4.entity.Driver;
import com.zhilyuk.task4.entity.Order;
import com.zhilyuk.task4.exception.DaoException;
import com.zhilyuk.task4.service.ClientService;
import com.zhilyuk.task4.util.PasswordEncoder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Random;

public class ClientServiceImpl implements ClientService {
    private static final Logger logger = LogManager.getLogger();
    private final ClientDaoImpl clientDao;

    public ClientServiceImpl(ClientDaoImpl clientDao) {
        this.clientDao = clientDao;
    }

    public Client signIn(String email, String password) throws DaoException {
        Client client = clientDao.findByEmail(email);
        if (client == null) {
            logger.warn("Client email {} not found", email);
            return null;
        }
        PasswordEncoder passwordEncoder = new PasswordEncoder();

        if (!client.getPasswordHash().equals(passwordEncoder.hashPassword(password))) {
            logger.warn("Wrong password for {}", client.getUsername());
            return null;
        }

        logger.info("Client {} signed in", client.getUsername());
        return client;
    }

    public Client signUp(String username, String email, String password) throws DaoException {
        Client existingClient = clientDao.findByEmail(email);
        if (existingClient == null) {
            PasswordEncoder passwordEncoder = new PasswordEncoder();
            Client newClient = new Client(Client.id++, username, email, passwordEncoder.hashPassword(password));
            clientDao.save(newClient);
            logger.info("Client {} added to db", username);
            return newClient;
        } else {
            logger.warn("Client with email {} already exists", username);
            return null;
        }
    }

    /*
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
    */
}
