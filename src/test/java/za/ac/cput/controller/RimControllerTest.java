package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import za.ac.cput.domain.Material;
import za.ac.cput.domain.Rim;
import za.ac.cput.factory.RimFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class RimControllerTest {

//    private static final RimController controller = RimController.getController();

    private static Rim rim = RimFactory.createRim(
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

//    @Test
//    @Order(1)
//    void create() {
//
////        Rim created = controller.create(rim);
//
//        assertNotNull(created);
//        assertEquals(rim.getProductID(), created.getProductID());
//
//        System.out.println(created);
//    }

//    @Test
//    @Order(2)
//    void read() {
//
//        Rim read = controller.read("P002");
//
//        assertNotNull(read);
//
//        System.out.println(read);
//    }

    @Test
    @Order(3)
    void update() {

        Rim updated = RimFactory.createRim(
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

//        Rim result = controller.update(updated);
//
//        assertNotNull(result);
//        assertEquals(4200.00, result.getPrice());
//
////        System.out.println(result);
////    }
//
//    @Test
//    @Order(4)
//    void getAll() {
//
//        assertFalse(controller.getAll().isEmpty());
//
//        System.out.println(controller.getAll());
//    }

//    @Test
//    @Order(5)
//    void delete() {
//
//        assertTrue(controller.delete("P002"));
//
//        System.out.println(controller.getAll());
//    }
}
}