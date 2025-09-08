package beverages_decorator;

public class WhippedCream extends CondimentDecorator {

    public WhippedCream(Beverage beverage) {
        super(beverage);
    }

    @Override
    public int cost() {
        return beverage.cost() + 6;
    }
}
