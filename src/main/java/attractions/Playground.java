package attractions;

import behaviours.ISecurity;
import people.Visitor;

public class Playground extends Attraction implements ISecurity {

    public Playground(String name, int rating) {
        super(name, rating);
    }

    @Override
    public boolean isAllowedTo(Visitor visitor) {
        boolean allowed = false;

        if(visitor.getAge() <= 15) {
            allowed = true;
            hadVisitor();
        }

        return allowed;
    }
}
