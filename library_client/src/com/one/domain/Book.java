package com.one.domain;

public class Book {

    private Integer id     ;// int(11)       (NULL)           NO      MUL     (NULL)   auto_increment  select,insert,update,references
    private String name   ;// varchar(32)   utf8_general_ci  YES             (NULL)                   select,insert,update,references
    private String description   ;// varchar(200)  utf8_general_ci  YES             (NULL)                   select,insert,update,references
    private String author ;// varchar(32)   utf8_general_ci  YES             (NULL)                   select,insert,update,references
    private Double price  ;// double(4,2)   (NULL)           YES             (NULL)                   select,insert,update,references
    private Integer stock  ;// int(11)       (NULL)           YES             (NULL)                   select,insert,update,references

    public Book() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
