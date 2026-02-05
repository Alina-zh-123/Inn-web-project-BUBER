package com.zhilyuk.task4.service.impl;

import com.zhilyuk.task4.dao.CarDao;
import com.zhilyuk.task4.dao.ClientDao;
import com.zhilyuk.task4.dao.OrderDao;
import com.zhilyuk.task4.dao.impl.CarDaoImpl;
import com.zhilyuk.task4.dao.impl.ClientDaoImpl;
import com.zhilyuk.task4.dao.impl.OrderDaoImpl;
import com.zhilyuk.task4.entity.*;
import com.zhilyuk.task4.exception.DaoException;
import com.zhilyuk.task4.service.ClientService;
import com.zhilyuk.task4.util.PasswordEncoder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ClientServiceImpl implements ClientService {
    private static final Logger logger = LogManager.getLogger();
    private final ClientDaoImpl clientDao;
    private final CarDaoImpl carDao;
    private final OrderDaoImpl orderDao;

    public ClientServiceImpl(ClientDaoImpl clientDao, CarDaoImpl carDao, OrderDaoImpl orderDao) {
        this.clientDao = clientDao;
        this.carDao = carDao;
        this.orderDao = orderDao;
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

    public ArrayList<Car> makeRequestForOrder() throws DaoException {
        ArrayList<Car> cars = carDao.findAll();
        ArrayList<Car> res = new ArrayList<>();
        for (Car car : cars) {
            if (car.isAvailable()) {
                res.add(car);
            }
        }
        return res;
    }

    public Order makeOrder(Client client, Car car) throws DaoException {
        Order order = new Order(0, client, car);
        orderDao.save(order);
        order.setStatus(OrderStatus.IN_PROCESS);
        return order;
    }

    public void declineOrder(int id) throws DaoException {
        orderDao.deleteById(id);
    }
}
