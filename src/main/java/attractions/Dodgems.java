package attractions;

import behaviours.ITicketed;
import people.Visitor;

public class Dodgems extends Attraction implements ITicketed {

    public Dodgems(String name, int rating) {
        super(name, rating);
    }

    @Override
    public double defaultPrice() {
        return 4.50;
    }

    @Override
    public double priceFor(Visitor visitor) {
        double price = 0;
        if(visitor.getAge() < 12) {
            price = defaultPrice() * 0.5;
        }else {
            price = defaultPrice();
        }
        return price;
    }
}
