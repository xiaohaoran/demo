package com.xhr.mongodb.service;

import com.xhr.mongodb.dao.MongoDao;
import com.xhr.mongodb.entity.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MongoService {

    @Autowired
    private MongoDao mongoDao;

    public void save(Stock stock) {
        mongoDao.save(stock);
    }

    public List<Stock> findByConditions(Stock stock) {
        return mongoDao.findByConditions(stock);
    }

    public void deleteByNumber(String stockNumber) {
        mongoDao.deleteByNumber(stockNumber);
    }
}
