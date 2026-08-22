package za.ac.cput.repository;

/**
 * RimRepositoryTest.java
 * Testing CRUD operations for Rim Repository
 * Author: Tlou Masebe (230128521)
 * Date: 29 June 2026
 */

import za.ac.cput.domain.Material;
import za.ac.cput.domain.Rim;
import za.ac.cput.factory.RimFactory;

public class RimRepositoryTest {

    public static void main(String[] args) {

//        RimRepositoryImpl repository = RimRepositoryImpl.getRepository();

        // Create
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

//        repository.create(rim);

        System.out.println("Created:");
        System.out.println(rim);

        // Read
        System.out.println("\nRead:");
//        System.out.println(repository.read("P002"));

        // Update
        Rim updatedRim = RimFactory.createRim(
                "P002",
                "RS Alloy",
                "BBS",
                4200.00,
                8,
                18.0,
                8.5,
                "5x112",
                35,
                Material.ALLOY,
                "Black"
        );

//        repository.update(updatedRim);

        System.out.println("\nUpdated:");
//        System.out.println(repository.read("P002"));

        // Get All
        System.out.println("\nAll Rims:");
//        System.out.println(repository.getAll());

        // Delete
//        repository.delete("P002");

        System.out.println("\nAfter Delete:");
//        System.out.println(repository.getAll());
    }
}