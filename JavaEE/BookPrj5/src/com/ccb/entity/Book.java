package com.ccb.entity;

import java.math.BigDecimal;

public class Book {
    private int id;
    private String bname;
    private BigDecimal price;
    private String author;
    private Integer sales;
    private Integer stock;
    private String imgPath = "static/img/default.jpg";// 赋一个默认值

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bname='" + bname + '\'' +
                ", price=" + price +
                ", author='" + author + '\'' +
                ", sales=" + sales +
                ", stock=" + stock +
                ", imgPath='" + imgPath + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public Book(int id, String bname, BigDecimal price, String author, Integer sales, Integer stock, String imgPath) {
        this.id = id;
        this.bname = bname;
        this.price = price;
        this.author = author;
        this.sales = sales;
        this.stock = stock;
        if(imgPath != null && ! "".equals(imgPath)){
            this.imgPath = imgPath;
        }
    }

    public Book(String bname, BigDecimal price, String author, Integer sales, Integer stock, String imgPath) {
        this.bname = bname;
        this.price = price;
        this.author = author;
        this.sales = sales;
        this.stock = stock;
        if(imgPath != null && ! "".equals(imgPath)){
            this.imgPath = imgPath;
        }
    }

    public Book() {
    }
}
