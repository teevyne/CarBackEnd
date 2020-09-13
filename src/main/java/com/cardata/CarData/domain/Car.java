package com.cardata.CarData.domain;

import org.springframework.context.annotation.Bean;

import javax.persistence.*;

@Entity
@Table(name = "car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String brand, color, model, registerNumber;

    private int year, price;

    public Car(){

    }

//    public Car(String brand, String color, String model, String registerNumber, int year, int price){
////        this.id = id;
//        this.brand = brand;
//        this.color = color;
//        this.color = color;
//        this.model = model;
//        this.registerNumber = registerNumber;
//        this.year = year;
//        this.price = price;
//    }

    public Car(String brand, String color, String model, String registerNumber, int year, int price, Owner owner){
//        this.id = id;
        this.brand = brand;
        this.color = color;
        this.color = color;
        this.model = model;
        this.registerNumber = registerNumber;
        this.year = year;
        this.price = price;
        this.owner = owner;
    }

//    public Long getId() {
//        return id;
//    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getRegisterNumber() {
        return registerNumber;
    }

    public void setRegisterNumber(String registerNumber) {
        this.registerNumber = registerNumber;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @ManyToOne
    private Owner owner;

    public Owner getOwner() {
        return owner;
    }
//
//    public void setOwner(Owner owner) {
//        this.owner = owner;
//    }
}
