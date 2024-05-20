package test.java;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.Customer;
import main.java.Theater;

import java.util.ArrayList;

public class App_test {
    private Theater theater;
    private Customer customer1;
    private Customer customer2;
    private Customer customer3;
    private Customer customer4;
    private Customer customer5;
    private Customer customer6;

    @BeforeEach
    public void setUp() {
        customer1 = new Customer("Alice", 65);  // 65 inches tall
        customer2 = new Customer("Bob", 68);    // 68 inches tall
        customer3 = new Customer("Charlie", 72); // 72 inches tall
        customer4 = new Customer("Dave", 66);   // 66 inches tall
        customer5 = new Customer("Eve", 60);    // 60 inches tall
        customer6 = new Customer("Frank", 69);  // 69 inches tall

        ArrayList<Customer> customerList = new ArrayList<>();
        customerList.add(customer1);
        customerList.add(customer2);
        customerList.add(customer3);
        customerList.add(customer4);
        customerList.add(customer5);
        customerList.add(customer6);

        theater = new Theater(4, 2, customerList);
    }

    @Test
    public void testIsSeatOccupied_SeatOccupied() {
        assertTrue(theater.isSeatOccupied(0, 0));
    }

    @Test
    public void testIsSeatOccupied_SeatNotOccupied() {
        assertFalse(theater.isSeatOccupied(3, 1));
    }

    @Test
    public void testIsSeatOccupied_BoundaryCase() {
        assertFalse(theater.isSeatOccupied(4, 1));
    }

    @Test
    public void testGetTallestCustomer_SingleTallestCustomer() {
        assertEquals(customer3, theater.getTallestCustomer());
    }

    @Test
    public void testGetTallestCustomer_MultipleCustomers() {
        theater.seats[2][1] = new Customer("George", 72);  // Same height as Charlie
        assertEquals(customer3, theater.getTallestCustomer());  // Should still return the first tallest customer
    }

    @Test
    public void testGetTallestCustomer_NoCustomers() {
        Theater emptyTheater = new Theater(3, 2, new ArrayList<>());
        assertNull(emptyTheater.getTallestCustomer());
    }

    @Test
    public void testFindMostOccupiedRow_SingleMostOccupiedRow() {
        assertEquals(0, theater.findMostOccupiedRow());  // Row 0 has 2 customers
    }

    @Test
    public void testFindMostOccupiedRow_MultipleRows() {
        theater.seats[1][1] = new Customer("Helen", 67);
        assertEquals(0, theater.findMostOccupiedRow());  // Row 0 still has 2 customers
    }

    @Test
    public void testFindMostOccupiedRow_NoOccupiedSeats() {
        Theater emptyTheater = new Theater(3, 2, new ArrayList<>());
        assertEquals(-1, emptyTheater.findMostOccupiedRow());
    }

    @Test
    public void testGetCustomersToBeMoved_SingleMove() {
        ArrayList<Customer> toBeMoved = theater.getCustomersToBeMoved();
        assertTrue(toBeMoved.contains(customer4));
        assertEquals(1, toBeMoved.size());
    }

    @Test
    public void testGetCustomersToBeMoved_MultipleMoves() {
        theater.seats[1][1] = new Customer("Helen", 59); // Helen is 9 inches shorter than Frank
        ArrayList<Customer> toBeMoved = theater.getCustomersToBeMoved();
        assertTrue(toBeMoved.contains(customer4));
        assertTrue(toBeMoved.contains(theater.seats[1][1]));
        assertEquals(2, toBeMoved.size());
    }

    @Test
    public void testGetCustomersToBeMoved_NoMoves() {
        Theater emptyTheater = new Theater(3, 2, new ArrayList<>());
        assertTrue(emptyTheater.getCustomersToBeMoved().isEmpty());
    }
}
