package com.zhilyuk.task4.command;

import com.zhilyuk.task4.dao.impl.ClientDaoImpl;
import com.zhilyuk.task4.entity.Client;
import com.zhilyuk.task4.exception.DaoException;
import com.zhilyuk.task4.service.ClientService;
import com.zhilyuk.task4.service.impl.ClientServiceImpl;
import jakarta.servlet.http.HttpServletRequest;

public class SignInCommand implements Command {
    private static final String HOME_PAGE = "/pages/home.jsp";
    private static final String SIGN_IN_PAGE = "/pages/signin.jsp";
    private static final String ERROR_PAGE = "/pages/error.jsp";

    public String execute(HttpServletRequest request) {
        String username = request.getParameter("email");
        String password = request.getParameter("password");

        ClientService service = new ClientServiceImpl(new ClientDaoImpl());
        try {
            Client client = service.signIn(username, password);

            if (client != null) {
                request.getSession().setAttribute("client", client);
                return HOME_PAGE;
            } else {
                request.setAttribute("error", "Sign in error!");
                return SIGN_IN_PAGE;
            }

        } catch (DaoException e) {
            request.setAttribute("error", "Dao error!");
            return ERROR_PAGE;
        }
    }
}
