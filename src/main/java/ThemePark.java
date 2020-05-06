import attractions.Attraction;
import behaviours.IReviewed;
import people.Visitor;
import stalls.Stall;

import java.util.ArrayList;

public class ThemePark {
    private ArrayList<Attraction> attractions;
    private ArrayList<Stall> stalls;
    ArrayList<IReviewed> reviewed = new ArrayList<>();

    public ThemePark(ArrayList<Attraction> attractions, ArrayList<Stall> stalls) {
        this.attractions = attractions;
        this.stalls = stalls;
    }

    public ArrayList<IReviewed> getAllReviewed(){

        reviewed.addAll(attractions);

        reviewed.addAll(stalls);
        
        return reviewed;
    }

    public int getReviewedSize(){
        return reviewed.size();
    }

    public void visit(Visitor visitor, Attraction attraction) {

        visitor.canVisit(attraction);

    }
}
