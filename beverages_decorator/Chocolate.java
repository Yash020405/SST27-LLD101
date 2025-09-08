package beverages_decorator;

public class Chocolate extends CondimentDecorator {

    public Chocolate(Beverage beverage) {
        super(beverage);
    }

    @Override
    public int cost() {
        return beverage.cost() + 7;
    }
}
