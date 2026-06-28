package za.ac.cput.factory;

import za.ac.cput.domain.Material;
import za.ac.cput.domain.Rim;

public class RimFactory {

    public static Rim createRim (String productID,
                                String name,
                                String brand,
                                double price,
                                int stock,
                                double diameter,
                                double width,
                                String boltPattern,
                                int offset,
                                Material material,
                                String color) {

        if (productID == null || productID.isEmpty()) return null;
        if (name == null || name.isEmpty()) return null;
        if (brand == null || brand.isEmpty()) return null;
        if (price <= 0) return null;
        if (stock < 0) return null;
        if (diameter <= 0) return null;
        if (width <= 0) return null;
        if (boltPattern == null || boltPattern.isEmpty()) return null;
        if (material == null) return null;
        if (color == null || color.isEmpty()) return null;

        Rim.Builder builder = new Rim.Builder();

        builder.setProductID(productID);
        builder.setName(name);
        builder.setBrand(brand);
        builder.setPrice(price);
        builder.setStock(stock);

        builder.setDiameter(diameter);
        builder.setWidth(width);
        builder.setBoltPattern(boltPattern);
        builder.setOffset(offset);
        builder.setMaterial(material);
        builder.setColor(color);

        return builder.build();
    }
}