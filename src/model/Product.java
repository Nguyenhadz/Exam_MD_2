package model;


import java.io.Serializable;

public class Product implements Serializable {
    private static long serialUID = 123456789;
    public static int INDEX = 0;
    private int id;
    private String name;
    private double price;
    private int quantity;
    private String description;

    public Product() {}

    public Product(String name, double price, int quantity, String description) {
        this.id = ++INDEX;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.description = description;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", description='" + description + '\'' +
                '}';
    }

}

