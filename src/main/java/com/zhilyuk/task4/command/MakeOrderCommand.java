package com.zhilyuk.task4.command;

import com.zhilyuk.task4.dao.impl.CarDaoImpl;
import com.zhilyuk.task4.dao.impl.ClientDaoImpl;
import com.zhilyuk.task4.dao.impl.OrderDaoImpl;
import com.zhilyuk.task4.entity.Car;
import com.zhilyuk.task4.entity.Client;
import com.zhilyuk.task4.exception.DaoException;
import com.zhilyuk.task4.service.ClientService;
import com.zhilyuk.task4.service.impl.ClientServiceImpl;
import jakarta.servlet.http.HttpServletRequest;

import java.util.ArrayList;

public class MakeOrderCommand implements Command {
    private static final String ERROR_PAGE = "/pages/error.jsp";
    private static final String ORDER_PAGE = "/pages/order.jsp";

    public String execute(HttpServletRequest request) {
        ArrayList<Car> cars = (ArrayList<Car>) request.getSession().getAttribute("cars");

        String carIdParam = request.getParameter("carId");
        if (carIdParam == null) {
            request.setAttribute("error", "You must choose a car!");
            return ERROR_PAGE;
        }
        int carId = Integer.parseInt(carIdParam);
        Car chosenCar = null;
        for (Car c : cars) {
            if (c.getId() == carId) {
                chosenCar = c;
                break;
            }
        }
        if (chosenCar == null) {
            request.setAttribute("error", "Car not found!");
            return ERROR_PAGE;
        }

        ClientService service = new ClientServiceImpl(new ClientDaoImpl(), new CarDaoImpl(), new OrderDaoImpl());
        try {
            if (!cars.isEmpty()) {
                Client client = (Client) request.getSession().getAttribute("client");
                service.makeOrder(client, chosenCar);
                request.getSession().setAttribute("car", chosenCar);
                return ORDER_PAGE;
            } else {
                request.setAttribute("error", "Sign in error!");
                return ERROR_PAGE;
            }
        } catch (DaoException e) {
            request.setAttribute("error", "Dao error!");
            return ERROR_PAGE;
        }
    }
}
