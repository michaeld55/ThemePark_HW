package attractions;

import behaviours.ISecurity;
import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.assertEquals;

public class RollercoasterTest {

    RollerCoaster rollerCoaster;
    Visitor visitor;

    @Before
    public void setUp() {
        rollerCoaster = new RollerCoaster("Blue Ridge", 10);
        visitor = new Visitor(10, 123, 10.00);
    }

    @Test
    public void hasName() {
        assertEquals("Blue Ridge", rollerCoaster.getName());
    }

    @Test
    public void hasRating() {
        assertEquals(10, rollerCoaster.getRating());
    }

    @Test
    public void hasVisitCount() {
        assertEquals(0, rollerCoaster.getVisitCount());
    }

    @Test
    public void checksAgeHeightBeforeAdd(){
        rollerCoaster.isAllowedTo(visitor);
        visitor = new Visitor(18, 123, 10.00);
        rollerCoaster.isAllowedTo(visitor);
        visitor = new Visitor(18, 150, 10.00);
        rollerCoaster.isAllowedTo(visitor);
        assertEquals(1, rollerCoaster.getVisitCount());

    }

    @Test
    public void chargesTallPeopleMore(){

        assertEquals(8.40, rollerCoaster.priceFor(visitor), 0.01);
        visitor = new Visitor(18, 250, 10.00);
        assertEquals(8.40, rollerCoaster.priceFor(visitor), 0.01);
    }


}
