package com.zhilyuk.task4.controller;

import com.zhilyuk.task4.command.Command;
import com.zhilyuk.task4.command.CommandType;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class Controller extends HttpServlet {
    private static final Logger logger = LogManager.getLogger();

    public void init(ServletConfig config) throws ServletException {
        super.init();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        processRequest(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        processRequest(request, response);
    }

    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        final String commandStr = request.getParameter("command");
        final Command command = CommandType.define(commandStr);
        final String page = command.execute(request);

        logger.debug("Forwarding to page: {}.", page);
        request.getRequestDispatcher(page).forward(request, response);
    }
}
