package za.ac.cput.factory;

/**
 * RimFactoryTest.java
 * Creates Rim test
 * Author: Tlou Masebe (230128521)
 * Date: 28 June 2026
 */

import za.ac.cput.domain.Material;
import za.ac.cput.domain.Rim;

public class RimFactoryTest {

    public static void main(String[] args) {

        Rim rim = RimFactory.createRim(
                "P002",
                "RS Alloy",
                "BBS",
                3999.99,
                8,
                18.0,
                8.5,
                "5x112",
                35,
                Material.ALLOY,
                "Black"
        );

        if (rim != null) {
            System.out.println("Rim created successfully:");
            System.out.println(rim);
        } else {
            System.out.println("Rim creation failed.");
        }
    }
}