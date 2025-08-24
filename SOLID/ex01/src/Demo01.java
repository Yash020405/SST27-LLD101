

public class Demo01 {
    public static void main(String[] args) {
        TaxCalculator tax = new TaxCalculator(0.18);
        INotifier notifier = new EmailNotifier();
        OrderRepo repo = new OrderRepo();

        OrderService service = new OrderService(tax, notifier, repo);
        service.checkout("a@shop.com", 100.0);
    }
}
