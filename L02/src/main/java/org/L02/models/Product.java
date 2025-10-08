package org.L02.models;

public class Product {
    private String productName;
    private int quantity;

    public String getProductName(){ return this.productName; }
    public int getQuantity() { return this.quantity; }

    public void setProductName(String productName) { this.productName = productName; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public Product() {}
    public Product(String productName, int quantity){
        this.productName = productName;
        this.quantity = quantity;
    }
}
