package people;

import attractions.Attraction;
import behaviours.ISecurity;
import behaviours.ITicketed;

import java.util.ArrayList;

public class Visitor {

    private int age;
    private double height;
    private double money;
    private ArrayList<Attraction> attractions;

    public Visitor(int age, double height, double money) {
        this.age = age;
        this.height = height;
        this.money = money;
        this.attractions = new ArrayList<>();
    }

    public int getAge() {
        return age;
    }

    public double getHeight() {
        return height;
    }

    public double getMoney() {
        return money;
    }

    public void addAttraction(Attraction attraction){

        attractions.add(attraction);
    }

    public int getAttractionsSize() {
        return attractions.size();
    }

    public void canVisit(Attraction attraction) {
        if(this.canAfford(attraction)) {
            if (attraction instanceof ISecurity) {
                if(((ISecurity) attraction).isAllowedTo(this)) this.attractions.add(attraction);


            } else {
                this.addAttraction(attraction);
                attraction.setVisitCount(1);
            }
        }
    }

    private boolean canAfford(Attraction attraction) {
        boolean afford = false;
        if(attraction instanceof ITicketed) {
            if (this.money >= ((ITicketed) attraction).priceFor(this)) {
                this.money -= ((ITicketed) attraction).priceFor(this);
                afford = true;

            }
        }else{
            afford = true;
        }
        return afford;
    }
}
