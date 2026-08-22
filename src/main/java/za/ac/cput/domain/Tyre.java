package za.ac.cput.domain;

import jakarta.persistence.*;


@Table(name = "tyre")
public class Tyre extends Product {

    private String size;
    private String season;
    private String loadIndex;
    private String speedRating;
    private Boolean runFlat;

    public Tyre() {
    }

    public Tyre(Builder builder) {
        super(builder);

        this.size = builder.size;
        this.season = builder.season;
        this.loadIndex = builder.loadIndex;
        this.speedRating = builder.speedRating;
        this.runFlat = builder.runFlat;
    }

    public String getSize() {
        return size;
    }

    public String getSeason() {
        return season;
    }

    public String getLoadIndex() {
        return loadIndex;
    }

    public String getSpeedRating() {
        return speedRating;
    }

    public Boolean getRunFlat() {
        return runFlat;
    }

    @Override
    public String toString() {
        return "Tyre{" +
                "productID='" + productID + '\'' +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", size='" + size + '\'' +
                ", season='" + season + '\'' +
                ", loadIndex='" + loadIndex + '\'' +
                ", speedRating='" + speedRating + '\'' +
                ", runFlat=" + runFlat +
                '}';
    }

    public static class Builder extends Product.Builder {

        private String size;
        private String season;
        private String loadIndex;
        private String speedRating;
        private Boolean runFlat;

        public Builder setSize(String size) {
            this.size = size;
            return this;
        }

        public Builder setSeason(String season) {
            this.season = season;
            return this;
        }

        public Builder setLoadIndex(String loadIndex) {
            this.loadIndex = loadIndex;
            return this;
        }

        public Builder setSpeedRating(String speedRating) {
            this.speedRating = speedRating;
            return this;
        }

        public Builder setRunFlat(Boolean runFlat) {
            this.runFlat = runFlat;
            return this;
        }

        public Builder copy(Tyre tyre) {
            this.productID = tyre.productID;
            this.name = tyre.name;
            this.brand = tyre.brand;
            this.price = tyre.price;
            this.stock = tyre.stock;

            this.size = tyre.size;
            this.season = tyre.season;
            this.loadIndex = tyre.loadIndex;
            this.speedRating = tyre.speedRating;
            this.runFlat = tyre.runFlat;

            return this;
        }

        public Tyre build() {
            return new Tyre(this);
        }
    }
}