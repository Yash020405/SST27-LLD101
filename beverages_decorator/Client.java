package beverages_decorator;

public class Client {

	public static void main(String[] args) {

		Beverage coffee = new Cappuccino();
		coffee = new Milk(coffee);
		coffee = new Sugar(coffee);
		coffee = new Chocolate(coffee);

		System.out.println("Cappuccino with Milk, Sugar, and Chocolate: " + coffee.cost());

		Beverage latte = new Latte();
		latte = new Milk(latte);
		latte = new Milk(latte);
		latte = new Sugar(latte);
		latte = new WhippedCream(latte);

		System.out.println("Latte with Double Milk, Sugar, and Whipped Cream: " + latte.cost());
	}
}