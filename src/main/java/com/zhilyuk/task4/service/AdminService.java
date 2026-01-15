package com.zhilyuk.task4.service;

import com.zhilyuk.task4.entity.Client;
import com.zhilyuk.task4.entity.Driver;

public interface AdminService {
    void setBonus(Client client);
    void setBanClient(Client client);
    void setBanDriver(Driver Driver);
}
