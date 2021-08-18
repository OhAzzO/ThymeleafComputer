package com.example.ThymeleafComputer.Entity;


public class Computers {

    private int id;
    private String overview;
    private String systemComponents;
    private double price;


    public Computers(int id, String overview, String systemComponents, double price) {
        this.id = id;
        this.overview = overview;
        this.systemComponents = systemComponents;
        this.price = price;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getSystemComponents() {
        return systemComponents;
    }

    public void setSystemComponents(String systemComponents) {
        this.systemComponents = systemComponents;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }





}
