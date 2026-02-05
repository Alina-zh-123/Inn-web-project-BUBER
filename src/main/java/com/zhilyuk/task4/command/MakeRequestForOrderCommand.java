package com.zhilyuk.task4.command;

import com.zhilyuk.task4.dao.impl.CarDaoImpl;
import com.zhilyuk.task4.dao.impl.ClientDaoImpl;
import com.zhilyuk.task4.dao.impl.OrderDaoImpl;
import com.zhilyuk.task4.entity.Car;
import com.zhilyuk.task4.exception.DaoException;
import com.zhilyuk.task4.service.ClientService;
import com.zhilyuk.task4.service.impl.ClientServiceImpl;
import jakarta.servlet.http.HttpServletRequest;

import java.util.ArrayList;

public class MakeRequestForOrderCommand implements Command {
    public static final String MAKE_ORDER = "pages/makeorder.jsp";
    private static final String ERROR_PAGE = "/pages/error.jsp";

    public String execute(HttpServletRequest request) {
        ClientService service = new ClientServiceImpl(new ClientDaoImpl(), new CarDaoImpl(), new OrderDaoImpl());
        ArrayList<Car> cars = null;
        try {
            cars = service.makeRequestForOrder();
        } catch (DaoException e) {
            request.setAttribute("error", "Dao error!");
            return ERROR_PAGE;
        }
        request.getSession().setAttribute("cars", cars);
        return MAKE_ORDER;
    }
}
