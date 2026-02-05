package com.zhilyuk.task4.command;

import com.zhilyuk.task4.dao.impl.CarDaoImpl;
import com.zhilyuk.task4.dao.impl.ClientDaoImpl;
import com.zhilyuk.task4.dao.impl.OrderDaoImpl;
import com.zhilyuk.task4.entity.Car;
import com.zhilyuk.task4.exception.DaoException;
import com.zhilyuk.task4.service.ClientService;
import com.zhilyuk.task4.service.impl.ClientServiceImpl;
import jakarta.servlet.http.HttpServletRequest;

public class DeclineOrderCommand implements Command {
    private static final String HOME_PAGE = "/pages/home.jsp";
    private static final String ERROR_PAGE = "/pages/error.jsp";

    public String execute(HttpServletRequest request) {
        ClientService service = new ClientServiceImpl(new ClientDaoImpl(), new CarDaoImpl(), new OrderDaoImpl());
        Car car = (Car) request.getSession().getAttribute("car");
        int id = car.getId();
        try {
            service.declineOrder(id);
        } catch (DaoException e) {
            request.setAttribute("error", "Dao error!");
            return ERROR_PAGE;
        }
        request.getSession().setAttribute("car", null);
        return HOME_PAGE;
    }
}
