package com.zhilyuk.task4.dao;

import com.zhilyuk.task4.entity.Car;
import com.zhilyuk.task4.entity.Driver;
import com.zhilyuk.task4.exception.DaoException;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CarDao {
    ArrayList<Car> findAll() throws DaoException;
}
