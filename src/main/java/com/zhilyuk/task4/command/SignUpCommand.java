package com.zhilyuk.task4.command;

import com.zhilyuk.task4.dao.impl.ClientDaoImpl;
import com.zhilyuk.task4.entity.Client;
import com.zhilyuk.task4.exception.DaoException;
import com.zhilyuk.task4.service.impl.ClientServiceImpl;
import jakarta.servlet.http.HttpServletRequest;

public class SignUpCommand implements Command {
    private static final String HOME_PAGE = "/pages/home.jsp";
    private static final String ERROR_PAGE = "/pages/error.jsp";

    public String execute(HttpServletRequest request) {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        ClientServiceImpl service = new ClientServiceImpl(new ClientDaoImpl());
        try {
            Client client = service.signUp(username, email, password);
            request.getSession().setAttribute("client", client);
        } catch (DaoException e) {
            request.setAttribute("error", "Dao error!");
            return ERROR_PAGE;
        }
        return HOME_PAGE;
    }
}
