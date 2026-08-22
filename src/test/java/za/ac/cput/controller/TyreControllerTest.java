package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import za.ac.cput.domain.Tyre;
import za.ac.cput.factory.TyreFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TyreControllerTest {

//    private static final TyreController controller = TyreController.getController();

    private static Tyre tyre = TyreFactory.createTyre(
            "P001",
            "Pilot Sport 5",
            "Michelin",
            2899.99,
            10,
            "225/45R17",
            "Summer",
            "94",
            "W",
            true
    );

//    @Test
//    @Order(1)
//    void create() {
//
//        Tyre created = controller.create(tyre);
//
//        assertNotNull(created);
//        assertEquals(tyre.getProductID(), created.getProductID());
//
//        System.out.println(created);
//    }

//    @Test
//    @Order(2)
//    void read() {
//
//        Tyre read = controller.read("P001");
//
//        assertNotNull(read);
//
//        System.out.println(read);
//    }

    @Test
    @Order(3)
    void update() {

        Tyre updated = TyreFactory.createTyre(
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

//        Tyre result = controller.update(updated);
//
//        assertNotNull(result);
//        assertEquals(3100.00, result.getPrice());
//
//        System.out.println(result);
    }

//    @Test
//    @Order(4)
//    void getAll() {
//
//        assertFalse(controller.getAll().isEmpty());
//
//        System.out.println(controller.getAll());
//    }
//
//    @Test
//    @Order(5)
//    void delete() {
//
//        assertTrue(controller.delete("P001"));
//
//        System.out.println(controller.getAll());
//    }
}