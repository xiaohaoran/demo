package com.xhr.mongodb.entity;

import java.io.Serializable;

public class Stock implements Serializable {

    private final static long serialVersion = 1L;

    private String stockNumber;
    private String stockName;
    private Double price;

    public String getStockNumber() {
        return stockNumber;
    }

    public void setStockNumber(String stockNumber) {
        this.stockNumber = stockNumber;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
