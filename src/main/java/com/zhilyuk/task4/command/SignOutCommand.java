package com.zhilyuk.task4.command;

import jakarta.servlet.http.HttpServletRequest;

public class SignOutCommand implements Command {
    private static final String SIGN_IN_PAGE = "/pages/signin.jsp";

    public String execute(HttpServletRequest request) {
        request.getSession().invalidate();
        return SIGN_IN_PAGE;
    }
}
