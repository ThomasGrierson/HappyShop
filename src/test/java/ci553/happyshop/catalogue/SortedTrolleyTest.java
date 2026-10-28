package ci553.happyshop.catalogue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SortedTrolleyTest {

    @Test
    void addProduct() {
        SortedTrolley Trolley = new SortedTrolley();
        Product p1 = new Product("0001", "1", "0001", 1.10, 999);
        Product p2 = new Product("0002", "2", "0002", 2.10, 999);
        Product p3 = new Product("0003", "3", "0003", 3.10, 999);
        Product p4 = new Product("0004", "4", "0004", 4.10, 999);
        Product p5 = new Product("0005", "5", "0005", 5.10, 999);

        Trolley.addProduct(p3);

        assertEquals("0003", Trolley.getProducts().get(0).getProductId());

        Trolley.addProduct(p1);

        assertEquals("0001", Trolley.getProducts().get(1).getProductId());

        Trolley.addProduct(p5);

        assertEquals("0005", Trolley.getProducts().get(0).getProductId());

        Trolley.addProduct(p3);

        assertEquals(2, Trolley.getProducts().get(1).getOrderedQuantity());
    }

    @Test
    void getProducts() {
    }
}