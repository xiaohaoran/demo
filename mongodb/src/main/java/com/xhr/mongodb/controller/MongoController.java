package com.xhr.mongodb.controller;


import com.xhr.mongodb.entity.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.xhr.mongodb.service.MongoService;

import java.util.List;

@RestController
@RequestMapping(value = "mongo")
public class MongoController {

    @Autowired
    private MongoService mongoService;

    @GetMapping(value = "/list")
    public List<Stock> list(@RequestParam String search) {

        Stock stock = new Stock();
        stock.setStockName(search);
        return mongoService.findByConditions(stock);
    }

    @GetMapping(value = "save")
    public Stock save (Stock stock) {
        try {
            mongoService.save(stock);

            return stock;
        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping(value = "deleteByNumber")
    public void deleteByNumber(@RequestParam String stockNumber) {
        mongoService.deleteByNumber(stockNumber);
    }

    @GetMapping(value = "/test")
    public String test() {
        return "test success";
    }
}
