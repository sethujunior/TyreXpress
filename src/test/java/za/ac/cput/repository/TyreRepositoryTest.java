package za.ac.cput.repository;

/**
 * TyreRepositoryTest.java
 * Testing CRUD operations for Tyre Repository
 * Author: Tlou Masebe (230128521)
 * Date: 29 June 2026
 */

import za.ac.cput.domain.Tyre;
import za.ac.cput.factory.TyreFactory;

public class TyreRepositoryTest {

    public static void main(String[] args) {

//        TyreRepositoryImpl repository = TyreRepositoryImpl.getRepository();

        // Create
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

//        repository.create(tyre);

        System.out.println("Created:");
        System.out.println(tyre);

        // Read
        System.out.println("\nRead:");
//        System.out.println(repository.read("P001"));

        Tyre updatedTyre = TyreFactory.createTyre(
                "P001",
                "Pilot Sport 5",
                "Michelin",
                3100.00,
                15,
                "225/45R17",
                "Summer",
                "94",
                "W",
                true
        );

//        repository.update(updatedTyre);

        System.out.println("\nUpdated:");
//        System.out.println(repository.read("P001"));

        // Get All
        System.out.println("\nAll Tyres:");
//        System.out.println(repository.getAll());

        // Delete
//        repository.delete("P001");

        System.out.println("\nAfter Delete:");
//        System.out.println(repository.getAll());
    }
}