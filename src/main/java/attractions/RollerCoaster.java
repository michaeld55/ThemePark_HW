package attractions;

import behaviours.ISecurity;
import behaviours.ITicketed;
import people.Visitor;

public class RollerCoaster  extends Attraction implements ISecurity, ITicketed {

    public RollerCoaster(String name, int rating) {
        super(name, rating);
    }

    @Override
    public boolean isAllowedTo(Visitor visitor) {
        boolean allowed = false;
        if(visitor.getAge() > 12 && visitor.getHeight() > 145) {
            allowed = true;
            hadVisitor();
        }
        return allowed;
    }

    @Override
    public double defaultPrice() {
        return 8.40;
    }

    @Override
    public double priceFor(Visitor visitor) {
        double price = 0;
        if(visitor.getHeight() > 200) {
            price = defaultPrice() * 2;
        }else {
            price = defaultPrice();
        }
        return price;
    }
}
