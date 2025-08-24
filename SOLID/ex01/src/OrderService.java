public class OrderService {

    private final TaxCalculator txCal;
    private final INotifier notifier;
    private final OrderRepo repo;

    public OrderService(TaxCalculator txCal , INotifier notifier, OrderRepo repo){
        this.txCal = txCal;
        this.notifier = notifier;
        this.repo = repo;
    }

    public void checkout(String customerEmail, double subtotal) {
        double total = txCal.calculate(subtotal);
        notifier.send(customerEmail, "Thanks! Your total is " + total);
        repo.save();
    }
}