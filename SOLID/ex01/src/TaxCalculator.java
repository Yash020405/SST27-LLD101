public class TaxCalculator {
    private final double taxRate;

    public TaxCalculator(double taxRate){
        this.taxRate = taxRate;
    }

    public double calculate(double subtotal){
        return subtotal + subtotal * taxRate;
    }
}