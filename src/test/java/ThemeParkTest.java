
import attractions.Attraction;
import attractions.Dodgems;
import attractions.RollerCoaster;
import org.junit.Before;
import org.junit.Test;
import people.Visitor;
import stalls.ParkingSpot;
import stalls.Stall;
import stalls.TobaccoStall;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ThemeParkTest {

    ThemePark themePark;
    Dodgems dodgems;
    TobaccoStall tobaccoStall;
    Visitor visitor;
    RollerCoaster rollerCoaster;

    @Before
    public void setUp() {
        dodgems = new Dodgems("Bumper Cars", 5);
        rollerCoaster = new RollerCoaster("Blue Ridge", 10);
        ArrayList<Attraction> attractions = new ArrayList<>();
        attractions.add(dodgems);
        attractions.add(rollerCoaster);
        tobaccoStall = new TobaccoStall("Jacks Drum", "Jack Jarvis", ParkingSpot.B1, 3);
        ArrayList<Stall> stalls = new ArrayList<>();
        stalls.add(tobaccoStall);
        themePark = new ThemePark(attractions, stalls);
        visitor = new Visitor(14, 1.2, 40.0);
    }

    @Test
    public void hasAttractionsStalls(){
        themePark.getAllReviewed();
        assertEquals(3, themePark.getReviewedSize());
    }

    @Test
    public void canVisit(){
        themePark.visit(visitor, rollerCoaster);
        themePark.visit(visitor, dodgems);
        assertEquals(1, visitor.getAttractionsSize());
        assertEquals(0, rollerCoaster.getVisitCount());
        assertEquals(1, dodgems.getVisitCount());

    }

    @Test
    public void testCanAfford(){
        visitor = new Visitor(18, 200, 9.0);
        themePark.visit(visitor, rollerCoaster);
        themePark.visit(visitor, dodgems);

        assertEquals(1, visitor.getAttractionsSize());
        assertEquals(1, rollerCoaster.getVisitCount());
        assertEquals(0, dodgems.getVisitCount());
    }
}
