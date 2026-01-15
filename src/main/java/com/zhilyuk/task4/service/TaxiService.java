package com.zhilyuk.task4.service;

import com.zhilyuk.task4.entity.Order;

public interface TaxiService {
    void acceptOrder(Order order);
    double setPrice(Order order);
    void finishOrder(Order order);
}
