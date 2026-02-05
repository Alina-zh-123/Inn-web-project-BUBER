package com.zhilyuk.task4.command;

import com.zhilyuk.task4.exception.DaoException;
import jakarta.servlet.http.HttpServletRequest;

public interface Command {
    String execute(HttpServletRequest request);
}
