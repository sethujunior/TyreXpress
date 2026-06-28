package za.ac.cput.factory;

import za.ac.cput.domain.Tyre;

public class TyreFactory {

    public static Tyre createTyre(String productID,
                                  String name,
                                  String brand,
                                  double price,
                                  int stock,
                                  String size,
                                  String season,
                                  String loadIndex,
                                  String speedRating,
                                  Boolean runFlat) {

        if (productID == null || productID.isEmpty()) return null;
        if (name == null || name.isEmpty()) return null;
        if (brand == null || brand.isEmpty()) return null;
        if (price <= 0) return null;
        if (stock < 0) return null;
        if (size == null || size.isEmpty()) return null;
        if (season == null || season.isEmpty()) return null;
        if (loadIndex == null || loadIndex.isEmpty()) return null;
        if (speedRating == null || speedRating.isEmpty()) return null;
        if (runFlat == null) return null;

        Tyre.Builder builder = new Tyre.Builder();

        builder.setProductID(productID);
        builder.setName(name);
        builder.setBrand(brand);
        builder.setPrice(price);
        builder.setStock(stock);

        builder.setSize(size);
        builder.setSeason(season);
        builder.setLoadIndex(loadIndex);
        builder.setSpeedRating(speedRating);
        builder.setRunFlat(runFlat);

        return builder.build();
    }
}