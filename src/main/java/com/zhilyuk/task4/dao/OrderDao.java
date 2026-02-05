package com.zhilyuk.task4.dao;

import com.zhilyuk.task4.entity.Order;
import com.zhilyuk.task4.exception.DaoException;

public interface OrderDao {
    public void save(Order order) throws DaoException;
    void deleteById(int id) throws DaoException;
}
