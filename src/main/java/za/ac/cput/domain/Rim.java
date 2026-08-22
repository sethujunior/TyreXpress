package za.ac.cput.domain;

import jakarta.persistence.*;

@Table(name = "rim")
public class Rim extends Product {

    private double diameter;
    private double width;
    private String boltPattern;
    private int offset;
    private Material material;
    private String color;

    public Rim() {
    }

    public Rim(Builder builder) {
        super(builder);

        this.diameter = builder.diameter;
        this.width = builder.width;
        this.boltPattern = builder.boltPattern;
        this.offset = builder.offset;
        this.material = builder.material;
        this.color = builder.color;
    }

    public double getDiameter() {
        return diameter;
    }

    public double getWidth() {
        return width;
    }

    public String getBoltPattern() {
        return boltPattern;
    }

    public int getOffset() {
        return offset;
    }

    public Material getMaterial() {
        return material;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Rim{" +
                "productID='" + productID + '\'' +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", diameter=" + diameter +
                ", width=" + width +
                ", boltPattern='" + boltPattern + '\'' +
                ", offset=" + offset +
                ", material=" + material +
                ", color='" + color + '\'' +
                '}';
    }

    public static class Builder extends Product.Builder {

        private double diameter;
        private double width;
        private String boltPattern;
        private int offset;
        private Material material;
        private String color;

        public Builder setDiameter(double diameter) {
            this.diameter = diameter;
            return this;
        }

        public Builder setWidth(double width) {
            this.width = width;
            return this;
        }

        public Builder setBoltPattern(String boltPattern) {
            this.boltPattern = boltPattern;
            return this;
        }

        public Builder setOffset(int offset) {
            this.offset = offset;
            return this;
        }

        public Builder setMaterial(Material material) {
            this.material = material;
            return this;
        }

        public Builder setColor(String color) {
            this.color = color;
            return this;
        }

        public Builder copy(Rim rim) {
            this.productID = rim.productID;
            this.name = rim.name;
            this.brand = rim.brand;
            this.price = rim.price;
            this.stock = rim.stock;
            this.diameter = rim.diameter;
            this.width = rim.width;
            this.boltPattern = rim.boltPattern;
            this.offset = rim.offset;
            this.material = rim.material;
            this.color = rim.color;

            return this;
        }

        public Rim build() {
            return new Rim(this);
        }
    }
}