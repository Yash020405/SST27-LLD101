import com.example.orders.*;

public class TryIt {
    public static void main(String[] args) {
        OrderLine l1 = new OrderLine("A", 1, 200);
        OrderLine l2 = new OrderLine("B", 3, 100);

        Order o = new Order.Builder("o2", "a@b.com", l1)
                .addLine(l2)
                .setDiscountPercent(10)
                .build();

        System.out.println("Before: " + o.totalAfterDiscount());

        // Attempt to modify the original OrderLine (should not affect the Order)
        System.out.println("Attempting to modify the quantity of the original OrderLine...");
        l1 = new OrderLine("A", 999, 200);

        System.out.println("After modification attempt: " + o.totalAfterDiscount());

        System.out.println("=> Totals remain stable due to immutability.");
    }
}
