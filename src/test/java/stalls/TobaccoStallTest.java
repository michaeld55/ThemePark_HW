package stalls;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.*;

public class TobaccoStallTest {

    TobaccoStall tobaccoStall;
    Visitor visitor;

    @Before
    public void setUp() throws Exception {
        visitor = new Visitor(10, 123, 10.00);
        tobaccoStall = new TobaccoStall("Jacks Drum", "Jack Jarvis", ParkingSpot.B1, 3);
    }

    @Test
    public void hasName() {
        assertEquals("Jacks Drum", tobaccoStall.getName());
    }

    @Test
    public void hasOwner() {
        assertEquals("Jack Jarvis", tobaccoStall.getOwnerName());
    }

    @Test
    public void hasParkingSpot() {
        assertEquals(ParkingSpot.B1, tobaccoStall.getParkingSpot());
    }

    @Test
    public void hasRating(){
        assertEquals(3, tobaccoStall.getRating());
    }

    @Test
    public void checksAge(){

        assertFalse(tobaccoStall.isAllowedTo(visitor));
        visitor = new Visitor(20, 123, 10.00);
        assertTrue(tobaccoStall.isAllowedTo(visitor));
    }
}
