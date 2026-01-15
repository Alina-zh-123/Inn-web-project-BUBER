package com.zhilyuk.task4.dao;

import com.zhilyuk.task4.entity.Driver;

import java.util.ArrayList;

public interface CarDao {
    ArrayList<Driver> findAll(int id);
    void deleteById(int id);
}
