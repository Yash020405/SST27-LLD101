public class OrderRepo implements IOrderRepo {

    @Override
    public void save(){
        System.out.println("Order stored (pretend DB).");
    }
}
