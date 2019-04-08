package com.xhr.mongodb.dao;

import com.xhr.mongodb.entity.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.regex.Pattern;

@Component
public class MongoDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    public void save(Stock stock) {
        mongoTemplate.save(stock);
    }

    public Stock findByStockNumber(String stockNumber) {

        Query query = new Query(Criteria.where("stockNumber").is(stockNumber));

        Stock stock = mongoTemplate.findOne(query, Stock.class);

        return stock;
    }

    public List<Stock> findByConditions(Stock stock) {

        Pattern pattern = Pattern.compile("^.*"+stock.getStockName()+".*$", Pattern.CASE_INSENSITIVE);
        Query query = new Query(Criteria.where("stockName").regex(pattern));

        return mongoTemplate.find(query, Stock.class);
    }

    public void deleteByNumber(String stockNumber) {
        Query query = new Query(Criteria.where("stockNumber").is(stockNumber));
        mongoTemplate.remove(query, Stock.class);
    }


}
