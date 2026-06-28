package za.ac.cput.factory;

/**
 * TyreFactoryTest.java
 * Creates Tyre test
 * Author: Tlou Masebe (230128521)
 * Date: 28 June 2026
 */

import za.ac.cput.domain.Tyre;

public class TyreFactoryTest {

    public static void main(String[] args) {

        Tyre tyre = TyreFactory.createTyre(
                "P001",
                "Pilot Sport 5",
                "Michelin",
                2899.99,
                15,
                "225/45R17",
                "Summer",
                "94",
                "W",
                true
        );

        if (tyre != null) {
            System.out.println("Tyre created successfully:");
            System.out.println(tyre);
        } else {
            System.out.println("Tyre creation failed.");
        }
    }
}