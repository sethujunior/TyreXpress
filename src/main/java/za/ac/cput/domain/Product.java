package za.ac.cput.domain;

import jakarta.persistence.*;


@Table(name = "product")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Product {

    @Id
    protected String productID;
    protected String name;
    protected String brand;
    protected double price;
    protected int stock;

    public Product() {
    }

    public Product(Builder builder) {
        this.productID = builder.productID;
        this.name = builder.name;
        this.brand = builder.brand;
        this.price = builder.price;
        this.stock = builder.stock;
    }

    public String getProductID() {
        return productID;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productID='" + productID + '\'' +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                '}';
    }

    public static abstract class Builder {

        protected String productID;
        protected String name;
        protected String brand;
        protected double price;
        protected int stock;

        public Builder setProductID(String productID) {
            this.productID = productID;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setBrand(String brand) {
            this.brand = brand;
            return this;
        }

        public Builder setPrice(double price) {
            this.price = price;
            return this;
        }

        public Builder setStock(int stock) {
            this.stock = stock;
            return this;
        }

        public Builder copy(Product product) {
            this.productID = product.productID;
            this.name = product.name;
            this.brand = product.brand;
            this.price = product.price;
            this.stock = product.stock;

            return this;
        }
    }
}